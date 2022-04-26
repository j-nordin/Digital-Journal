package com.EENX15_22_17.digital_journal.android.ui.components

import android.widget.CalendarView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.window.Dialog
import java.time.LocalDate
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*

/* This component will change to use the built in date picker with compose when it arrives.
* The ide may show some errors in this file, those are just telling us that our min API level
* is 21 when the 'LocalDate' requires API level 26
* */
@Composable
fun DatePickerModal(
    onDateSelected: (LocalDate) -> Unit,
    onDismissRequest: () -> Unit,
    dateValue: LocalDate = LocalDate.now()
) {
    val selDate = rememberSaveable { mutableStateOf(dateValue) }

    //TODO - Change this to use the date picker from compose when it arrives
    Dialog(onDismissRequest = onDismissRequest) {
        Column(
            modifier = Modifier
                .width(300.dp)
                .background(
                    color = MaterialTheme.colors.surface,
                    shape = RoundedCornerShape(size = 16.dp)
                )
        ) {
            Column(
                Modifier
                    .defaultMinSize(minHeight = 72.dp)
                    .fillMaxWidth()
                    .background(
                        color = MaterialTheme.colors.primary,
                        shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
                    )
                    .padding(16.dp)
            ) {
                Text(
                    text = "Välj datum".uppercase(Locale.ENGLISH),
                    style = MaterialTheme.typography.caption,
                    color = MaterialTheme.colors.onPrimary
                )

                Spacer(modifier = Modifier.size(24.dp))

                Text(
                    text = selDate.value.format(DateTimeFormatter.ofPattern("MMM d, y")),
                    style = MaterialTheme.typography.h4,
                    color = MaterialTheme.colors.onPrimary
                )

                Spacer(modifier = Modifier.size(16.dp))
            }

            CustomCalendarView(
                onDateChanged = { date -> selDate.value = date },
                date = selDate.value
            )

            Row(
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(bottom = 16.dp, end = 16.dp)
            ) {
                TextButton(
                    onClick = onDismissRequest
                ) {
                    Text(
                        text = "AVBRYT",
                        style = MaterialTheme.typography.button,
                    )
                }

                Spacer(modifier = Modifier.width(8.dp))

                Button(
                    onClick = {
                        onDateSelected(selDate.value)
                        onDismissRequest()
                    }
                ) {
                    Text(
                        text = "VÄLJ",
                        style = MaterialTheme.typography.button,
                    )
                }
            }
        }
    }
}

@Composable
fun CustomCalendarView(
    onDateChanged: (LocalDate) -> Unit,
    date: LocalDate = LocalDate.now()
) {
    AndroidView(
        modifier = Modifier.wrapContentSize(),
        factory = { CalendarView(it) },
        update = { view ->
            view.date = date
                .atStartOfDay(ZoneId.systemDefault())
                .toInstant()
                .toEpochMilli()
            view.setOnDateChangeListener { _, year, month, dayOfMonth ->
                onDateChanged(
                    LocalDate
                        .now()
                        .withMonth(month + 1)
                        .withYear(year)
                        .withDayOfMonth(dayOfMonth)
                )
            }
        },
    )
}