package com.EENX15_22_17.digital_journal.android.ui.components


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.EENX15_22_17.digital_journal.android.ui.theme.primaryColor


@Composable
fun RadioButtonComponent(
    radioOptions: List<String>,
    setRadioValue: (a: String) -> Unit,
    radioStringValue: String
) {
    var radioText by remember { mutableStateOf(radioStringValue) }
    Column {
        Row {
            radioOptions.forEach { value ->
                Box(
                    Modifier
                        .clickable {
                            radioText = value
                            setRadioValue(value)
                        }
                        .padding(horizontal = 16.dp)
                        .background(primaryColor, CircleShape)
                ) {
                    RadioButton(
                        selected = (value == radioText),
                        modifier = Modifier.padding(all = Dp(value = 8F)),
                        onClick = {
                            radioText = value
                            setRadioValue(value)
                        }
                    )
                    Text(
                        text = value,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
            }
        }
    }
}


// TODO: Make one general RadioButtongroup
// TODO: setRadioValue now takes a String instead of boolean, this because i compare with textValue
@Composable
fun RadioButtonComponentBoolean(
    radioOptions: List<String>,
    setRadioValue: (a: String) -> Unit
) {
    val (selectedVal, setSelectedVal) = rememberSaveable { mutableStateOf(radioOptions[1])}
    Column {
        Row {
            radioOptions.forEach { value ->
                Box(
                    Modifier
                        .selectable(
                            selected = (selectedVal == value),
                            onClick = {
                                setSelectedVal(value)
                                setRadioValue(value)
                            }
                        )
                        .padding(horizontal = 16.dp)
                        .background(primaryColor, CircleShape)
                ) {
                    RadioButton(
                        selected = (selectedVal == value),
                        modifier = Modifier.padding(all = Dp(value = 8F)),
                        onClick = {
                            setSelectedVal(value)
                            setRadioValue(value)
                        }
                    )
                    Text(
                        text = value,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
            }
        }
    }
}



@Composable
fun YesRadio (state: Boolean) {
    var currentVal by remember { mutableStateOf(state) }
    RadioButton(
        selected = currentVal,
        onClick = { currentVal = true}
    )
}

@Composable
fun NoRadio (state: Boolean) {
    var currentVal by remember { mutableStateOf(state) }
    RadioButton(
        selected = currentVal,
        onClick = { currentVal = false}
    )
}