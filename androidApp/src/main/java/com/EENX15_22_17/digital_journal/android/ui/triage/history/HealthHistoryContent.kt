package com.EENX15_22_17.digital_journal.android.ui.triage.history

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
import com.EENX15_22_17.digital_journal.android.dataModel.yesNoLabels

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
        EnumCheckBoxLazyGrid(
            choices = choices,
            onSelectionChanged = onChange,
            currentSelected = currentSelected,
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
            choices = yesNoLabels.keys.toTypedArray(),
            labels = yesNoLabels,
            currentChoice = isBloodInfection,
            onSelection = onBloodInfection
        )
    }

}