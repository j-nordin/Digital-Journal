package com.EENX15_22_17.digital_journal.android.ui.suicideassessment.summarysuicidesection

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.EENX15_22_17.digital_journal.android.ui.theme.colorTextBlackLight
import com.EENX15_22_17.digital_journal.android.ui.theme.summarySuicideCard

@Composable
fun SummarySection() {

    Column() {

        ShowSum(whichSection = "Suicidstegen", sum = 0) //TODO: Get the right value after implementing Suicide Assessment Modelview

        ShowSum(whichSection = "Statistiska riskfaktorer", sum = 0)

        ShowSum(whichSection = "Skyddande faktorer", sum = 0)

    }

}

@Composable
fun ShowSum(whichSection: String, sum: Int) {
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(8.dp)
    ) {
        Text(
            text = "$whichSection: ",
            style = TextStyle(fontSize = 16.sp),
            color = colorTextBlackLight,
        )
        Card(
            elevation = 2.dp,
            backgroundColor = summarySuicideCard,

            ) {
            Text(
                text = sum,
                style = TextStyle(fontSize = 16.sp),
                color = Color.White,
                modifier = Modifier.padding(8.dp)
            )
        }

    }
}