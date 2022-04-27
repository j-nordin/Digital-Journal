package com.EENX15_22_17.digital_journal.android.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.internal.composableLambda
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.EENX15_22_17.digital_journal.android.ui.theme.colorTextGray


@Composable
fun TitledSection(
    title: String,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Box(modifier) {
        Text(
            text = title,
            style = MaterialTheme.typography.h6,
            color = Color.Black,
            modifier = Modifier
                .zIndex(1f)
                .padding(horizontal = 20.dp)
                .background(color = Color.White, shape = CircleShape)
                .padding(horizontal = 2.dp)

        )
        Box(
            Modifier
                .fillMaxWidth()
                .padding(vertical = 15.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(BorderStroke(1.dp, colorTextGray), shape = RoundedCornerShape(5))
                    .padding(top = 30.dp, bottom = 10.dp, start = 10.dp, end = 10.dp),
                content = { content() },
            )
        }
    }
}


@Composable
fun TitledSectionWithRettsColor(
    title: String,
    modifier: Modifier = Modifier,
    color: Color = Color.White,
    content: @Composable () -> Unit
) {
    Box(modifier) {
        Row(modifier = Modifier.zIndex(1f)) {
            Box(
                modifier = Modifier
                    .size(30.dp)
                    .background(color = color, CircleShape)
                    .border(2.dp, Color.Black, CircleShape)
            )
            Text(
                text = title,
                style = MaterialTheme.typography.h6,
                color = Color.Black,
                modifier = Modifier
                    .zIndex(1f)
                    .padding(horizontal = 20.dp)
                    .background(color = Color.White, shape = CircleShape)
                    .padding(horizontal = 2.dp)

            )
        }

        Box(
            Modifier
                .fillMaxWidth()
                .padding(vertical = 15.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(BorderStroke(1.dp, colorTextGray), shape = RoundedCornerShape(5))
                    .padding(top = 30.dp, bottom = 10.dp, start = 10.dp, end = 10.dp),
                content = { content() },
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
private fun PreviewTitledSection() {
    TitledSection(title = "Titel") {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Gray)
        )
    }
}
