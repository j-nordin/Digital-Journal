package com.EENX15_22_17.digital_journal.android.screens.journal.triage.suicideAssessment.protectivefactors

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.EENX15_22_17.digital_journal.android.ui.components.EnumCheckboxesLazyGrid

@Composable
fun <E : Enum<*>> SuicideAssessmentModel(
    modifier: Modifier = Modifier,
    choices: Array<E>,
    onChange: (values: Set<E>) -> Unit,
    currentSelected: Set<E>,
    labels: Map<E, String>,
) {

    Column(modifier = modifier) {

        EnumCheckboxesLazyGrid(
            choices = choices,
            onSelectionChanged = onChange,
            selection = currentSelected,
            labels = labels,
            gridLayout = GridCells.Adaptive(300.dp)
        )

    }
}
