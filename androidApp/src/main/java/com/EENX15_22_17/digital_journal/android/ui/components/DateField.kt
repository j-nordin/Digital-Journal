package com.EENX15_22_17.digital_journal.android.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.EditCalendar
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.EENX15_22_17.digital_journal.android.ui.localDateTimeAtSystemTimeZone
import kotlinx.datetime.LocalDateTime

@Composable
fun TitledDateField(
    modifier: Modifier = Modifier,
    title: String,
    onChangedDate: (date: LocalDateTime) -> Unit,
    value: LocalDateTime = LocalDateTime.localDateTimeAtSystemTimeZone(),
    isEnabled: Boolean = true
) {
    var currentlySelectedDate by remember { mutableStateOf(value) }
    var showDatePickerModal by rememberSaveable { mutableStateOf(false) }

    fun switchStateDatePickerModal() {
        showDatePickerModal = !showDatePickerModal
    }

    OutlinedTextField(
        value = currentlySelectedDate.toString(),
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
        enabled = isEnabled,
        trailingIcon =
        {
            Icon(
                imageVector = Icons.Filled.EditCalendar,
                contentDescription = "Calendar",
                modifier = Modifier.clickable { switchStateDatePickerModal() }
            )
        },
        readOnly = true,
    )

    if (showDatePickerModal) {
        DatePickerModal(
            onDateSelected = { date -> currentlySelectedDate = date; onChangedDate(date) },
            onDismissRequest = ::switchStateDatePickerModal,
            dateValue = currentlySelectedDate
        )
    }
}