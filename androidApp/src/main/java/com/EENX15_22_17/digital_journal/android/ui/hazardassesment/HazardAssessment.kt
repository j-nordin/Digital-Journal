package com.EENX15_22_17.digital_journal.android.ui.hazardassesment

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.EENX15_22_17.digital_journal.android.ui.hazardassesment.*
import com.EENX15_22_17.digital_journal.android.R
import com.EENX15_22_17.digital_journal.android.ui.arrivalpage.ArrivalViewModel
import com.EENX15_22_17.digital_journal.android.ui.theme.borderColor


@Composable
fun HazardAssessment(
    navBack: () -> Unit,
    hazardViewModel: HazardViewModel = HazardViewModel(),
    visitId: String
) {
    val rowModifier: Modifier = Modifier
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
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.dangerAssessmentHeader),
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center,
            fontSize = 30.sp
        )
        Row(modifier = rowModifier) {
            InitialHazardAssessmentCheckboxes(
                choices = dangerTypes.keys.toTypedArray(),
                onSelectionChange = { hazardViewModel.hazardStates.initialAssessment = it },
                currentSelected = hazardViewModel.hazardStates.initialAssessment,
                labels = dangerTypes
            )
        }
        Text(stringResource(id = R.string.BVC))
        Row(modifier = rowModifier) {
            HazardousBehaviours(
                choices = dangerBehaviors.keys.toTypedArray(),
                onChange = { hazardViewModel.hazardStates.specifiedBehavior = it },
                currentSelected = hazardViewModel.hazardStates.specifiedBehavior,
                labels = dangerBehaviors
            )
        }
        Row() {
            Text("Number of BVC: ${hazardViewModel.hazardStates.specifiedBehavior.size}")
            if (hazardViewModel.hazardStates.specifiedBehavior.size > 1) {
                ActionTakenTextField(setActionTaken = {}, actionTaken = "")
            }
        }
        Button(onClick = navBack) {
            Text(text = "Back")
        }
    }
}