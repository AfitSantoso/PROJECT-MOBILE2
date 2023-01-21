package com.example.tokosembako.ui.theme.core.di

import android.app.Application
import androidx.room.Room
import com.example.tokosembako.ui.theme.data.data_source_local.TransactionDatabase
import com.example.tokosembako.ui.theme.data.repository.TransactionRepository
import com.example.tokosembako.ui.theme.data.repository.TransactionRepositoryImpl
import com.example.tokosembako.ui.theme.domain.use_case_transaction.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun providesTransactionDb(context: Application): TransactionDatabase {
        return Room.databaseBuilder(
            context,
            TransactionDatabase::class.java,
            TransactionDatabase.DATABASE_NAME
        ).build()
    }


    @Provides
    @Singleton
    fun providesTransactionRepository(database: TransactionDatabase): TransactionRepository {
        return TransactionRepositoryImpl(database.transactionDao)
    }


    @Provides
    @Singleton
    fun providesTransactionUseCases(repository: TransactionRepository): TransactionUseCases {
        return TransactionUseCases(
            getAllTransactions = GetAllTransactionsUseCase(repository),
            deleteTransaction = DeleteTransactionUseCase(repository),
            addTransaction = AddTransactionUseCase(repository),
            getTransactionById = GetTransactionByIdUseCase(repository)
        )
    }

}