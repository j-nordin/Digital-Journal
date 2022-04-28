package com.EENX15_22_17.digital_journal.android.screens.journal.triage.contactReason


import androidx.compose.foundation.BorderStroke
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.RemoveCircleOutline
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.EENX15_22_17.digital_journal.android.ui.theme.Colors.getAndroidColor
import com.EENX15_22_17.digital_journal.android.ui.theme.colorTextGray
import se.predicare.journal.screens.ContactReasonDto
import se.predicare.retts.RettsColor

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RettsSymtomChip(
    symptom: ContactReasonDto.RettsSymptom,
    onClick: () -> Unit
) {
    Chip(
        onClick = { onClick() },
        border = BorderStroke(
            2.dp,
            symptom.color.getAndroidColor()
        ),
        colors = ChipDefaults.chipColors(
            backgroundColor = Color.White,
            contentColor = colorTextGray
        ),
        leadingIcon = {
            Icon(
                Icons.Filled.RemoveCircleOutline,
                contentDescription = "delete",
                tint = colorTextGray
            )
        },
    ) {
        Text(text=symptom.description,fontSize = 16.sp)
    }
}


@Composable
@Preview(showBackground = true)
fun RettsSymtomChipPreview() {
    RettsSymtomChip(
        ContactReasonDto.RettsSymptom(
            essIndex = 123,
            description = "Nedsatt koncentration",
            color = RettsColor.ORANGE
        ), onClick = {}
    )
}
