package com.EENX15_22_17.digital_journal.android.screens.journal

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.EENX15_22_17.digital_journal.android.ui.components.CardChip
import com.EENX15_22_17.digital_journal.android.ui.components.CardChipWithBorders
import com.EENX15_22_17.digital_journal.android.ui.components.TitledSectionWithRettsColor
import com.EENX15_22_17.digital_journal.android.ui.components.UnclickableChip
import com.EENX15_22_17.digital_journal.android.ui.theme.Colors
import com.EENX15_22_17.digital_journal.android.ui.theme.summarySuicideCard
import se.predicare.journal.data.JournalEntryDto
import se.predicare.journal.screens.HazardAssessmentDto
import se.predicare.journal.screens.SomaticHealthDto


@Composable
fun JournalEntrySummaryCard(journal: JournalEntryDto) {
    /*Text(text = journal?._id ?: "")*/
    TitledSectionWithRettsColor(title = "Patientjournal") {
        Column(verticalArrangement = Arrangement.spacedBy(15.dp)) {
            Row(horizontalArrangement = Arrangement.spacedBy(30.dp)) {
                Text(
                    text = "Namn: ${journal.patientInfo.patientData?.name}",
                    fontWeight = FontWeight.ExtraBold
                )
                Text(
                    text = "Personnummer: ${journal.patientInfo.patientData?.personalId}",
                    fontWeight = FontWeight.ExtraBold
                )
            }
            BVCActions(hazardAssessmentDto = journal.hazardAssessment)
            NursingCareContent(somaticHealthDto = journal.somaticHealth)
        }
    }
}


@Composable
fun NursingCareContent(
    somaticHealthDto: SomaticHealthDto
) {
    Row(verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Omvårdnadsbehov: ",
            fontWeight = FontWeight.ExtraBold
        )
        //TODO: Value should be Ja or Nej
        CardChip(
            value = somaticHealthDto.requiresNursingCare.name,
            color = Color.Red
        )
        Row(
            modifier = Modifier.padding(start = 16.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            if (somaticHealthDto.requiredNursingCare.size > 0) {
                somaticHealthDto.requiredNursingCare.forEach { nursingCare ->
                    UnclickableChip(text = nursingCare.name, color = summarySuicideCard)
                }
            } else {
                //TODO: Remove, just temporary to see how it looks
                UnclickableChip(text = "Vätskeintag", color = summarySuicideCard)
                UnclickableChip(text = "Ambulanssida", color = summarySuicideCard)
            }
        }
    }
}


@Composable
fun BVCActions(
    hazardAssessmentDto: HazardAssessmentDto,
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(30.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row {
            Text(
                text = "BVC-poäng: ",
                fontWeight = FontWeight.ExtraBold
            )
            CardChip(
                value = hazardAssessmentDto.hazardAssessmentStatements.size.toString(),
                color = Color.Red
            )
        }

        Row {
            Text(
                text = "Vidtagna åtgärder: ",
                fontWeight = FontWeight.ExtraBold
            )
            if (hazardAssessmentDto.hazardAssessmentActionsTaken != null) {
                Text(text = hazardAssessmentDto.hazardAssessmentActionsTaken!!)
            } else {
                Text(text = "Inga åtgärder tagna")
            }
        }
    }
}
