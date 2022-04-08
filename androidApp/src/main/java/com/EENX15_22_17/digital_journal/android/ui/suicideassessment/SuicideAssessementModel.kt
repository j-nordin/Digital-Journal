package com.EENX15_22_17.digital_journal.android.ui.suicideassessment.protectivefactors

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.EENX15_22_17.digital_journal.android.R
import com.EENX15_22_17.digital_journal.android.ui.components.EnumCheckBoxLazyGrid
import com.EENX15_22_17.digital_journal.android.ui.components_beta.CheckBoxData
import com.EENX15_22_17.digital_journal.android.ui.components_beta.CheckboxSection
import com.EENX15_22_17.digital_journal.android.ui.theme.colorCheckBoxBeta
import com.EENX15_22_17.digital_journal.android.ui.triage.history.SomaticHealth
import com.EENX15_22_17.digital_journal.android.ui.triage.history.somaticHealthValues

@Composable
fun <E : Enum<*>> SuicideAssessmentModel (
    modifier: Modifier = Modifier,
    choices: Array<E>,
    onChange: (values: Set<E>) -> Unit,
    currentSelected: Set<E>,
    labels: Map<E, String>,
) {

    Column(modifier = modifier) {

        EnumCheckBoxLazyGrid(
            choices = choices,
            onSelectionChanged = onChange,
            currentSelected = currentSelected,
            labels = labels,
            gridLayout = GridCells.Adaptive(300.dp),
            textFontSize = 18,
            circleBgColor = colorCheckBoxBeta
        )

    }
}
