package com.example.billsmanagement.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class BillsDb:RoomDatabase() {
    abstract fun billsDao():BillsDao
    companion object{
        var database:BillsDb? =null

        fun getDatabase(context: Context):BillsDb{  //singleton
            if (database ==null){
                database = Room
                    .databaseBuilder(context,BillsDb::class.java,"BillsDb")
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return database as BillsDb //coarse nullable Db class with non-nullabledb
        }

    }

}