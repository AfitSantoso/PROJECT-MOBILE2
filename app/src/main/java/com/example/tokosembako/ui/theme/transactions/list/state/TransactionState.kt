package com.example.tokosembako.ui.theme.transactions.list.state

import com.example.tokosembako.ui.theme.domain.model.Transaction

data class TransactionListState(
    val transactions: List<Transaction> = emptyList(),
)