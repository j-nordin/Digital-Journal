package com.EENX15_22_17.digital_journal.android.ui.triage.history

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.EENX15_22_17.digital_journal.android.R
import com.EENX15_22_17.digital_journal.android.ui.components.EnumCheckBoxVertical


//FIXME: When having multiple EnumChecbox groups the value is resetting if we click on new group.
@Composable
fun SomaticHealth(
    currentValues: Set<SomaticHealthData>,
    onChange: (values: Set<SomaticHealthData>) -> Unit,
    modifier: Modifier = Modifier
) {
    Column {
        Text(
            text = stringResource(id = R.string.somaticHealth),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 16.dp)
        )
        Row ( horizontalArrangement = Arrangement.spacedBy(60.dp)) {
            EnumCheckBoxVertical(
                choices = somaticHealthValues.keys.toTypedArray().sliceArray(0..4),
                onSelectionChanged = onChange,
                currentSelected = currentValues.toMutableSet(),
                labels = somaticHealthValues
            )
            EnumCheckBoxVertical(
                choices = somaticHealthValues.keys.toTypedArray().sliceArray(5..9),
                onSelectionChanged = onChange,
                currentSelected = currentValues.toMutableSet(),
                labels = somaticHealthValues
            )
            EnumCheckBoxVertical(
                choices = somaticHealthValues.keys.toTypedArray().sliceArray(10..15),
                onSelectionChanged = onChange,
                currentSelected = currentValues.toMutableSet(),
                labels = somaticHealthValues
            )
        }
    }
}