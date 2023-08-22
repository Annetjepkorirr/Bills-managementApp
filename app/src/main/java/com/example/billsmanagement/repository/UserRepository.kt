package com.example.billsmanagement.repository

import com.example.billsmanagement.API.ApiInterface
import com.example.billsmanagement.API.ApiClient
import com.example.billsmanagement.models.RegisterRequest
import com.example.billsmanagement.models.RegisterResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class UserRepository {
    var client = ApiClient.buildClient(ApiInterface::class.java)
    suspend fun registerUser(registerRequest: RegisterRequest):Response<RegisterResponse>{
        return withContext(Dispatchers.IO){
            client.registerUser(registerRequest)
        }
    }
}