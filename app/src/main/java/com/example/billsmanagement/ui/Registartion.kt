package com.example.billsmanagement.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.billsmanagement.R
import com.example.billsmanagement.Utils.Constants
import com.example.billsmanagement.viewModel.UserViewModel
import com.example.billsmanagement.databinding.ActivityRegistartionBinding
import com.example.billsmanagement.models.RegisterRequest
import com.example.billsmanagement.models.RegisterResponse

class Registartion : AppCompatActivity() {
    val userViewModel:UserViewModel by viewModels()
    lateinit var binding: ActivityRegistartionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityRegistartionBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onResume() {
        super.onResume()
        binding.tvLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        binding.btnNext.setOnClickListener {
            validateRegistration()
            clearErrors()

        }

        userViewModel.regLiveData.observe(this, Observer { regResponse ->
            Toast.makeText(this, regResponse.messsage, Toast.LENGTH_LONG).show()
            startActivity(Intent(this, LoginActivity::class.java))
            binding.pbRegister.visibility = View.GONE
            finish()
        })
        userViewModel.errorLiveData.observe(this, Observer { err ->
            Toast.makeText(this, err, Toast.LENGTH_LONG).show()
            binding.pbRegister.visibility = View.GONE
        })

    }

    fun validateRegistration() {
        val firstname = binding.etFirstName.text.toString()
        val lastName = binding.etLastName.text.toString()
        val phoneNumber = binding.etPhoneNumber.text.toString()
        val email = binding.etEmail.text.toString()
        val password = binding.etPassword.text.toString()
        val confirmpassword = binding.etconfirmPassword.text.toString()
        var error = false
        if (firstname.isBlank()) {
            binding.tilFirstName.error = "Insert userName"
            error = true
        }
        if (lastName.isBlank()) {
            binding.tilLastName.error = "Enter PhoneNumber"
            error = true
        }
        if (email.isBlank()) {
            binding.tilEmail.error = "Enter E-mail"
            error = true
        }
        if (password.isBlank()) {
            binding.tilPassword.error = "Enter Your Password"
            error = true
        }
        if (confirmpassword != password) {
            binding.tilConfirmPassword.error = "Confirm the password you entered"
            error = true
        }
        if (!error) {
            val registarion = RegisterRequest(
                firstName = firstname,
                lastName = lastName,
                email = email,
                password = password,
                phoneNumber = phoneNumber,
            )
            binding.pbRegister.visibility=View.VISIBLE
            userViewModel.registerUser(registarion)
        }
    }

        fun clearErrors(){
            binding.tilFirstName.error = null
            binding.tilLastName.error=null
            binding.tilEmail.error = null
            binding.tilPassword.error = null
            binding.tilPhoneNumber.error = null
            binding.tilConfirmPassword.error = null

        }

    }
