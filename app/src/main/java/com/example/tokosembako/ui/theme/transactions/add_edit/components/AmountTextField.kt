package com.example.tokosembako.ui.theme.transactions.add_edit.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import com.example.tokosembako.ui.theme.transactions.add_edit.AddEditTransactionViewModel
import com.example.tokosembako.ui.theme.transactions.add_edit.state.AddEditTransactionEvent
import com.example.tokosembako.ui.theme.transactions.add_edit.state.TextFieldState

@Composable
fun AmountTextField(
    amountState: TextFieldState,
    viewModel: AddEditTransactionViewModel
) {
    OutlinedTextField(
        value = amountState.text,
        onValueChange = {
            viewModel.onEvent(AddEditTransactionEvent.EnteredAmount(it))
        },
        label = { Text(text = "Jumlah Pembayaran") },
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
    )
}