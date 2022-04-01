package com.EENX15_22_17.digital_journal.android.ui.suicideassessment

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.EENX15_22_17.digital_journal.android.ui.suicideassessment.suicideSteps.SuicideStepsData
import com.EENX15_22_17.digital_journal.android.ui.theme.colorTextBlackLight

@Composable
fun SuicideStepSection(items : List<SuicideStepsData>,
) {
    Column (
        modifier = Modifier
            .background(Color.White)
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        items.forEachIndexed { _, item ->

            var checkBoxState by remember {
                mutableStateOf(false) }
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Checkbox(checked = checkBoxState, onCheckedChange = { checkBoxState = it; item.checkBoxValue = it })
                Text(
                    text = " " + item.checkBoxName,
                    style = TextStyle(fontSize = 16.sp),
                    color = colorTextBlackLight,
                )
            }
            println("Label ${item.checkBoxName} : ${item.checkBoxValue}")
        }
    }
}