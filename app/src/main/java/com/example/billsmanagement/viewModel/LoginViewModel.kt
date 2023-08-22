package com.example.billsmanagement.viewModel

import androidx.lifecycle.MutableLiveData
import com.example.billsmanagement.models.LoginRequest
import com.example.billsmanagement.models.LoginResponse
import com.example.billsmanagement.repository.LoginRepository
import kotlinx.coroutines.launch
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.ViewModel

class LoginViewModel:ViewModel() {
    val livedata = MutableLiveData<LoginResponse>()
    val errorLiveData = MutableLiveData<String>()
    val loginRepository = LoginRepository()

    fun loginUser(loginRequest: LoginRequest){
        viewModelScope.launch{
            val response = loginRepository.loginUser(loginRequest)
            if (response.isSuccessful){
                livedata.postValue(response.body())
            }
            else{
                errorLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}