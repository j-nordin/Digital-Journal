package com.EENX15_22_17.digital_journal.android.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Timer
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.EENX15_22_17.digital_journal.android.ui.theme.colorTextGray

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

@Composable
fun UnclickableChip(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = colorTextGray,
    icon: ImageVector? = null
) {
    Surface(
        modifier = modifier.padding(8.dp),
        shape = CircleShape,
        border = BorderStroke(width = 1.dp, color = color)
    ) {
        Row(
            modifier = modifier.wrapContentWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (icon != null) {
                Icon(
                    modifier = modifier
                        .padding(start = 8.dp, top = 4.dp, bottom = 4.dp)
                        .size(17.dp),
                    imageVector = icon,
                    contentDescription = icon.name,
                    tint = color
                )
            }
            Text(
                modifier = modifier.padding(
                    top = 4.dp,
                    bottom = 4.dp,
                    end = 8.dp,
                    start = when {
                        icon == null -> 8.dp
                        else -> 3.dp
                    }
                ),
                text = text,
                color = color
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewUnclickableChip() {
    Column() {
        UnclickableChip(text = "Väktare", color = colorTextGray)
        UnclickableChip(text = "Tillsyn: 15:22", color = colorTextGray, icon = Icons.Default.Timer)
    }
}