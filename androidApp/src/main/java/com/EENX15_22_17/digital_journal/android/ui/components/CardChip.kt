package com.EENX15_22_17.digital_journal.android.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun CardChip(
    modifier: Modifier = Modifier,
    value: String,
    color: Color,
    shape: Shape = RectangleShape,
) {
    Card(
        modifier = modifier.size(16.dp),
        elevation = 5.dp,
        shape = shape,
        backgroundColor = color,
    ) {
        Text(
            text = value,
            color = Color.White,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun CardChipWithBorders(
    modifier: Modifier = Modifier,
    value: String,
    color: Color,
    backgroundColor: Color,
    shape: Shape = RectangleShape,
    border: BorderStroke
) {
    Card(
        modifier = modifier.size(16.dp),
        elevation = 5.dp,
        shape = shape,
        backgroundColor = backgroundColor,
        border = border
    ) {
        Text(
            text = value,
            color = color,
            textAlign = TextAlign.Center
        )
    }
}