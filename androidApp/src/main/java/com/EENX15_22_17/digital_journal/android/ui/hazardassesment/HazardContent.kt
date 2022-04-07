package com.EENX15_22_17.digital_journal.android.ui.hazardassesment

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.EENX15_22_17.digital_journal.android.R
import com.EENX15_22_17.digital_journal.android.ui.components.*

@Composable
fun ActionTakenTextField(
    setActionTaken: (actionTaken: String) -> Unit,
    actionTaken: String,
) {
    TitledTextField(
        modifier = Modifier
            .width(600.dp)
            .height(250.dp),
        title = stringResource(id = R.string.hazardActionTaken),
        onChangeText = setActionTaken,
        textValue = actionTaken
    )
}

@Composable
fun InitialHazardAssessmentCheckboxes(
    choices: Array<DangerType>,
    onSelectionChange: (values: Set<DangerType>) -> Unit,
    currentSelected: Set<DangerType>,
    labels: Map<DangerType, String>

) {
    Row(horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.Top) {
        EnumCheckBoxLazyGrid(
            choices = choices,
            onSelectionChanged = onSelectionChange,
            currentSelected = currentSelected,
            labels = labels,
            gridLayout = GridCells.Adaptive(200.dp)
        )
    }
}

@Composable
fun HazardousBehaviours(
    choices: Array<DangerBehaviors>,
    onChange: (values: Set<DangerBehaviors>) -> Unit,
    currentSelected: Set<DangerBehaviors>,
    labels: Map<DangerBehaviors, String>

) {
    EnumCheckBoxLazyGrid(
        choices = choices,
        onSelectionChanged = onChange,
        currentSelected = currentSelected,
        labels = labels,
        gridLayout = GridCells.Adaptive(300.dp)
    )
}

