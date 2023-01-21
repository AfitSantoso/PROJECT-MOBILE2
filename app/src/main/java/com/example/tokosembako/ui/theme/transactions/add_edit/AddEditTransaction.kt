package com.example.tokosembako.ui.theme.transactions.add_edit

import androidx.annotation.StringRes
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.tokosembako.ui.theme.ThemeBackground
import com.example.tokosembako.ui.theme.home.HomeScreenItem
import com.example.tokosembako.ui.theme.shared.CrebitsTopAppBar
import com.example.tokosembako.ui.theme.shared.ShowToastAlert
import com.example.tokosembako.ui.theme.transactions.add_edit.components.AddTransactionBody
import kotlinx.coroutines.flow.collectLatest

@Preview
@Composable
fun AddEditTransactionScreenPreview() {
    AddEditTransactionScreen(
        HomeScreenItem.AddTransaction.title,
    ){}
}


@Composable
fun AddEditTransactionScreen(
    @StringRes title: Int,
    viewModel: AddEditTransactionViewModel = hiltViewModel(),
    navigateBack: () -> Unit,
) {

    val scaffoldState = rememberScaffoldState()
    val context = LocalContext.current

    Scaffold(
        scaffoldState = scaffoldState,
        backgroundColor = ThemeBackground,
        topBar = {
            CrebitsTopAppBar(
                title = stringResource(id = title),
                true,
                navigateBack
            )
        },
    ) {
        AddTransactionBody(viewModel)
    }


    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when (event) {
                is AddEditTransactionViewModel.UiEvent.SaveTransactionSuccess -> {
                    navigateBack()
                }

                is AddEditTransactionViewModel.UiEvent.ShowToast -> {
                    ShowToastAlert(context, event.message)
                }
            }
        }
    }
}