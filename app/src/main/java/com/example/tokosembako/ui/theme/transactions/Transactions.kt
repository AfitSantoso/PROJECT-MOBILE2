package com.example.tokosembako.ui.theme.transactions

import androidx.annotation.StringRes
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.tokosembako.ui.theme.home.HomeScreenItem

@Preview
@Composable
fun TransactionsPreview() {
    TransactionsScreen(HomeScreenItem.Dashboard.title)
}

@Composable
fun TransactionsScreen(@StringRes title: Int) {
    Text(text = "Transaksi")
}