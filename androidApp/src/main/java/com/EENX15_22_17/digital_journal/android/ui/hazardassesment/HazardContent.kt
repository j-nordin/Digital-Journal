package com.EENX15_22_17.digital_journal.android.ui.hazardassesment

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
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
    values: MutableSet<DangerType>,
    onChange: (values: Set<DangerType>) -> Unit
) {
    Row(horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.Top) {
        EnumCheckBoxHorizontal(
            choices = dangerTypes.keys.toTypedArray(),
            onSelectionChanged = onChange,
            currentSelected = values,
            labels = dangerTypes
        )
    }
}

@Composable
fun HazardousBehaviours(
    values: MutableSet<DangerBehaviors>,
    onChange: (values: Set<DangerBehaviors>) -> Unit
) {
    EnumCheckBoxHorizontal(
        choices = dangerBehaviors.keys.toTypedArray(),
        onSelectionChanged = onChange,
        currentSelected = values,
        labels = dangerBehaviors
    )
}

