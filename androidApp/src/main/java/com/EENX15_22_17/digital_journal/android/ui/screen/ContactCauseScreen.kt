package com.EENX15_22_17.digital_journal.android.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.EENX15_22_17.digital_journal.android.ui.contactcause.TextFieldContent
import com.EENX15_22_17.digital_journal.android.ui.contactcause.TextFieldSection

@Composable
fun ContactCauseScreen() {
    Box(modifier = Modifier
        .fillMaxWidth().background(Color.White)
    ) {

        Column {
            Text(
                text = "KONTAKTORSAK",
                style = MaterialTheme.typography.h1,
                color = Color.Black,
                fontSize = 36.sp,
                modifier = Modifier.padding(top = 40.dp, start = 20.dp, end = 20.dp)
            )

            TextFieldSection(items = listOf(
                TextFieldContent(
                    "Situation",
                    "Information kopplat till situation",
                )
            ))

            TextFieldSection(items = listOf(
                TextFieldContent(
                    "Bakgrund",
                    "Information kopplat till bakgrund",
                )
            ))

            TextFieldSection(items = listOf(
                TextFieldContent(
                    "Aktuellt tillstånd",
                    "Information kopplat till aktuellt tillstånd",
                )
            ))

            TextFieldSection(items = listOf(
                TextFieldContent(
                    "Rekommendation",
                    "Information kopplat till rekommendation",
                )
            ))

            TextFieldSection(items = listOf(
                TextFieldContent(
                    "Övrigt",
                    "Övrig information",
                )
            ))

        }
    }
}