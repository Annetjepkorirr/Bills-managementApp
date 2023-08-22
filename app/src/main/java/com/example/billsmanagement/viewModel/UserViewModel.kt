package com.example.billsmanagement.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.billsmanagement.models.RegisterRequest
import com.example.billsmanagement.models.RegisterResponse
import com.example.billsmanagement.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel:ViewModel() {
    val regLiveData = MutableLiveData<RegisterResponse>()
    val errorLiveData = MutableLiveData<String>()
    val userRepository = UserRepository()

    fun registerUser(registerRequest: RegisterRequest){
        viewModelScope.launch {
        val response = userRepository.registerUser(registerRequest)
        if (response.isSuccessful){
            regLiveData.postValue(response.body())
        }
        else{
            errorLiveData.postValue(response.errorBody()?.string())
        }
    }
}
}