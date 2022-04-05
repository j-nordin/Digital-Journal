package com.EENX15_22_17.digital_journal.android.ui.components_beta

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.EENX15_22_17.digital_journal.android.ui.theme.colorTextBlackLight

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
                CheckBoxBtn(value = checkBoxState, onValueChange = { checkBoxState = it; item.checkBoxValue = it })
                Text(
                    text = " " + item.checkBoxName,
                    style = TextStyle(fontSize = 16.sp),
                    color = colorTextBlackLight,
                )
            }
            println("Label ${item.checkBoxName} : ${item.checkBoxValue}")
            Box(modifier = Modifier.size(width = 20.dp, height = 5.dp))
        }


    }
}