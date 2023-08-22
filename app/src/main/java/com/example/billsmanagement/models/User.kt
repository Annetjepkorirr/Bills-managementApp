package com.example.billsmanagement.models

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("phone_number") var phoneNumber:String,
    @SerializedName("first_name")var firstName:String,
    @SerializedName("user_id") var userId:String,
    @SerializedName("last_name") var lastName:String,
    var email:String
)
