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
import com.EENX15_22_17.digital_journal.android.ui.theme.colorTextGray

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RettsSymtomChip(
    item: RettsClickableData,
    onClick: () -> Unit
) {
    Chip(
        onClick = { onClick() },
        border = BorderStroke(
            2.dp,
            item.color
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
        Text(text=item.data,fontSize = 16.sp)
    }
}


@Composable
@Preview(showBackground = true)
fun RettsSymtomChipPreview() {
    RettsSymtomChip(
        item = RettsClickableData(
            data = "Nedsatt koncentration",
            color = Color.Green
        ), onClick = {}
    )
}
