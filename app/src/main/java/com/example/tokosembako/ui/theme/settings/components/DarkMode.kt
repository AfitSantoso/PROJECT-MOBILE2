package com.example.tokosembako.ui.theme.settings.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tokosembako.R


@Composable
fun DarkModeOption() {
    Card(
        elevation = 2.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Icon(
                ImageVector = R.drawable.ic_darkmode,
                contentDescription = "dark mode",
                modifier = Modifier.padding(end = 24.dp)
            )
            Text(text = "Dark Mode", fontSize = 18.sp)
        }
    }
}

fun Icon(ImageVector: Int, contentDescription: String, modifier: Modifier) {

}
