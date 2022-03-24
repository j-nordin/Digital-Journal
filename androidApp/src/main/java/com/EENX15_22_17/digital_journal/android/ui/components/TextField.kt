package com.EENX15_22_17.digital_journal.android.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun TitledTextField(
    placeHolderText: String,
    onChangeText: (textValue: String) -> Unit = {},
    title: String = ""
) {
    var text by remember { mutableStateOf("") }
    Box(modifier = Modifier.padding(16.dp)) {
        Text(
            text = title,
            fontSize = 14.sp,
            maxLines = 1,
            textDecoration = TextDecoration.Underline,
            modifier = Modifier.padding(10.dp)
        )
        OutlinedTextField(
            value = text,
            onValueChange = { text = it; onChangeText(it) },
            textStyle = TextStyle(fontSize = 25.sp),
            modifier = Modifier.padding(top = 10.dp),
            placeholder = {
                Text(
                    text = placeHolderText,
                    fontSize = 25.sp
                )
            }
        )
    }
}