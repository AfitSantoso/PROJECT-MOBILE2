package com.example.tokosembako.ui.theme.domain.use_case_transaction

data class TransactionUseCases(
    val getAllTransactions: GetAllTransactionsUseCase,
    val addTransaction: AddTransactionUseCase,
    val deleteTransaction: DeleteTransactionUseCase,
    val getTransactionById: GetTransactionByIdUseCase,
)