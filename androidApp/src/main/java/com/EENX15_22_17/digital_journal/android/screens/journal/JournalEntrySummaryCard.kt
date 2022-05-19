package com.EENX15_22_17.digital_journal.android.screens.journal

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.EENX15_22_17.digital_journal.android.ui.components.CardChip
import com.EENX15_22_17.digital_journal.android.ui.components.CardChipWithBorders
import com.EENX15_22_17.digital_journal.android.ui.components.TitledSectionWithRettsColor
import com.EENX15_22_17.digital_journal.android.ui.theme.Colors
import se.predicare.journal.data.JournalEntryDto
import se.predicare.journal.screens.HazardAssessmentDto
import se.predicare.journal.screens.SomaticHealthDto


@Composable
fun JournalEntrySummaryCard(journal: JournalEntryDto) {
    /*Text(text = journal?._id ?: "")*/
    TitledSectionWithRettsColor(title = "Patientjournal") {
        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
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
    Row(modifier = Modifier.padding(top = 16.dp)) {
        Text(
            text = "Omvårdnatdsbehov: ",
            fontWeight = FontWeight.ExtraBold
        )
        //TODO: Value should be Ja or Nej
        CardChip(
            value = somaticHealthDto.requiresNursingCare.name,
            color = Color.Red
        )
        Row(
            modifier = Modifier.padding(start = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            if (somaticHealthDto.requiredNursingCare.size > 0) {
                somaticHealthDto.requiredNursingCare.forEach { nursingCare ->
                    //TODO: value should be real nursingCare Strings
                    CardChipWithBorders(
                        modifier = Modifier
                            .width(120.dp)
                            .height(30.dp),
                        value = nursingCare.name,
                        backgroundColor = Color.White,
                        color = Colors.triagePrimary,
                        shape = CircleShape,
                        border = BorderStroke(2.dp, Colors.triagePrimary)
                    )
                }
            } else {
                //TODO: Remove, just temporary to see how it looks
                CardChipWithBorders(
                    modifier = Modifier
                        .width(120.dp)
                        .height(30.dp),
                    value = "VÄTSKEINTAG",
                    backgroundColor = Color.White,
                    color = Colors.triagePrimary,
                    shape = CircleShape,
                    border = BorderStroke(2.dp, Colors.triagePrimary)
                )
                CardChipWithBorders(
                    modifier = Modifier
                        .width(120.dp)
                        .height(30.dp),
                    value = "GÅ+STÅ",
                    color = Colors.triagePrimary,
                    backgroundColor = Color.White,
                    shape = CircleShape,
                    border = BorderStroke(2.dp, Colors.triagePrimary)
                )
            }
        }
    }
}


@Composable
fun BVCActions(
    hazardAssessmentDto: HazardAssessmentDto,
) {
    Row(horizontalArrangement = Arrangement.spacedBy(30.dp)) {
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
