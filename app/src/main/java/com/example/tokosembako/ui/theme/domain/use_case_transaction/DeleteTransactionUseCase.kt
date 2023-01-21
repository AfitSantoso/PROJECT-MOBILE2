package com.example.tokosembako.ui.theme.domain.use_case_transaction

import com.example.tokosembako.ui.theme.data.repository.TransactionRepository
import com.example.tokosembako.ui.theme.domain.model.Transaction

class DeleteTransactionUseCase(
    private val repository: TransactionRepository,
) {

    suspend operator fun invoke(transactionData: Transaction) {
        repository.delete(transactionData)
    }
}