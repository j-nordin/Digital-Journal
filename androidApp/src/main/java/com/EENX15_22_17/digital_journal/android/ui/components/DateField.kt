package com.EENX15_22_17.digital_journal.android.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.EditCalendar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.LocalDate

@Composable
fun TitledDateField(
    modifier: Modifier = Modifier,
    title: String,
    onChangedDate: (date: LocalDate) -> Unit,
    value: LocalDate = LocalDate.now(),
    isEnabled: Boolean = true
) {
    var currentlySelectedDate by rememberSaveable { mutableStateOf(value) }
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