package com.EENX15_22_17.digital_journal.android.screens.triage.somatichealth

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.EENX15_22_17.digital_journal.android.R
import com.EENX15_22_17.digital_journal.android.dataModel.NursesNeeds
import com.EENX15_22_17.digital_journal.android.dataModel.YesNo
import com.EENX15_22_17.digital_journal.android.dataModel.nursesNeeds
import com.EENX15_22_17.digital_journal.android.dataModel.yesNoLabels
import com.EENX15_22_17.digital_journal.android.ui.DetailPageWrapper
import com.EENX15_22_17.digital_journal.android.ui.components.*
import com.EENX15_22_17.digital_journal.android.ui.theme.Colors

@Composable
fun HealthHistoryPage(
    somaticHealthViewModel: SomaticHealthViewModel = SomaticHealthViewModel(),
    visitId: String = "id",
    onBackClicked: () -> Unit = { },
    onMenuClicked: () -> Unit
) {
    DetailPageWrapper(
        title = stringResource(id = R.string.somaticHealth),
        titleColor = Colors.arrivalPrimary,
        onBackClicked = onBackClicked,
        onMenuClicked = onMenuClicked
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {

            // SomaticHealth choices
            TitledSection(title = stringResource(id = R.string.somaticHealth)) {
                somaticHealthViewModel.somaticHealth.value?.let { _ ->
                    EnumCheckboxesLazyGrid(
                        choices = somaticHealthValues.keys.toTypedArray(),
                        onSelectionChanged = { somaticHealthViewModel.somaticHealth.value = it },
                        selection = somaticHealthViewModel.somaticHealth.value ?: emptySet(),
                        labels = somaticHealthValues,
                        gridLayout = GridCells.Adaptive(300.dp)
                    )
                }
            }

            Row {
                TitledSection(
                    title = stringResource(id = R.string.hypersensitivity),
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .padding(horizontal = 4.dp)
                ) {
                    Row {
                        // Hypersensitive content
                        EnumRadioButtonsHorizontal(
                            currentChoice = somaticHealthViewModel.isHyperSensitive.value
                                ?: YesNo.UNKOWN,
                            onSelection = {
                                somaticHealthViewModel.isHyperSensitive.value = it
                            },
                            choices = yesNoLabels.keys.toTypedArray(),
                            labels = yesNoLabels
                        )
                        TitledTextField(
                            title = "Mot",
                            onChangeText = { somaticHealthViewModel.hyperSensitiveType.value = it },
                            textValue = somaticHealthViewModel.hyperSensitiveType.value ?: ""
                        )
                    }

                }

                TitledSection(
                    title = stringResource(id = R.string.bloodInfection),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row {
                        //Blood infection content
                        EnumRadioButtonsHorizontal(
                            currentChoice = somaticHealthViewModel.isBloodInfection.value
                                ?: YesNo.UNKOWN,
                            onSelection = {
                                somaticHealthViewModel.isBloodInfection.value = it
                            },
                            choices = yesNoLabels.keys.toTypedArray(),
                            labels = yesNoLabels
                        )
                        TitledTextField(
                            title = "Typ",
                            onChangeText = { somaticHealthViewModel.bloodInfectionType.value = it },
                            textValue = somaticHealthViewModel.bloodInfectionType.value ?: ""
                        )
                    }
                }
            }
            Row {
                TitledSection(
                    title = stringResource(id = R.string.multiresistant),
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .padding(horizontal = 4.dp)
                ) {
                    //Multi-resistant content
                    EnumRadioButtonsHorizontal(
                        currentChoice = somaticHealthViewModel.isMultiresistant.value
                            ?: YesNo.UNKOWN,
                        onSelection = { somaticHealthViewModel.isMultiresistant.value = it },
                        choices = yesNoLabels.keys.toTypedArray(),
                        labels = yesNoLabels
                    )
                }

                TitledSection(
                    title = stringResource(id = R.string.suspicionGE),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    // GE suspicion content
                    EnumRadioButtonsHorizontal(
                        currentChoice = somaticHealthViewModel.suspicionGE.value ?: YesNo.UNKOWN,
                        onSelection = { somaticHealthViewModel.suspicionGE.value = it },
                        choices = yesNoLabels.keys.toTypedArray(),
                        labels = yesNoLabels
                    )
                }
            }

            TitledSection(title = stringResource(id = R.string.nursesNeeds)) {
                Row {
                    var isRendered by rememberSaveable { mutableStateOf(somaticHealthViewModel.isNursesNeed.value) }
                    NursesNeeds(
                        isNursesNeeds = somaticHealthViewModel.isNursesNeed.value ?: YesNo.UNKOWN,
                        onNursesNeeds = {
                            somaticHealthViewModel.isNursesNeed.value = it
                            isRendered = somaticHealthViewModel.isNursesNeed.value
                        },
                        choices = yesNoLabels.keys.toTypedArray(),
                        labels = yesNoLabels
                    )
                    if (isRendered?.equals(YesNo.YES) == true) {
                        NursesNeedsAlternative(
                            currentValues = somaticHealthViewModel.nursesNeedsAlternatives.value
                                ?: setOf<NursesNeeds>(),
                            setValues = {
                                somaticHealthViewModel.nursesNeedsAlternatives.value = it
                            },
                            choices = nursesNeeds.keys.toTypedArray(),
                            labels = nursesNeeds
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun NursesNeeds(
    isNursesNeeds: YesNo,
    onNursesNeeds: (value: YesNo) -> Unit,
    choices: Array<YesNo>,
    labels: Map<YesNo, String>
) {
    EnumRadioButtonsHorizontal(
        choices = choices,
        labels = labels,
        currentChoice = isNursesNeeds,
        onSelection = onNursesNeeds
    )
}

@Composable
fun <E : Enum<E>> NursesNeedsAlternative(
    modifier: Modifier = Modifier,
    currentValues: Set<E>,
    setValues: (value: Set<E>) -> Unit,
    choices: Array<E>,
    labels: Map<E, String>,
) {
    Box(modifier = modifier.padding(start = 40.dp)) {
        EnumCheckboxesLazyGrid(
            choices = choices,
            onSelectionChanged = setValues,
            selection = currentValues,
            labels = labels,
            gridLayout = GridCells.Adaptive(200.dp)
        )
    }
}
