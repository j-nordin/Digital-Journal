package com.EENX15_22_17.digital_journal.android.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
@Preview(showBackground = true)
fun TitledSection(
    @PreviewParameter(SampleTitledSectionProvider::class)
    title: String = "Title", content: @Composable () -> Unit = { Box() {
        Text(text = "Content")
    }}
) {

    Box(
        Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, bottom = 10.dp, top = 10.dp)
    ) {
        Text(
            text = title,
            style = TextStyle(fontSize = 26.sp, fontWeight = FontWeight.SemiBold),
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
                .padding(15.dp)

        ) {
            Box(
                content = { content() },
                modifier = Modifier
                    .fillMaxWidth()
                    .border(BorderStroke(1.dp, colorTextGray), shape = RoundedCornerShape(5))
                    .padding(top = 30.dp, bottom = 10.dp, start = 10.dp, end = 10.dp)
            )
        }
    }
}

data class TitledSectionDataClass(
    val title: String,
    val content: @Composable () -> Unit
)

class SampleTitledSectionProvider : PreviewParameterProvider<TitledSectionDataClass> {
    override val values: Sequence<TitledSectionDataClass> = sequenceOf(
        TitledSectionDataClass(title = "Här är en titel", content = {
            Box(modifier = Modifier.background(Color.Red)) {
                Text(text = "Här finns all content")
            }
        })
    )
}
