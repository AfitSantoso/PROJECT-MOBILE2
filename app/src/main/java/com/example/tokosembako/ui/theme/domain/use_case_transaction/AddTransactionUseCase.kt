package com.example.tokosembako.ui.theme.domain.use_case_transaction

import com.example.tokosembako.ui.theme.data.repository.TransactionRepository
import com.example.tokosembako.ui.theme.domain.model.InvalidTransactionException
import com.example.tokosembako.ui.theme.domain.model.Transaction

class AddTransactionUseCase(
    private val repository: TransactionRepository,
) {

    @Throws(InvalidTransactionException::class)
    suspend operator fun invoke(transactionData: Transaction) {

        if (transactionData.amount.isNullOrBlank()) {
            throw InvalidTransactionException("Amount cannot be empty")
        }

        repository.insert(transactionData)
    }

}