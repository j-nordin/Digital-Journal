package com.EENX15_22_17.digital_journal.android.ui.triage.history

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
import androidx.compose.ui.unit.dp
import com.EENX15_22_17.digital_journal.android.dataModel.NursesNeeds
import com.EENX15_22_17.digital_journal.android.dataModel.YesNo
import com.EENX15_22_17.digital_journal.android.dataModel.nursesNeeds
import com.EENX15_22_17.digital_journal.android.dataModel.yesNoLabels
import com.EENX15_22_17.digital_journal.android.ui.theme.borderColor

@Composable
fun HealthHistoryPage(
    healthHistoryViewModel: HealthHistoryViewModel = HealthHistoryViewModel(),
    visitId: String = "id",
    navBack: () -> Unit = { }
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


    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = "Ankomst sidan för patient: $visitId")
        Button(onClick = navBack) {
            Text(text = "Gå tillbaka")
        }
        Row(modifier = rowModifier) {
            healthHistoryViewModel.somaticHealth.value?.let { somaticHealth ->
                SomaticHealth(
                    choices = somaticHealthValues.keys.toTypedArray(),
                    onChange = { healthHistoryViewModel.somaticHealth.value = it },
                    currentSelected = healthHistoryViewModel.somaticHealth.value ?: emptySet(),
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
                        isBloodInfection = healthHistoryViewModel.isBloodInfection.value
                            ?: YesNo.UNKOWN,
                        onBloodInfection = { healthHistoryViewModel.isBloodInfection.value = it },
                        choices = yesNoLabels.keys.toTypedArray(),
                        labels = yesNoLabels
                    )
                    BloodInfectionType(
                        onChangeText = { healthHistoryViewModel.bloodInfectionType.value = it },
                        textValue = healthHistoryViewModel.bloodInfectionType.value ?: ""
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
                        isHypersensitiv = healthHistoryViewModel.isHyperSensitive.value
                            ?: YesNo.UNKOWN,
                        onHypersensitiv = { healthHistoryViewModel.isHyperSensitive.value = it },
                        choices = yesNoLabels.keys.toTypedArray(),
                        labels = yesNoLabels
                    )
                    HypersensitivityType(
                        onChangeText = { healthHistoryViewModel.hyperSensitiveType.value = it },
                        textValue = healthHistoryViewModel.hyperSensitiveType.value ?: ""
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
                    isMultiresistant = healthHistoryViewModel.isMultiresistant.value
                        ?: YesNo.UNKOWN,
                    onMultiresistant = { healthHistoryViewModel.isMultiresistant.value = it },
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
                    isSuspicionGE = healthHistoryViewModel.suspicionGE.value ?: YesNo.UNKOWN,
                    onSuspicionGE = { healthHistoryViewModel.suspicionGE.value = it },
                    choices = yesNoLabels.keys.toTypedArray(),
                    labels = yesNoLabels
                )
            }
        }
        Row(modifier = rowModifier) {
            var isRendered by rememberSaveable { mutableStateOf(healthHistoryViewModel.isNursesNeed.value) }
            NursesNeeds(
                isNursesNeeds = healthHistoryViewModel.isNursesNeed.value ?: YesNo.UNKOWN,
                onNursesNeeds = {
                    healthHistoryViewModel.isNursesNeed.value = it
                    isRendered = healthHistoryViewModel.isNursesNeed.value
                },
                choices = yesNoLabels.keys.toTypedArray(),
                labels = yesNoLabels
            )
            if (isRendered?.equals(YesNo.YES) == true) {
                NursesNeedsAlternative(
                    currentValues = healthHistoryViewModel.nursesNeedsAlternatives.value
                        ?: setOf<NursesNeeds>(),
                    setValues = { healthHistoryViewModel.nursesNeedsAlternatives.value = it },
                    choices = nursesNeeds.keys.toTypedArray(),
                    labels = nursesNeeds
                )
            }
        }
    }
}