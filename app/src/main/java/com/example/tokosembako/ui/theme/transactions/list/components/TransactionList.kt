package com.example.tokosembako.ui.theme.transactions.list.components

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.tokosembako.ui.theme.transactions.list.TransactionViewModel
import com.example.tokosembako.ui.theme.transactions.list.state.TransactionEvent
import com.example.tokosembako.ui.theme.transactions.list.state.TransactionListState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun TransactionList(
    state: TransactionListState,
    viewModel: TransactionViewModel,
    scope: CoroutineScope,
    scaffoldState: ScaffoldState,
) {

    val context = LocalContext.current

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(state.transactions) { transaction ->
            TransactionItem(
                transaction = transaction,
                onDeleteClick = {
                    viewModel.onEvent(
                        TransactionEvent.DeleteTransaction(transaction)
                    )
                    scope.launch {
                        Toast.makeText(
                            context,
                            "Transaction Deleted",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            ) {}
        }
    }

}