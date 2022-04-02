package com.EENX15_22_17.digital_journal.android.ui.contactcause

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.EENX15_22_17.digital_journal.android.ui.theme.colorTextBlackLight
import com.EENX15_22_17.digital_journal.android.ui.theme.colorTextGray

@Composable
fun TextFieldSection(
    items : List<TextFieldContent>,
) {
   Column (
       modifier = Modifier
           .background(Color.White)
           .fillMaxWidth()
           .padding(20.dp)
           ) {
       items.forEachIndexed { index, item ->

           var textState by remember {
               mutableStateOf("") }

           OutlinedTextField(
               modifier = Modifier
                   .fillMaxWidth()
                   .size(width = 200.dp, height = 130.dp),
               value = textState,
               onValueChange = { textState = it; item.value = it },
               label = { Text(
                   text = item.label,
                   color = colorTextBlackLight,
                   style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Black),
               ) },
               placeholder = { Text(
                   text = item.placeholder,
                   color = colorTextGray,
                   fontSize = 24.sp) },
               textStyle = TextStyle(fontSize = 22.sp)
           )
           Box(modifier = Modifier
               .size(width = 20.dp, height = 20.dp))
           println("Label ${item.label} : ${item.value}")
       }
   }
}

