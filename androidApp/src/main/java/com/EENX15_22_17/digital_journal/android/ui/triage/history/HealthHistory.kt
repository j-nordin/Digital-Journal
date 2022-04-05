package com.EENX15_22_17.digital_journal.android.ui.triage.history

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.EENX15_22_17.digital_journal.android.ui.theme.borderColor

@Composable
fun HealthHistoryPage(
    healthHistoryViewModel: HealthHistoryViewModel = HealthHistoryViewModel(),
    visitId: String = "id",
    navBack: () -> Unit = { }
) {
    val rowModifier: Modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 6.dp, horizontal = 4.dp)
        .border(
            border = BorderStroke(
                2.dp,
                borderColor
            ),
            shape = RoundedCornerShape(8.dp)
        )
        .padding(horizontal = 16.dp, vertical = 12.dp)


    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = "Ankomst sidan för patient: $visitId")
        Button(onClick = navBack) {
            Text(text = "Gå tillbaka")
        }
        Row(modifier = rowModifier) {
            healthHistoryViewModel.somaticHealth.value?.let { somaticHealth ->
                SomaticHealth(
                    choices = somaticHealthValues.keys.toTypedArray(),
                    onChange = { healthHistoryViewModel.somaticHealth.value = it },
                    currentSelected = healthHistoryViewModel.somaticHealth.value ?: emptySet(),
                    labels = somaticHealthValues
                )
            }
        }
    }
}