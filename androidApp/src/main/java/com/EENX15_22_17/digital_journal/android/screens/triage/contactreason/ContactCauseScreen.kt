package com.EENX15_22_17.digital_journal.android.ui.screen

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.EENX15_22_17.digital_journal.android.R
import com.EENX15_22_17.digital_journal.android.ui.contactcause.*
import com.EENX15_22_17.digital_journal.android.screens.triage.contactreason.RettsClickableData
import com.EENX15_22_17.digital_journal.android.screens.triage.contactreason.RettsClickableItem
import com.EENX15_22_17.digital_journal.android.screens.triage.suicideassessment.ProtectiveFactorsContent
import com.EENX15_22_17.digital_journal.android.screens.triage.suicideassessment.summarysuicidesection.SummarySection
import com.EENX15_22_17.digital_journal.android.ui.DetailPageWrapper
import com.EENX15_22_17.digital_journal.android.ui.components.TitledSectionTemp
import com.EENX15_22_17.digital_journal.android.ui.components.TitledTextField
import com.EENX15_22_17.digital_journal.android.ui.theme.Colors

@Composable
fun ContactCauseScreen(
    navBack: () -> Unit,
    visitId: String,
) {
    DetailPageWrapper(
        title = stringResource(id = R.string.contactReason),
        titleColor = Colors.treatmentPrimary,
        onBackClicked = navBack,
        onMenuClicked = {}

    ) {
        Box(
            modifier = Modifier.fillMaxSize().padding(top = 20.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.Center
            ) {

                TitledTextField(
                    title = "Situation",
                    onChangeText = {}, //TODO: Implement View Model for Contact Cause
                    textValue = "",
                    modifier = Modifier.fillMaxWidth().size(width = 200.dp, height = 100.dp)
                )

                TitledTextField(
                    title = "Bakgrund",
                    onChangeText = {},  //TODO: Implement View Model for Contact Cause
                    textValue = "",
                    modifier = Modifier.fillMaxWidth().size(width = 200.dp, height = 100.dp)
                )

                TitledTextField(
                    title = "Aktuellt tillstånd",
                    onChangeText = {},  //TODO: Implement View Model for Contact Cause
                    textValue = "",
                    modifier = Modifier.fillMaxWidth().size(width = 200.dp, height = 100.dp)
                )

                TitledTextField(
                    title = "Rekommendation",
                    onChangeText = {},
                    textValue = "",
                    modifier = Modifier.fillMaxWidth().size(width = 200.dp, height = 100.dp)
                )

                Row(
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.Top,
                    modifier = Modifier.fillMaxWidth()
                ) {

                    Column(modifier = Modifier.fillMaxWidth(0.50f)) {
                        TitledTextField(
                            title = "Övrigt",
                            onChangeText = {},
                            textValue = "",
                            modifier = Modifier.fillMaxWidth().size(width = 200.dp, height = 100.dp)
                        )
                    }
                    Column(Modifier.padding(start = 20.dp)) {
                        TitledTextField(
                            title = "Förväntan på besöket",
                            onChangeText = {},
                            textValue = "",
                            modifier = Modifier.fillMaxWidth().size(width = 200.dp, height = 100.dp)
                        )
                    }
                }


                val scrollState = rememberScrollState()
                Box(
                    modifier = Modifier.size(width = 600.dp, height = 250.dp).verticalScroll(scrollState)
                ) {
                    Column(
                        modifier = Modifier.padding(top = 20.dp)
                    ) {
                        RettsClickableItem(
                            item = RettsClickableData(
                                data = "Nedsatt koncentration",
                                color = Color.Green
                            ), onClick = {}) //TODO: Implement View Model for Retts Clickable Items
                        RettsClickableItem(
                            item = RettsClickableData(
                                data = "Psykomotorisk oro (oroligt beteende, rastlöshet)",
                                color = Color.Yellow
                            ), onClick = {}) //TODO: Implement View Model for Retts Clickable Items
                        RettsClickableItem(
                            item = RettsClickableData(
                                data = "Social isolering",
                                color = Color.Yellow
                            ), onClick = {}) //TODO: Implement View Model for Retts Clickable Items
                    }
                }

            }
        }
    }
}