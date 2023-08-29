package com.example.billsmanagement.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.billsmanagement.models.Bill
import com.example.billsmanagement.repository.BillsRepository
import kotlinx.coroutines.launch

class BillsViewModel:ViewModel() {
    val billsRepo = BillsRepository()  //suspend functions can be called either by couroutine or other suspend functions  ///Spinner

    fun saveBill(bill: Bill){
        viewModelScope.launch {
            billsRepo.saveBill(bill)
        }
    }
}