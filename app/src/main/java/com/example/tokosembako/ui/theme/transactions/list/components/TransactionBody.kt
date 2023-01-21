package com.example.tokosembako.ui.theme.transactions.list.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.tokosembako.ui.theme.transactions.list.TransactionViewModel
import com.example.tokosembako.ui.theme.transactions.list.state.TransactionListState
import kotlinx.coroutines.CoroutineScope

@Composable
fun TransactionsBody(
    modifier: Modifier,
    state: TransactionListState,
    viewModel: TransactionViewModel,
    scope: CoroutineScope,
    scaffoldState: ScaffoldState,
) {
    Column(
        modifier = modifier
    ) {
        TransactionList(
            state = state,
            viewModel = viewModel,
            scope = scope,
            scaffoldState = scaffoldState
        )
    }
}