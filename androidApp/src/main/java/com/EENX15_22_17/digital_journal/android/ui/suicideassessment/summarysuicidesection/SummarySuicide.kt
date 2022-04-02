package com.EENX15_22_17.digital_journal.android.ui.suicideassessment.summarysuicidesection

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.EENX15_22_17.digital_journal.android.ui.components_beta.getCheckBoxBtn
import com.EENX15_22_17.digital_journal.android.ui.theme.colorTextBlackLight

@Composable
fun SummarySuicide() {
    Column() {

        Text(
            text = "Suicidstegen ",
            style = TextStyle(fontSize = 16.sp),
            color = colorTextBlackLight,
        )

        Box(modifier = Modifier.size(width = 20.dp, height = 230.dp))
    }
}
