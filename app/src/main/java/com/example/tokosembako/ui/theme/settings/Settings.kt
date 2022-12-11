package com.example.tokosembako.ui.theme.settings

import androidx.annotation.StringRes
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.tokosembako.ui.theme.home.HomeScreenItem
import com.example.tokosembako.ui.theme.settings.components.SettingsScreenBody
import com.example.tokosembako.ui.theme.ui.TopAppBar

@Preview
@Composable
fun SettingsPreview() {
    SettingsScreen(HomeScreenItem.Settings.title)
}


@Composable
fun SettingsScreen(@StringRes title: Int) {
    Scaffold(
        backgroundColor = Color.White,
        topBar = {
            TopAppBar(
                title = stringResource(id = title),
                showBackButton = false
            ) {}
        }
    ) {
        SettingsScreenBody()
    }
}