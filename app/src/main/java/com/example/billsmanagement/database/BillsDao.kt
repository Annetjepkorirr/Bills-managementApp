package com.example.billsmanagement.database

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.billsmanagement.models.Bill

interface BillsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBill(bill: Bill)
}