package com.example.tokosembako.ui.theme.home

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.tokosembako.ui.theme.dashboard.DashboardScreen
import com.example.tokosembako.ui.theme.settings.SettingsScreen
import com.example.tokosembako.ui.theme.transactions.add_edit.AddEditTransactionScreen
import com.example.tokosembako.ui.theme.transactions.list.TransactionsScreen

@Composable
fun HomeNavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = HomeScreenItem.Dashboard.route) {

        composable(HomeScreenItem.Dashboard.route) {
            DashboardScreen(HomeScreenItem.Dashboard.title)
        }

//        composable(HomeScreenItem.Transactions.route) {
//            TransactionsScreen(HomeScreenItem.Transactions.title
//            )
//        }

        composable(HomeScreenItem.Transactions.route) {
            TransactionsScreen(HomeScreenItem.Transactions.title
            ) { navController.navigate(HomeScreenItem.AddTransaction.route) }
        }

        composable(HomeScreenItem.AddTransaction.route) {
            AddEditTransactionScreen(HomeScreenItem.AddTransaction.title) { navController.popBackStack() }
        }

        composable(HomeScreenItem.Settings.route) {
            SettingsScreen(HomeScreenItem.Settings.title)
        }
    }
}