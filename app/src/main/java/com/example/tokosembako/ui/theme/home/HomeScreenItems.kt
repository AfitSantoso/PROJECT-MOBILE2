package com.example.tokosembako.ui.theme.home

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.tokosembako.R

sealed class HomeScreenItem(
    @StringRes var title: Int,
    @DrawableRes var icon: Int,
    var route: String,
) {

    object Dashboard :
        HomeScreenItem(
            R.string.title_dashboard_screen,
            R.drawable.ic_dashboard,
            "dashboard"
        )

    object Transactions :
        HomeScreenItem(
            R.string.title_transactions_screen,
            R.drawable.ic_transactions,
            "transactions"
        )

    object AddTransaction :
        HomeScreenItem(
            R.string.title_add_transactions_screen,
            R.drawable.ic_transactions,
            "transactions-add"
        )

    object Settings :
        HomeScreenItem(
            R.string.title_profile_screen,
            R.drawable.ic_settings,
            "profile"
        )
}