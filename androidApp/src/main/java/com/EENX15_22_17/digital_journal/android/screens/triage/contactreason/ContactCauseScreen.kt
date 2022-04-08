package com.EENX15_22_17.digital_journal.android.ui.screen

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.EENX15_22_17.digital_journal.android.screens.triage.contactreason.RettsClickableData
import com.EENX15_22_17.digital_journal.android.screens.triage.contactreason.RettsClickableSection
import com.EENX15_22_17.digital_journal.android.screens.triage.contactreason.TextFieldContent
import com.EENX15_22_17.digital_journal.android.screens.triage.contactreason.TextFieldSection

@Composable
fun ContactCauseScreen() {
    val scrollState = rememberScrollState()
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White),

    ) {
        Column (
            modifier = Modifier.verticalScroll(scrollState),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "KONTAKTORSAK",
                style = TextStyle(fontSize = 36.sp, fontWeight = FontWeight.ExtraBold),
                color = Color.Black,
                modifier = Modifier.padding(top = 40.dp, start = 15.dp, end = 20.dp),

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

            RettsClickableSection( items = mutableListOf(
                RettsClickableData("Nedsatt koncentration", Color.Green),
                RettsClickableData("Psykomotorisk oro (oroligt beteende, rastlöshet)", Color.Yellow),
                RettsClickableData("Social isolering", Color.Yellow)
            )
            )

        }
    }
}