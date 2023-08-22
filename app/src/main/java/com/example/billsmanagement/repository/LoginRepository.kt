package com.example.billsmanagement.repository

import com.example.billsmanagement.API.ApiClient
import com.example.billsmanagement.API.ApiInterface
import com.example.billsmanagement.models.LoginRequest

import com.example.billsmanagement.models.LoginResponse
import com.example.billsmanagement.models.RegisterRequest
import com.example.billsmanagement.models.RegisterResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class LoginRepository {
        var client = ApiClient.buildClient(ApiInterface::class.java)
        suspend fun loginUser(loginRequest: LoginRequest):Response<LoginResponse>{
            return withContext(Dispatchers.IO){
                client.LoginUser(loginRequest)
            }
        }
    }