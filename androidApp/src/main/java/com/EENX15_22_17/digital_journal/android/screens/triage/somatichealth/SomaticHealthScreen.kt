package com.EENX15_22_17.digital_journal.android.screens.triage.somatichealth

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
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
import com.EENX15_22_17.digital_journal.android.ui.theme.Colors
import com.EENX15_22_17.digital_journal.android.ui.theme.borderColor


//DetailPageWrapper(
//title = stringResource(id = R.string.patientInfo),
//titleColor = Colors.arrivalPrimary,
//onBackClicked = onBackClicked,
//onMenuClicked = onMenuClicked
//)

@Composable
fun HealthHistoryPage(
    somaticHealthViewModel: SomaticHealthViewModel = SomaticHealthViewModel(),
    visitId: String = "id",
    onBackClicked: () -> Unit = { },
    onMenuClicked: () -> Unit
) {


    val rowModifier: Modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 6.dp, horizontal = 4.dp)
        .border(
            border = BorderStroke(
                2.dp,
                borderColor
            ),
            shape = RoundedCornerShape(8.dp)
        )
        .padding(horizontal = 16.dp, vertical = 12.dp)

    DetailPageWrapper(
        title = stringResource(id = R.string.somaticHealth),
        titleColor = Colors.arrivalPrimary,
        onBackClicked = onBackClicked,
        onMenuClicked = onMenuClicked
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(text = "Ankomst sidan för patient: $visitId")
            Button(onClick = onBackClicked) {
                Text(text = "Gå tillbaka")
            }
            Row(modifier = rowModifier) {
                somaticHealthViewModel.somaticHealth.value?.let { somaticHealth ->
                    SomaticHealth(
                        choices = somaticHealthValues.keys.toTypedArray(),
                        onChange = { somaticHealthViewModel.somaticHealth.value = it },
                        currentSelected = somaticHealthViewModel.somaticHealth.value ?: emptySet(),
                        labels = somaticHealthValues
                    )
                }
            }
            Row {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .padding(vertical = 6.dp, horizontal = 2.dp)
                        .border(
                            border = BorderStroke(
                                2.dp,
                                borderColor
                            ),
                            shape = RoundedCornerShape(8.dp)
                        )
                        .padding(horizontal = 16.dp, vertical = 12.dp)
                ) {
                    Row {
                        BloodInfection(
                            isBloodInfection = somaticHealthViewModel.isBloodInfection.value
                                ?: YesNo.UNKOWN,
                            onBloodInfection = {
                                somaticHealthViewModel.isBloodInfection.value = it
                            },
                            choices = yesNoLabels.keys.toTypedArray(),
                            labels = yesNoLabels
                        )
                        BloodInfectionType(
                            onChangeText = { somaticHealthViewModel.bloodInfectionType.value = it },
                            textValue = somaticHealthViewModel.bloodInfectionType.value ?: ""
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp, horizontal = 2.dp)
                        .border(
                            border = BorderStroke(
                                2.dp,
                                borderColor
                            ),
                            shape = RoundedCornerShape(8.dp)
                        )
                        .padding(horizontal = 16.dp, vertical = 12.dp)
                ) {
                    Row {
                        Hypersensitivity(
                            isHypersensitiv = somaticHealthViewModel.isHyperSensitive.value
                                ?: YesNo.UNKOWN,
                            onHypersensitiv = {
                                somaticHealthViewModel.isHyperSensitive.value = it
                            },
                            choices = yesNoLabels.keys.toTypedArray(),
                            labels = yesNoLabels
                        )
                        HypersensitivityType(
                            onChangeText = { somaticHealthViewModel.hyperSensitiveType.value = it },
                            textValue = somaticHealthViewModel.hyperSensitiveType.value ?: ""
                        )
                    }

                }
            }

            Row {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .padding(vertical = 6.dp, horizontal = 2.dp)
                        .border(
                            border = BorderStroke(
                                2.dp,
                                borderColor
                            ),
                            shape = RoundedCornerShape(8.dp)
                        )
                        .padding(horizontal = 16.dp, vertical = 12.dp)
                ) {
                    Multiresistant(
                        isMultiresistant = somaticHealthViewModel.isMultiresistant.value
                            ?: YesNo.UNKOWN,
                        onMultiresistant = { somaticHealthViewModel.isMultiresistant.value = it },
                        choices = yesNoLabels.keys.toTypedArray(),
                        labels = yesNoLabels
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp, horizontal = 2.dp)
                        .border(
                            border = BorderStroke(
                                2.dp,
                                borderColor
                            ),
                            shape = RoundedCornerShape(8.dp)
                        )
                        .padding(horizontal = 16.dp, vertical = 12.dp)
                ) {
                    SuspicionGE(
                        isSuspicionGE = somaticHealthViewModel.suspicionGE.value ?: YesNo.UNKOWN,
                        onSuspicionGE = { somaticHealthViewModel.suspicionGE.value = it },
                        choices = yesNoLabels.keys.toTypedArray(),
                        labels = yesNoLabels
                    )
                }
            }
            Row(modifier = rowModifier) {
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
                        setValues = { somaticHealthViewModel.nursesNeedsAlternatives.value = it },
                        choices = nursesNeeds.keys.toTypedArray(),
                        labels = nursesNeeds
                    )
                }
            }
        }
    }
}