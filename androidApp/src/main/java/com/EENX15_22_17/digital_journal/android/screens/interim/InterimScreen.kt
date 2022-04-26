package com.EENX15_22_17.digital_journal.android.screens.interim

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.EENX15_22_17.digital_journal.android.R
import com.EENX15_22_17.digital_journal.android.dataModel.YesNo
import com.EENX15_22_17.digital_journal.android.dataModel.yesNoLabels
import com.EENX15_22_17.digital_journal.android.dataModel.yesNoNoAnswerLabels
import com.EENX15_22_17.digital_journal.android.dataModel.yesNoQuestionLabels
import com.EENX15_22_17.digital_journal.android.ui.DetailPageWrapper
import com.EENX15_22_17.digital_journal.android.ui.components.*
import com.EENX15_22_17.digital_journal.android.ui.theme.Colors
import se.predicare.journal.data.EnumChoiceWithIndividualNotes
import se.predicare.journal.data.YesNoQuestion
import se.predicare.journal.screens.InterimJournalDto

@Composable
fun InterimPage(
    interimViewModel: InterimViewModel,
    visitId: String,
    onBackClicked: () -> Unit,
    onMenuClicked: () -> Unit
) {
    DetailPageWrapper(
        title = stringResource(id = R.string.interimJournal),
        titleColor = Colors.treatmentPrimary,
        onBackClicked = onBackClicked,
        onMenuClicked = onMenuClicked
    ) {
        Column {
            //patientDecision content
            TitledSection(title = stringResource(id = R.string.patientDecision)) {
                EnumRadioButtonWithTextField(
                    choices = patientDecision.keys.toTypedArray(),
                    labels = patientDecision,
                    currentChoice = interimViewModel.interimStates.patientAction.choice,
                    onSelection = {
                    },
                    onChangeTextValue = {},
                    title = patientDecisionTitles,
                    textValues = mapOf(),
                    hasTextfield = patientDecisionTextfields,
                )
            }
            //preliminaryAssessment content
            TitledSection(title = stringResource(id = R.string.preliminaryAssessment)) {
                Column {
                    TitledTextField(
                        modifier = Modifier
                            .padding(16.dp)
                            .height(160.dp)
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
            TitledSection(title = stringResource(id = R.string.hospitalization)) {
                Row {
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
                            onSelectionChanged = { /* TODO: Wait for backend change from val to var*/ },
                            gridLayout = GridCells.Adaptive(300.dp),
                            checkboxSpacing = 1.dp
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
                            choices = arrivalLaws.keys.toTypedArray(),
                            labels = arrivalLaws,
                            selection = interimViewModel.interimStates.hospitalization.laws,
                            onSelectionChanged = { /* TODO: Wait for backend change from val to var*/ },
                            gridLayout = GridCells.Adaptive(300.dp),
                            checkboxSpacing = 1.dp
                        )
                    }

                }
            }
        }
    }
}

@Composable
fun PatientDecisionContent(

) {


}
