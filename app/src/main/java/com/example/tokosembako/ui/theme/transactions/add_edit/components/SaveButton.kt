package com.example.tokosembako.ui.theme.transactions.add_edit.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.example.tokosembako.ui.theme.ThemeBlack
import com.example.tokosembako.ui.theme.ThemeWhite
import com.example.tokosembako.ui.theme.transactions.add_edit.AddEditTransactionViewModel
import com.example.tokosembako.ui.theme.transactions.add_edit.state.AddEditTransactionEvent

@Composable
fun SaveButton(
    viewModel: AddEditTransactionViewModel
) {

    val boxModifier = Modifier
        .fillMaxHeight()
        .padding(bottom = 10.dp)

    val buttonModifier = Modifier
        .fillMaxWidth()
        .height(46.dp)


    Box(modifier = boxModifier) {
        Button(
            onClick = {
                viewModel.onEvent(AddEditTransactionEvent.SaveTransaction)
            },
            shape = RectangleShape,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = ThemeBlack,
                contentColor = ThemeWhite
            ),
            modifier = buttonModifier.align(Alignment.BottomCenter),
        ) {
            Text(text = "Simpan")
        }
    }
}