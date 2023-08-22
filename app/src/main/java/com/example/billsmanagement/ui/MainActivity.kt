package com.example.billsmanagement.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.billsmanagement.R
import com.example.billsmanagement.Utils.Constants
import com.example.billsmanagement.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        redirectUser()
        android.os.Handler().postDelayed({
            val intent= Intent(this@MainActivity,Registartion::class.java)
            startActivity(intent)},6000)

    }

    fun redirectUser(){
        val prefs = getSharedPreferences(Constants.PREFS, Context.MODE_PRIVATE)
        val userId = prefs.getString(Constants.USER_ID, Constants.EMPTY_STRING)!!
        if (userId.isNotBlank()){
            startActivity(Intent(this, HomePage::class.java))
        }

    }

}