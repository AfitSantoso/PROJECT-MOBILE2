package com.example.tokosembako.ui.theme.dashboard

import androidx.annotation.StringRes
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.tokosembako.ui.theme.dashboard.components.DashboardBody
import com.example.tokosembako.ui.theme.home.HomeScreenItem

@Preview
@Composable
fun DashboardPreview() {
    DashboardScreen(HomeScreenItem.Dashboard.title)
}

@Composable
fun DashboardScreen(@StringRes title: Int) {
    Scaffold(
        backgroundColor = Color.White,
    ) {
        DashboardBody()
    }

}