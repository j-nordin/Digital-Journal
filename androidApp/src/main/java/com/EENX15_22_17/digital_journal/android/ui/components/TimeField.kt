package com.EENX15_22_17.digital_journal.android.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.EENX15_22_17.digital_journal.android.ui.localDateTimeAtSystemTimeZone
import kotlinx.datetime.LocalDateTime


@Composable
fun TitledTimeField(
    modifier: Modifier = Modifier,
    title: String,
    value: LocalDateTime = LocalDateTime.localDateTimeAtSystemTimeZone(),
    onChangedTime: (LocalDateTime) -> Unit
) {
    var currentlySelectedTime by remember { mutableStateOf(value) }
    var showTimePickerModal by rememberSaveable { mutableStateOf(false) }

    fun switchStateTimePickerModal() {
        showTimePickerModal = !showTimePickerModal
    }

    OutlinedTextField(
        value = "${if (currentlySelectedTime.minute < 10) "0" else ""}${currentlySelectedTime.hour} : ${if (currentlySelectedTime.minute < 10) "0" else ""}${currentlySelectedTime.minute}",
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