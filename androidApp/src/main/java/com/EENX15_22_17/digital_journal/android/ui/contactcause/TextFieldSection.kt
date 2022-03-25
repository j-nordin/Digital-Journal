package com.EENX15_22_17.digital_journal.android.ui.contactcause

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.EENX15_22_17.digital_journal.android.ui.theme.colorTextBlackLight
import com.EENX15_22_17.digital_journal.android.ui.theme.colorTextGray

@Composable
fun TextFieldSection(
    items : List<TextFieldContent>
) {
   Column (
       modifier = Modifier
           .background(Color.White)
           .fillMaxWidth()
           .padding(20.dp)
           ) {
       val textState = remember {
            mutableStateListOf(
                "",
                "",
                "",
                "",
                ""
            )
       }
       items.forEachIndexed { index, item ->
           TextFieldItem(
               item = item,
               index = index,
               textState = textState
           )
           println("Message index :"+ index+ " "+ textState[index])
       }
   }
}

@Composable
fun TextFieldItem(
    item : TextFieldContent,
    index : Int,
    textState : MutableList<String>
) {
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth().size(width = 200.dp, height = 130.dp),

        value = textState[index],
        textStyle = TextStyle(fontSize = 24.sp, color = Color.Black),
        onValueChange = { textState[index] = it },
        label = { Text(
            text = item.label,
            color = colorTextBlackLight,
            fontSize = 24.sp
        ) },
        placeholder = { Text(
            text = item.placeholder,
            color = colorTextGray,
            fontSize = 24.sp) },


    )
}