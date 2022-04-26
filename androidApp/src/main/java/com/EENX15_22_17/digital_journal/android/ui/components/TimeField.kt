package com.EENX15_22_17.digital_journal.android.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.LocalTime
import java.time.format.DateTimeFormatter

@Composable
fun TitledTimeField(
    modifier: Modifier = Modifier,
    title: String,
    value: LocalTime = LocalTime.now(),
    onChangedTime: (LocalTime) -> Unit
) {
    var currentlySelectedTime by rememberSaveable { mutableStateOf(value) }
    var showTimePickerModal by rememberSaveable { mutableStateOf(false) }

    fun switchStateTimePickerModal() {
        showTimePickerModal = !showTimePickerModal
    }

    OutlinedTextField(
        value = currentlySelectedTime.format(DateTimeFormatter.ofPattern(" HH : mm")),
        onValueChange = {},
        textStyle = TextStyle(fontSize = 17.sp),
        modifier = modifier
            .width(200.dp)
            .height(60.dp),
        label = {
            Text(
                text = title,
                fontSize = 20.sp
            )
        },
        maxLines = 1,
        trailingIcon =
        {
            Icon(
                imageVector = Icons.Filled.Schedule,
                contentDescription = "Time pick",
                modifier = Modifier.clickable { switchStateTimePickerModal() }
            )
        },
        readOnly = true,
    )

    if (showTimePickerModal) {
        TimePickerModal(
            onTimeSelected = { time -> currentlySelectedTime = time; onChangedTime(time) },
            onDismissRequest = ::switchStateTimePickerModal,
            timeValue = currentlySelectedTime
        )
    }


}