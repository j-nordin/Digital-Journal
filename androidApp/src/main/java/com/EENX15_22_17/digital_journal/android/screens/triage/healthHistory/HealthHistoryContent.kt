package com.EENX15_22_17.digital_journal.android.screens.triage.healthHistory

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
import com.EENX15_22_17.digital_journal.android.ui.components.EnumCheckboxesLazyGrid
import com.EENX15_22_17.digital_journal.android.ui.components.EnumRadioButtonsHorizontal
import com.EENX15_22_17.digital_journal.android.dataModel.YesNo
import com.EENX15_22_17.digital_journal.android.ui.components.TitledTextField

@Composable
fun <E : Enum<*>> SomaticHealth(
    modifier: Modifier = Modifier,
    choices: Array<E>,
    onChange: (values: Set<E>) -> Unit,
    currentSelected: Set<E>,
    labels: Map<E, String>,
) {

    Column(modifier = modifier) {
        Text(
            text = stringResource(id = R.string.somaticHealth),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 16.dp)
        )
        EnumCheckboxesLazyGrid(
            choices = choices,
            onSelectionChanged = onChange,
            selection = currentSelected,
            labels = labels,
            gridLayout = GridCells.Adaptive(300.dp)
        )
    }
}

@Composable
fun BloodInfection(
    modifier: Modifier = Modifier,
    isBloodInfection: YesNo,
    onBloodInfection: (value: YesNo) -> Unit,
    choices: Array<YesNo>,
    labels: Map<YesNo, String>
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = stringResource(id = R.string.bloodInfection),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 16.dp)
        )
        EnumRadioButtonsHorizontal(
            choices = choices,
            labels = labels,
            currentChoice = isBloodInfection,
            onSelection = onBloodInfection
        )
    }
}

@Composable
fun BloodInfectionType(
    modifier: Modifier = Modifier,
    onChangeText: (textValue: String) -> Unit,
    textValue: String
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = stringResource(id = R.string.bloodInfectionType),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 16.dp)
        )
        TitledTextField(
            title = "Typ",
            onChangeText = onChangeText,
            textValue = textValue
        )
    }
}

@Composable
fun Hypersensitivity(
    modifier: Modifier = Modifier,
    isHypersensitiv: YesNo,
    onHypersensitiv: (value: YesNo) -> Unit,
    choices: Array<YesNo>,
    labels: Map<YesNo, String>
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = stringResource(id = R.string.hypersensitivity),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 16.dp)
        )
        EnumRadioButtonsHorizontal(
            choices = choices,
            labels = labels,
            currentChoice = isHypersensitiv,
            onSelection = onHypersensitiv
        )
    }
}

@Composable
fun HypersensitivityType(
    modifier: Modifier = Modifier,
    onChangeText: (textValue: String) -> Unit,
    textValue: String
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = stringResource(id = R.string.hypersensitivityType),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 16.dp)
        )
        TitledTextField(
            title = "Typ",
            onChangeText = onChangeText,
            textValue = textValue
        )
    }
}

@Composable
fun Multiresistant(
    modifier: Modifier = Modifier,
    isMultiresistant: YesNo,
    onMultiresistant: (value: YesNo) -> Unit,
    choices: Array<YesNo>,
    labels: Map<YesNo, String>
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = stringResource(id = R.string.multiresistant),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 16.dp)
        )
        EnumRadioButtonsHorizontal(
            choices = choices,
            labels = labels,
            currentChoice = isMultiresistant,
            onSelection = onMultiresistant
        )
    }
}

@Composable
fun SuspicionGE(
    modifier: Modifier = Modifier,
    isSuspicionGE: YesNo,
    onSuspicionGE: (value: YesNo) -> Unit,
    choices: Array<YesNo>,
    labels: Map<YesNo, String>
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = stringResource(id = R.string.suspicionGE),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 16.dp)
        )
        EnumRadioButtonsHorizontal(
            choices = choices,
            labels = labels,
            currentChoice = isSuspicionGE,
            onSelection = onSuspicionGE
        )
    }
}

@Composable
fun NursesNeeds(
    modifier: Modifier = Modifier,
    isNursesNeeds: YesNo,
    onNursesNeeds: (value: YesNo) -> Unit,
    choices: Array<YesNo>,
    labels: Map<YesNo, String>
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = stringResource(id = R.string.nursesNeeds),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 16.dp)
        )
        EnumRadioButtonsHorizontal(
            choices = choices,
            labels = labels,
            currentChoice = isNursesNeeds,
            onSelection = onNursesNeeds
        )
    }
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
            gridLayout = GridCells.Adaptive(250.dp)
        )
    }
}


