package com.EENX15_22_17.digital_journal.android.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.EENX15_22_17.digital_journal.android.R
import com.EENX15_22_17.digital_journal.android.screens.journal.triage.contactReason.RettsClickableData
import com.EENX15_22_17.digital_journal.android.screens.journal.triage.contactReason.RettsSymtomChip
import com.EENX15_22_17.digital_journal.android.ui.DetailPageWrapper
import com.EENX15_22_17.digital_journal.android.ui.components.TitledTextField
import com.EENX15_22_17.digital_journal.android.ui.theme.Colors

@Composable
fun ContactReasonScreen(
    journalId: String,
    onBackClicked: () -> Unit,
    onMenuClicked: () -> Unit,
) {
    DetailPageWrapper(
        title = stringResource(id = R.string.contactReason),
        titleColor = Colors.treatmentPrimary,
        onBackClicked = onBackClicked,
        onMenuClicked = onMenuClicked
    ) {
        Box(
            modifier = Modifier.fillMaxSize().padding(top = 20.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.Center
            ) {

                TitledTextField(
                    title = "Situation",
                    onChangeText = {  }, //TODO: Implement View Model for Contact Cause
                    textValue = "",
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(width = 200.dp, height = 100.dp)
                )

                Text(vm.data.otherNotes?:"")

                TitledTextField(
                    title = "Bakgrund",
                    onChangeText = {},  //TODO: Implement View Model for Contact Cause
                    textValue = "",
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(width = 200.dp, height = 100.dp)
                )

                TitledTextField(
                    title = "Aktuellt tillstånd",
                    onChangeText = {},  //TODO: Implement View Model for Contact Cause
                    textValue = "",
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(width = 200.dp, height = 100.dp)
                )

                TitledTextField(
                    title = "Rekommendation",
                    onChangeText = {},
                    textValue = "",
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(width = 200.dp, height = 100.dp)
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
                            modifier = Modifier
                                .fillMaxWidth()
                                .size(width = 200.dp, height = 100.dp)
                        )
                    }
                    Column(Modifier.padding(start = 20.dp)) {
                        TitledTextField(
                            title = "Förväntan på besöket",
                            onChangeText = {},
                            textValue = "",
                            modifier = Modifier
                                .fillMaxWidth()
                                .size(width = 200.dp, height = 100.dp)
                        )
                    }
                }


                val scrollState = rememberScrollState()
                Box(
                    modifier = Modifier
                        .size(width = 600.dp, height = 250.dp)
                        .verticalScroll(scrollState)
                ) {
                    Column(
                        modifier = Modifier.padding(top = 20.dp)
                    ) {
                        RettsSymtomChip(
                            item = RettsClickableData(
                                data = "Nedsatt koncentration",
                                color = Color.Green
                            ), onClick = {}) //TODO: Implement View Model for Retts Clickable Items
                        RettsSymtomChip(
                            item = RettsClickableData(
                                data = "Psykomotorisk oro (oroligt beteende, rastlöshet)",
                                color = Color.Yellow
                            ), onClick = {}) //TODO: Implement View Model for Retts Clickable Items
                        RettsSymtomChip(
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