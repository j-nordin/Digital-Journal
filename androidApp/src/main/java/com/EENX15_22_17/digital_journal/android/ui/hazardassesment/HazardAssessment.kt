package com.EENX15_22_17.digital_journal.android.ui.hazardassesment

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.EENX15_22_17.digital_journal.android.ui.hazardassesment.*
import com.EENX15_22_17.digital_journal.android.R
import com.EENX15_22_17.digital_journal.android.screens.treatment.ordination.OrdinationScreen
import com.EENX15_22_17.digital_journal.android.ui.DetailPageWrapper
import com.EENX15_22_17.digital_journal.android.ui.arrivalpage.ArrivalViewModel
import com.EENX15_22_17.digital_journal.android.ui.components.EnumCheckBoxLazyGrid
import com.EENX15_22_17.digital_journal.android.ui.components.TitledSection
import com.EENX15_22_17.digital_journal.android.ui.components.TitledTextField
import com.EENX15_22_17.digital_journal.android.ui.theme.Colors
import com.EENX15_22_17.digital_journal.android.ui.theme.borderColor


@Composable
fun HazardAssessment(
    navBack: () -> Unit,
    // FIXME - This creates a new viewModel each conf. change which is not good. Will need to solve later
    hazardViewModel: HazardViewModel = HazardViewModel(),
    visitId: String
) {
    DetailPageWrapper(
        title = stringResource(id = R.string.dangerAssessmentHeader),
        titleColor = Colors.treatmentPrimary,
        onBackClicked = navBack,
        onMenuClicked = {}
    ) {
        //FIXME, when state issue is solved, this must be updated when clicking on specified behavioir checkboxes
        var bvcNr by rememberSaveable { mutableStateOf(0) }
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
            TitledSection(title = "Initial Bedömning") {
                EnumCheckBoxLazyGrid(
                    choices = dangerTypes.keys.toTypedArray(),
                    onSelectionChanged = { hazardViewModel.hazardStates.initialAssessment = it },
                    currentSelected = hazardViewModel.hazardStates.initialAssessment,
                    labels = dangerTypes,
                    gridLayout = GridCells.Adaptive(270.dp)
                )
            }
            TitledSection(title = stringResource(id = R.string.BVC))
            {
                EnumCheckBoxLazyGrid(
                    choices = dangerBehaviors.keys.toTypedArray(),
                    onSelectionChanged = { hazardViewModel.hazardStates.specifiedBehavior = it },
                    currentSelected = hazardViewModel.hazardStates.specifiedBehavior,
                    labels = dangerBehaviors,
                    gridLayout = GridCells.Adaptive(270.dp)
                )
            }
            TitledSection(title = "Summary") {
                Card(
                    elevation = 2.dp,
                    backgroundColor = Colors.treatmentPrimary,

                    ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Number of BVC: $bvcNr",
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(8.dp)
                        )
                    }
                }
            }
            // FIXME When state issue is solved, this will only appear when BBV >= 2.
            if (bvcNr == 0) {
                Row() {
                    TitledTextField(
                        modifier = Modifier
                            .width(600.dp)
                            .height(250.dp),
                        title = stringResource(id = R.string.hazardActionTaken),
                        onChangeText = { hazardViewModel.hazardStates.takenActions = it },
                        textValue = hazardViewModel.hazardStates.takenActions
                    )
                }
            }
        }
    }
}