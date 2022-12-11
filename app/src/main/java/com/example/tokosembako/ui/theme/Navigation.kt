package com.example.tokosembako.ui.theme

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tokosembako.ui.theme.dashboard.DashboardScreen
import com.example.tokosembako.ui.theme.home.HomeScreenItem
import com.example.tokosembako.ui.theme.login.LoginScreen
import com.example.tokosembako.ui.theme.login.LoginViewModel
import com.example.tokosembako.ui.theme.login.SignUpScreen
import com.example.tokosembako.ui.theme.transactions.TransactionsScreen

enum class LoginRoutes{
    Signup,
    SignIn
}

enum class HomeRoutes{
    DashboardScreen,Detail
}

@Composable
fun Navigation(
    navController: NavHostController = rememberNavController(),
    loginViewModel: LoginViewModel
){
    NavHost(navController = navController,
    startDestination = LoginRoutes.SignIn.name){
        composable(route = LoginRoutes.SignIn.name){
            LoginScreen(onNavToHomePage = {
                navController.navigate(HomeRoutes.DashboardScreen.name){
                    launchSingleTop = true
                    popUpTo(route = LoginRoutes.SignIn.name){
                        inclusive = true
                    }
                }
            },
            loginViewModel = loginViewModel
            ) {
                navController.navigate(LoginRoutes.Signup.name){
                    launchSingleTop = true
                    popUpTo(LoginRoutes.SignIn.name){
                        inclusive = true
                    }
                }
            }
        }

        composable(route = LoginRoutes.Signup.name){
            SignUpScreen(onNavToHomePage = {navController.navigate(HomeRoutes.DashboardScreen.name){
                popUpTo(LoginRoutes.Signup.name){
                    inclusive = true
                }
            }  },
            loginViewModel = loginViewModel
                ) {
                navController.navigate(LoginRoutes.SignIn.name)
            }
        }

//        composable(route = HomeRoutes.HomeBottomNavBar.name){
//            HomeBottomNavBar()
//        }

        composable(HomeScreenItem.Dashboard.route) {
            DashboardScreen(HomeScreenItem.Dashboard.title)
        }

        composable(HomeScreenItem.Transactions.route) {
            TransactionsScreen(HomeScreenItem.Transactions.title)
        }





    }





}

