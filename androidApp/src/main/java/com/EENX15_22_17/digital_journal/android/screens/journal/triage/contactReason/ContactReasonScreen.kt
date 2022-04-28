package com.EENX15_22_17.digital_journal.android.ui.screen

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.EENX15_22_17.digital_journal.android.R
import com.EENX15_22_17.digital_journal.android.screens.journal.triage.contactReason.RettsSymtomChip
import com.EENX15_22_17.digital_journal.android.ui.DetailPageWrapper
import com.EENX15_22_17.digital_journal.android.ui.components.TitledTextField
import com.EENX15_22_17.digital_journal.android.ui.theme.Colors
import se.predicare.journal.screens.ContactReasonDto

@Composable
fun ContactReasonScreen(
    vm: ContactReasonViewModel,
    onBackClicked: () -> Unit,
    onMenuClicked: () -> Unit,
) {

    var situation by vm.data.stateOf(ContactReasonDto::sbar, ContactReasonDto.SBAR::situation)
    var background by vm.data.stateOf(ContactReasonDto::sbar, ContactReasonDto.SBAR::background)
    var assessment by vm.data.stateOf(ContactReasonDto::sbar, ContactReasonDto.SBAR::assessment)
    var recommendation by vm.data.stateOf(ContactReasonDto::sbar, ContactReasonDto.SBAR::recommendation)
    var otherNotes by vm.data.stateOf(ContactReasonDto::otherNotes)
    var patientExpectations by vm.data.stateOf(ContactReasonDto::patientExpectations)
    var rettsSymptoms by vm.data.stateOf(ContactReasonDto::rettsSymptoms, mutableSetOf())

    fun saveAndReturn() {
        vm.save()
        onBackClicked()
    }

    BackHandler(onBack = ::saveAndReturn)

    DetailPageWrapper(
        title = stringResource(id = R.string.contactReason),
        titleColor = Colors.treatmentPrimary,
        onBackClicked = ::saveAndReturn,
        onMenuClicked = onMenuClicked
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 20.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.Center
            ) {
                TitledTextField(
                    title = "Situation",
                    textValue = situation ?: "",
                    onChangeText = { situation = it },
                    maxLines = Int.MAX_VALUE,
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(width = 200.dp, height = 100.dp)
                )

                TitledTextField(
                    title = "Bakgrund",
                    textValue = background ?: "",
                    onChangeText = { background = it },
                    maxLines = Int.MAX_VALUE,
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(width = 200.dp, height = 100.dp),
                )

                TitledTextField(
                    title = "Aktuellt tillstånd",
                    textValue = assessment ?: "",
                    onChangeText = { assessment = it },
                    maxLines = Int.MAX_VALUE,
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(width = 200.dp, height = 100.dp)
                )

                TitledTextField(
                    title = "Rekommendation",
                    textValue = recommendation ?: "",
                    onChangeText = { recommendation = it },
                    maxLines = Int.MAX_VALUE,
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
                            onChangeText = { otherNotes = it },
                            maxLines = Int.MAX_VALUE,
                            textValue = otherNotes ?: "",
                            modifier = Modifier
                                .fillMaxWidth()
                                .size(width = 200.dp, height = 100.dp)
                        )
                    }
                    Column(Modifier.padding(start = 20.dp)) {
                        TitledTextField(
                            title = "Förväntan på besöket",
                            textValue = patientExpectations ?: "",
                            onChangeText = { patientExpectations = it },
                            maxLines = Int.MAX_VALUE,
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
                        rettsSymptoms.forEach {
                            RettsSymtomChip(it) {

                            }
                        }

                    }
                }

            }
        }
    }
}