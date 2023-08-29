package com.example.billsmanagement.repository

import com.example.billsmanagement.BillsApp
import com.example.billsmanagement.database.BillsDb
import com.example.billsmanagement.models.Bill
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class BillsRepository {
    var db = BillsDb.getDatabase(BillsApp.appContext)
    var billsDao = db.billsDao()

    suspend fun saveBill(bill: Bill){
        withContext(Dispatchers.IO){
            billsDao.insertBill(bill)
        }
    }
}