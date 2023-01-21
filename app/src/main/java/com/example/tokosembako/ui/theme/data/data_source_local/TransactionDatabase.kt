package com.example.tokosembako.ui.theme.data.data_source_local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tokosembako.ui.theme.domain.model.Transaction

@Database(
    entities = [Transaction::class],
    version = 1,
    exportSchema = false
)
abstract class TransactionDatabase : RoomDatabase() {

    abstract val transactionDao: TransactionDao

    companion object {
        const val DATABASE_NAME = "transaction_database"
    }
}