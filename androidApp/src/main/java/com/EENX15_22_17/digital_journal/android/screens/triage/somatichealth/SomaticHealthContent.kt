package com.EENX15_22_17.digital_journal.android.screens.triage.somatichealth

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.EENX15_22_17.digital_journal.android.R
import com.EENX15_22_17.digital_journal.android.ui.components.EnumCheckBoxLazyGrid
import com.EENX15_22_17.digital_journal.android.ui.components.EnumRadioButtonsHorizontal
import com.EENX15_22_17.digital_journal.android.dataModel.YesNo
import com.EENX15_22_17.digital_journal.android.ui.components.TitledTextField

@Composable
fun <E : Enum<*>> SomaticHealth(
    choices: Array<E>,
    onChange: (values: Set<E>) -> Unit,
    currentSelected: Set<E>,
    labels: Map<E, String>,
) {
    EnumCheckBoxLazyGrid(
        choices = choices,
        onSelectionChanged = onChange,
        currentSelected = currentSelected,
        labels = labels,
        gridLayout = GridCells.Adaptive(300.dp)
    )
}

@Composable
fun BloodInfection(
    isBloodInfection: YesNo,
    onBloodInfection: (value: YesNo) -> Unit,
    choices: Array<YesNo>,
    labels: Map<YesNo, String>
) {
    EnumRadioButtonsHorizontal(
        choices = choices,
        labels = labels,
        currentChoice = isBloodInfection,
        onSelection = onBloodInfection
    )
}

@Composable
fun BloodInfectionType(
    onChangeText: (textValue: String) -> Unit,
    textValue: String
) {
    TitledTextField(
        title = "Typ",
        onChangeText = onChangeText,
        textValue = textValue
    )
}

@Composable
fun Hypersensitivity(
    isHypersensitiv: YesNo,
    onHypersensitiv: (value: YesNo) -> Unit,
    choices: Array<YesNo>,
    labels: Map<YesNo, String>
) {
    EnumRadioButtonsHorizontal(
        choices = choices,
        labels = labels,
        currentChoice = isHypersensitiv,
        onSelection = onHypersensitiv
    )
}

@Composable
fun HypersensitivityType(
    onChangeText: (textValue: String) -> Unit,
    textValue: String
) {
    TitledTextField(
        title = "Mot",
        onChangeText = onChangeText,
        textValue = textValue
    )

}

@Composable
fun Multiresistant(
    isMultiresistant: YesNo,
    onMultiresistant: (value: YesNo) -> Unit,
    choices: Array<YesNo>,
    labels: Map<YesNo, String>
) {
    EnumRadioButtonsHorizontal(
        choices = choices,
        labels = labels,
        currentChoice = isMultiresistant,
        onSelection = onMultiresistant
    )
}

@Composable
fun SuspicionGE(
    isSuspicionGE: YesNo,
    onSuspicionGE: (value: YesNo) -> Unit,
    choices: Array<YesNo>,
    labels: Map<YesNo, String>
) {
    EnumRadioButtonsHorizontal(
        choices = choices,
        labels = labels,
        currentChoice = isSuspicionGE,
        onSelection = onSuspicionGE
    )
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
        EnumCheckBoxLazyGrid(
            choices = choices,
            onSelectionChanged = setValues,
            currentSelected = currentValues,
            labels = labels,
            gridLayout = GridCells.Adaptive(200.dp)
        )
    }
}
