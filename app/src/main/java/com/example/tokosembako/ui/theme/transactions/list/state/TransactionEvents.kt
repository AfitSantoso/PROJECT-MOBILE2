package com.example.tokosembako.ui.theme.transactions.list.state

import com.example.tokosembako.ui.theme.domain.model.Transaction

sealed class TransactionEvent {
    data class DeleteTransaction(val transaction: Transaction) : TransactionEvent()
    data class EditTransaction(val transaction: Transaction) : TransactionEvent()
}