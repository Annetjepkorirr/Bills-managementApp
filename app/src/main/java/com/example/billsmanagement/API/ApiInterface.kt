package com.example.billsmanagement.API

import com.example.billsmanagement.models.LoginRequest
import com.example.billsmanagement.models.LoginResponse
import com.example.billsmanagement.models.RegisterRequest
import com.example.billsmanagement.models.RegisterResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("/users/register")
    suspend fun registerUser(@Body registerRequest:RegisterRequest):Response<RegisterResponse>

    @POST("/users/login")
    suspend fun LoginUser(@Body LoginRequest:LoginRequest):Response<LoginResponse>
}