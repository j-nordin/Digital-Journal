package com.EENX15_22_17.digital_journal.android.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun TitledTextField(
    title: String,
    onChangeText: (textValue: String) -> Unit,
    textValue: String,
    modifier: Modifier = Modifier
) {
    var text by rememberSaveable { mutableStateOf(textValue) }
    Box {
        OutlinedTextField(
            value = text,
            onValueChange = { text = it; onChangeText(it) },
            textStyle = TextStyle(fontSize = 25.sp),
            modifier = modifier
                .padding(top = 10.dp)
                .width(200.dp),
            label = {
                Text(
                    text = title,
                    fontSize = 25.sp
                )
            },
            maxLines = 1
        )
    }
}

@Composable
fun TitledTextFieldDigitKeyboard(
    title: String,
    onChangeText: (textValue: String) -> Unit = {},
    textValue: String
) {
    var text by rememberSaveable { mutableStateOf(textValue)}
    Box {
        OutlinedTextField(
            value = text,
            onValueChange = { text = it; onChangeText(it) },
            textStyle = TextStyle(fontSize = 25.sp),
            modifier = Modifier
                .padding(top = 10.dp)
                .width(160.dp),
            label = {
                Text(
                    text = title,
                    fontSize = 25.sp
                )
            },
            maxLines = 1,
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
        )
    }
}

@Composable
fun ReadonlyTextField(
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    label: @Composable () -> Unit
) {
    Box {
        TextField(
            value = value,
            onValueChange = onValueChange,
            modifier = modifier,
            label = label
        )
        Box(
            modifier = Modifier
                .matchParentSize()
                .alpha(0f)
                .clickable(onClick = onClick),
        )
    }
}