package com.example.tokosembako.ui.theme.shared

import android.content.Context
import android.widget.Toast

fun ShowToastAlert(
    context: Context,
    message: String,
) {
    Toast.makeText(
        context,
        message,
        Toast.LENGTH_SHORT
    ).show()
}