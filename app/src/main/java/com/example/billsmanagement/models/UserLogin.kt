package com.example.billsmanagement.models

import com.google.gson.annotations.SerializedName

data class UserLogin(
    @SerializedName("user_id") var  userId:String,
    var email:String,
    var passord:String,
)
