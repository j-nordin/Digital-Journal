package com.EENX15_22_17.digital_journal.android.ui.suicideassessment

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.EENX15_22_17.digital_journal.android.ui.components_beta.CheckBoxData
import com.EENX15_22_17.digital_journal.android.ui.components_beta.DrawCheckBoxes

@Composable
fun SuicideStepsItem(items : List<CheckBoxData>,
) {
    //TODO: Try to make division in a more dynamic way
    val itemsListOne : List<CheckBoxData> = items.subList(0, 4)
    val itemsListTwo : List<CheckBoxData> = items.subList(4, 7)
    Row (
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.Top,
        modifier = Modifier
            .background(Color.White)
            .fillMaxWidth()
    ) {
        
        Column(
            modifier = Modifier.fillMaxWidth(0.39f)
        ) {
            DrawCheckBoxes(items = itemsListOne, whichSection = "suicidesteps")
        }
        Column(
            modifier = Modifier.fillMaxWidth(0.65f)
        ) {
            DrawCheckBoxes(items = itemsListTwo, whichSection = "suicidesteps")
        }
    }
}
