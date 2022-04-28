package com.EENX15_22_17.digital_journal.android.screens.journal.treatment.interim

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.EENX15_22_17.digital_journal.android.R
import com.EENX15_22_17.digital_journal.android.dataModel.yesNoQuestionLabels
import com.EENX15_22_17.digital_journal.android.ui.DetailPageWrapper
import com.EENX15_22_17.digital_journal.android.ui.components.*
import com.EENX15_22_17.digital_journal.android.ui.theme.Colors
import se.predicare.journal.data.ArrivalLaws
import se.predicare.journal.data.Labels.labels
import se.predicare.journal.data.YesNoQuestion
import se.predicare.journal.screens.InterimJournalDto

@Composable
fun InterimJournalScreen(
    interimViewModel: InterimViewModel,
    journalId: String,
    onBackClicked: () -> Unit,
    onMenuClicked: () -> Unit
) {
    //TODO: Fix grey out content if certain radiobutton is selected
    DetailPageWrapper(
        title = stringResource(id = R.string.interimJournal),
        titleColor = Colors.treatmentPrimary,
        onBackClicked = onBackClicked,
        onMenuClicked = onMenuClicked
    ) {
        Column {
            //PatientDecision content
            TitledSection(title = stringResource(id = R.string.patientDecision)) {
                EnumRadioButtonWithTextField(
                    choices = InterimJournalDto.PatientAction.labels.keys.toTypedArray(),
                    labels = InterimJournalDto.PatientAction.labels,
                    currentChoice = interimViewModel.interimStates.patientAction.choice,
                    onSelection = { interimViewModel.interimStates.patientAction.choice = it },
                    onChangeTextValue = { choice, text ->
                        interimViewModel.interimStates.patientAction.notes[choice] = text
                    },
                    title = patientDecisionTitles,
                    textValues = interimViewModel.interimStates.patientAction.notes,
                    hasTextfield = patientDecisionTextfields,
                )
            }
            //PreliminaryAssessment content
            TitledSection(title = stringResource(id = R.string.preliminaryAssessment)) {
                Column {
                    TitledTextField(
                        modifier = Modifier
                            .padding(16.dp)
                            .height(140.dp)
                            .fillMaxWidth(),
                        title = "Preliminär bedömning",
                        onChangeText = {
                            interimViewModel.interimStates.preliminaryAssessment = it
                        },
                        textValue = interimViewModel.interimStates.preliminaryAssessment ?: "",
                        maxLines = 5
                    )
                    Row(horizontalArrangement = Arrangement.spacedBy(40.dp)) {
                        Column {
                            Text(
                                text = "Vapenlicens",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(vertical = 16.dp)
                            )
                            EnumRadioButtonsHorizontal(
                                choices = yesNoQuestionLabels.keys.toTypedArray(),
                                labels = yesNoQuestionLabels,
                                currentChoice = interimViewModel.interimStates.patientHasWeaponLicense
                                    ?: YesNoQuestion.UNANSWERED,
                                onSelection = {
                                    interimViewModel.interimStates.patientHasWeaponLicense = it
                                }
                            )
                        }

                        Column {
                            Text(
                                text = "Körkort",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(vertical = 16.dp)
                            )
                            EnumRadioButtonsHorizontal(
                                choices = yesNoQuestionLabels.keys.toTypedArray(),
                                labels = yesNoQuestionLabels,
                                currentChoice = interimViewModel.interimStates.patientHasDriversLicense
                                    ?: YesNoQuestion.UNANSWERED,
                                onSelection = {
                                    interimViewModel.interimStates.patientHasDriversLicense = it
                                }
                            )
                        }
                    }

                }
            }
            // Hospitalization content
            TitledSection(
                title = stringResource(id = R.string.hospitalization),
                modifier = Modifier.height(300.dp)
            ) {
                Row(horizontalArrangement = Arrangement.spacedBy(140.dp)) {
                    Column {
                        Text(
                            text = "Lagar",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(vertical = 16.dp)
                        )
                        EnumCheckboxesLazyGrid(
                            choices = arrivalLaws.keys.toTypedArray(),
                            labels = arrivalLaws,
                            selection = interimViewModel.interimStates.hospitalization.laws,
                            onSelectionChanged = {
                                interimViewModel.interimStates.hospitalization.laws =
                                    it as MutableSet<ArrivalLaws>
                            },
                            gridLayout = GridCells.Adaptive(50.dp),
                            checkboxSpacing = 1.dp,
                            isHorizontal = true
                        )
                    }
                    Column {
                        Text(
                            text = "Transportsätt",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(vertical = 16.dp)
                        )
                        EnumCheckboxesLazyGrid(
                            choices = transportationWaysLabel.keys.toTypedArray(),
                            labels = transportationWaysLabel,
                            selection = interimViewModel.interimStates.hospitalization.wayOfTransport,
                            onSelectionChanged = {
                                interimViewModel.interimStates.hospitalization.wayOfTransport =
                                    it as MutableSet<InterimJournalDto.WayOfTransport>
                            },
                            gridLayout = GridCells.Adaptive(30.dp),
                            checkboxSpacing = 1.dp,
                            isHorizontal = true
                        )
                    }
                }
            }

            TitledSection(title = stringResource(id = R.string.reportedTo)) {
                Column {
                    Row(horizontalArrangement = Arrangement.spacedBy(50.dp)) {
                        TitledTextField(
                            title = "Avdelning",
                            //TODO: Remove when included in InterimDto
                            onChangeText = { interimViewModel.department = it },
                            textValue = interimViewModel.department
                        )
                        TitledTextField(
                            title = "Ssk",
                            onChangeText = { interimViewModel.ssk = it },
                            textValue = interimViewModel.ssk
                        )
                        TitledTextField(
                            title = "Klockan",
                            //TODO: Have a Datefield
                            onChangeText = { interimViewModel.time },
                            textValue = interimViewModel.time
                        )
                    }
                    Text(
                        text = "Intagningsbeslut fattat",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(vertical = 16.dp)
                    )
                    Row {
                        LabeledCheckbox(
                            label = "Ja",
                            checked = interimViewModel.admission,
                            onCheckedChange = {
                                interimViewModel.admission = it
                            }
                        )

                    }
                }
            }
        }
    }
}
