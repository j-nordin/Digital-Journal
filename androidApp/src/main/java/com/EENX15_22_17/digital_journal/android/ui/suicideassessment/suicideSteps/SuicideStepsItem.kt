package com.EENX15_22_17.digital_journal.android.ui.suicideassessment

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.EENX15_22_17.digital_journal.android.ui.components_beta.getCheckBoxBtn
import com.EENX15_22_17.digital_journal.android.ui.components_beta.CheckBoxData
import com.EENX15_22_17.digital_journal.android.ui.theme.colorTextBlackLight

@Composable
fun SuicideStepsItem(items : List<CheckBoxData>,
) {
    val itemsListOne : List<CheckBoxData> = items.subList(0, 3)
    val itemsListTwo : List<CheckBoxData> = items.subList(4, 6)
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
            DrawCheckBoxes(items = itemsListOne)
        }
        Column(
            modifier = Modifier.fillMaxWidth(0.65f)
        ) {
            DrawCheckBoxes(items = itemsListTwo)
        }
    }
}
@Composable
fun DrawCheckBoxes(items: List<CheckBoxData> ) {
    items.forEachIndexed { index, item ->

        var checkBoxState by remember {
            mutableStateOf(false) }
        Column() {
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                getCheckBoxBtn(value = checkBoxState, onValueChange = { checkBoxState = it; item.checkBoxValue = it })
                Text(
                    text = " " + item.checkBoxName,
                    style = TextStyle(fontSize = 16.sp),
                    color = colorTextBlackLight,
                )
            }
            println("Label ${item.checkBoxName} : ${item.checkBoxValue}")
            Box(modifier = Modifier.size(width = 20.dp, height = 10.dp))
        }
        

    }
}