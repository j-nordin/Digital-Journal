package com.EENX15_22_17.digital_journal.android.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun TitledTextField(
    title: String,
    onChangeText: (textValue: String) -> Unit,
    textValue: String,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true,
    maxLines : Int = 1
) {
    var text by rememberSaveable { mutableStateOf(textValue) }
    Box {
        OutlinedTextField(
            value = text,
            onValueChange = { text = it; onChangeText(it) },
            textStyle = TextStyle(fontSize = 20.sp),
            modifier = modifier
                .width(200.dp)
                .height(60.dp),
            label = {
                Text(
                    text = title,
                    fontSize = 20.sp
                )
            },
            maxLines = maxLines,
            enabled = isEnabled
        )
    }
}

@Composable
fun TitledTextFieldDigitKeyboard(
    modifier: Modifier = Modifier,
    title: String,
    onChangeText: (textValue: String) -> Unit = {},
    textValue: String
) {
    var text by rememberSaveable { mutableStateOf(textValue) }
    Box {
        OutlinedTextField(
            value = text,
            onValueChange = { text = it; onChangeText(it) },
            textStyle = TextStyle(fontSize = 20.sp),
            modifier = modifier
                .width(160.dp)
                .height(60.dp),
            label = {
                Text(
                    text = title,
                    fontSize = 20.sp
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