package com.EENX15_22_17.digital_journal.android.screens.arrival.hazardassesment

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
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
import com.EENX15_22_17.digital_journal.android.R
import com.EENX15_22_17.digital_journal.android.ui.DetailPageWrapper
import com.EENX15_22_17.digital_journal.android.ui.components.EnumCheckBoxLazyGrid
import com.EENX15_22_17.digital_journal.android.ui.components.TitledSection
import com.EENX15_22_17.digital_journal.android.ui.components.TitledTextField
import com.EENX15_22_17.digital_journal.android.ui.theme.Colors


@Composable
fun HazardAssessment(
    // FIXME - This creates a new viewModel each conf. change which is not good. Will need to solve later
    hazardViewModel: HazardViewModel = HazardViewModel(),
    visitId: String,
    onBackClicked: () -> Unit,
    onMenuClicked: () -> Unit
) {
    DetailPageWrapper(
        title = stringResource(id = R.string.dangerAssessmentHeader),
        titleColor = Colors.arrivalPrimary,
        onBackClicked = onBackClicked,
        onMenuClicked = onMenuClicked
    ) {

        //FIXME, when state issue is solved, this must be updated when clicking on specified behavioir checkboxes
        var bvcNr by rememberSaveable { mutableStateOf(0) }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
        ) {

            Row {
                Box(modifier = Modifier
                    .fillMaxWidth(0.62f)
                    .padding(end = 4.dp)) {
                    TitledSection(title = stringResource(id = R.string.arrivalType)) {
                        ArrivalType(
                            choices = arrivalMethods.keys.toTypedArray(),
                            onChange = { hazardViewModel.hazardStates.arrivalMethod = it },
                            currentSelected = hazardViewModel.hazardStates.arrivalMethod,
                            labels = arrivalMethods
                        )
                    }
                }

                Box(modifier = Modifier.fillMaxWidth()) {
                    TitledSection(title = "Aktuella lagar") {
                        Laws(
                            choices = laws.keys.toTypedArray(),
                            onChange = { hazardViewModel.hazardStates.law = it },
                            currentSelected = hazardViewModel.hazardStates.law,
                            labels = laws
                        )
                    }
                }

            }

            TitledSection(
                title = stringResource(id = R.string.InitialHazardAssessment)
            ) {
                EnumCheckBoxLazyGrid(
                    choices = dangerTypes.keys.toTypedArray(),
                    onSelectionChanged = {
                        hazardViewModel.hazardStates.initialAssessment = it
                    },
                    currentSelected = hazardViewModel.hazardStates.initialAssessment,
                    labels = dangerTypes,
                    gridLayout = GridCells.Adaptive(270.dp)
                )
            }
            TitledSection(title = stringResource(id = R.string.specifiedBehavior))
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
                Column {
                    Text(text = stringResource(id = R.string.BVC))
                    Card(
                        elevation = 2.dp,
                        backgroundColor = Colors.treatmentPrimary,
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
                TitledTextField(
                    modifier = Modifier
                        .width(650.dp)
                        .height(250.dp),
                    title = stringResource(id = R.string.hazardActionTaken),
                    onChangeText = { hazardViewModel.hazardStates.takenActions = it },
                    textValue = hazardViewModel.hazardStates.takenActions
                )
            }
        }
    }
}

@Composable
fun Laws(
    modifier: Modifier = Modifier,
    choices: Array<Law>,
    onChange: (values: Set<Law>) -> Unit,
    currentSelected: Set<Law>,
    labels: Map<Law, String>,

    ) {
    Column(
        modifier = modifier
    ) {
        EnumCheckBoxLazyGrid(
            choices = choices,
            onSelectionChanged = onChange,
            currentSelected = currentSelected,
            labels = labels,
            gridLayout = GridCells.Adaptive(92.dp)
        )
    }
}

@Composable
fun ArrivalType(
    modifier: Modifier = Modifier,
    choices: Array<ArrivalMethod>,
    onChange: (values: Set<ArrivalMethod>) -> Unit,
    currentSelected: Set<ArrivalMethod>,
    labels: Map<ArrivalMethod, String>,
) {
    Column(
        modifier = modifier
    ) {
        EnumCheckBoxLazyGrid(
            choices = choices,
            onSelectionChanged = onChange,
            currentSelected = currentSelected,
            labels = labels,
            gridLayout = GridCells.Adaptive(180.dp),
            isHorizontal = false
        )
    }
}