package com.example.tokosembako.ui.theme.domain.use_case_transaction

import com.example.tokosembako.ui.theme.data.repository.TransactionRepository
import com.example.tokosembako.ui.theme.domain.model.Transaction
import kotlinx.coroutines.flow.Flow

class GetAllTransactionsUseCase(
    private val repository: TransactionRepository,
) {
    operator fun invoke(): Flow<List<Transaction>> {
        return repository.getAll()
    }
}