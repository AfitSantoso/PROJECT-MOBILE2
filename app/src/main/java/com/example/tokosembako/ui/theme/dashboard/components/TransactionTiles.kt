package com.example.tokosembako.ui.theme.dashboard.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview
@Composable
fun TransactionTilesPrev() {
    TransactionTiles()
}

@Composable
fun TransactionTiles() {
    Row(modifier = Modifier
        .fillMaxWidth()
    ) {
        Card(
            elevation = 2.dp,
            modifier = Modifier
                .weight(1f)
                .height(150.dp)
                .padding(6.dp)
        ) {
            Box(modifier = Modifier.padding(8.dp)) {
                Text(
                    text = "Total Transaksi:",
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 16.sp
                    ),
                    modifier = Modifier.width(100.dp)
                )

                Text(
                    text = "72",
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 40.sp,
                        textAlign = TextAlign.End
                    ),
                    modifier = Modifier.align(
                        alignment = Alignment.BottomEnd
                    )
                )
            }
        }

        Card(
            elevation = 2.dp,
            modifier = Modifier
                .weight(1f)
                .height(150.dp)
                .padding(6.dp)
        ) {
            Box(modifier = Modifier.padding(8.dp)) {
                Text(
                    text = "Transaksi Bulan Ini:",
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 16.sp
                    ),
                    modifier = Modifier.width(100.dp)
                )

                Text(
                    text = "11",
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 40.sp,
                        textAlign = TextAlign.End
                    ),
                    modifier = Modifier.align(
                        alignment = Alignment.BottomEnd
                    )
                )
            }
        }

    }
}