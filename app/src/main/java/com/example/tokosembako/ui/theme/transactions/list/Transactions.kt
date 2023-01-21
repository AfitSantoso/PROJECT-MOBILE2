package com.example.tokosembako.ui.theme.transactions.list

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FabPosition
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.tokosembako.ui.theme.ThemeBackground
import com.example.tokosembako.ui.theme.home.HomeScreenItem
import com.example.tokosembako.ui.theme.shared.CrebitsTopAppBar
import com.example.tokosembako.ui.theme.transactions.list.components.AddTransactionFab
import com.example.tokosembako.ui.theme.transactions.list.components.TransactionsBody

@Preview
@Composable
fun TransactionsPreview() {
    TransactionsScreen(
        HomeScreenItem.Transactions.title,
        hiltViewModel()
    ) {}
}

@Composable
fun TransactionsScreen(
    @StringRes title: Int,
    viewModel: TransactionViewModel = hiltViewModel(),
    onAddClick: () -> Unit,
) {
    val state = viewModel.state.value
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        backgroundColor = ThemeBackground,
        topBar = {
            CrebitsTopAppBar(
                title = stringResource(id = title),
                false
            ) {}
        },
        floatingActionButton = { AddTransactionFab(onAddClick) },
        floatingActionButtonPosition = FabPosition.End
    ) {
        TransactionsBody(
            modifier = Modifier.padding(14.dp),
            state = state,
            viewModel = viewModel,
            scope = scope,
            scaffoldState = scaffoldState
        )
    }
}