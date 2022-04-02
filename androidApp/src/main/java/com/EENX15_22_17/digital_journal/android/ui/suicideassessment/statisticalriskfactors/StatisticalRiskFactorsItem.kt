package com.EENX15_22_17.digital_journal.android.ui.suicideassessment.statisticalriskfactors

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.EENX15_22_17.digital_journal.android.ui.components_beta.CheckBoxData
import com.EENX15_22_17.digital_journal.android.ui.suicideassessment.DrawCheckBoxes

@Composable
fun StatisticalRiskFactorsItem(items : List<CheckBoxData>,
) {
    //TODO: Try to make division in a more dynamic way
    val itemsListOne : List<CheckBoxData> = items.subList(0, 5)
    val itemsListTwo : List<CheckBoxData> = items.subList(5, 10)
    Row (
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.Top,
        modifier = Modifier
            .background(Color.White)
            .fillMaxWidth()
    ) {

        Column(
            modifier = Modifier.fillMaxWidth(0.33f)
        ) {
            DrawCheckBoxes(items = itemsListOne)
        }
        Column(
            modifier = Modifier.fillMaxWidth(0.90f)
        ) {
            DrawCheckBoxes(items = itemsListTwo)
        }
    }
}