package com.example.billsmanagement.ui

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.billsmanagement.Utils.Constants
import com.example.billsmanagement.databinding.ActivityLoginBinding
import com.example.billsmanagement.models.LoginRequest
import com.example.billsmanagement.models.LoginResponse
import com.example.billsmanagement.viewModel.LoginViewModel

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    val loginViewModel: LoginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        binding.btnHome.setOnClickListener {
            clearErrors()
            validateLogin()

        }
        loginViewModel.livedata.observe(this, Observer { logResponse ->
            persistLogin(logResponse)
            Toast.makeText(this, logResponse.message, Toast.LENGTH_LONG).show()
            startActivity(Intent(this, HomePage::class.java))
        })
        loginViewModel.errorLiveData.observe(this, Observer { error ->
            Toast.makeText(this, error, Toast.LENGTH_LONG).show()
        })
        binding.tvSignUp.setOnClickListener {
            startActivity(Intent(this, Registartion::class.java))
        }


    }


    fun validateLogin() {
        val email = binding.etemail.text.toString()
        val password = binding.etpassword.text.toString()

        var error = false
        if (email.isBlank()) {
            binding.tilemail.error = "Insert userName"
            error = true
        }
        if (password.isBlank()) {
            binding.tilpasswords.error = "Enter Password"
            error = true
        }

        if (!error) {
            val loginRequest = LoginRequest(
                password = password,
                email = email,
            )
            loginViewModel.loginUser(loginRequest)

        }
    }

    fun clearErrors() {
        binding.tilemail.error = null
        binding.tilpasswords.error = null

    }

    fun persistLogin(loginResponse: LoginResponse) {
        val sharePrefs = getSharedPreferences(Constants.PREFS, Context.MODE_PRIVATE)
        val editor = sharePrefs.edit()
        editor.putString("USER_ID", loginResponse.user_id)
        editor.apply()

    }
}



