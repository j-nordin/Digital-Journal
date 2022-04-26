package com.EENX15_22_17.digital_journal.android.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.window.Dialog
import java.time.LocalTime
import android.widget.TimePicker
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import com.EENX15_22_17.digital_journal.android.ui.theme.colorTextFieldGray
import java.time.format.DateTimeFormatter
import java.util.*

@Composable
fun TimePickerModal(
    onTimeSelected: (LocalTime) -> Unit,
    onDismissRequest: () -> Unit,
    timeValue: LocalTime = LocalTime.now()
) {
    val selTime = rememberSaveable { mutableStateOf(timeValue) }

    Dialog(
        onDismissRequest = onDismissRequest
    ) {
        Box(
            modifier = Modifier
                .width(230.dp)
                .background(
                    color = MaterialTheme.colors.surface,
                    shape = RoundedCornerShape(size = 16.dp)
                )
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
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
                        text = "Välj tid".uppercase(Locale.ENGLISH),
                        style = MaterialTheme.typography.caption,
                        color = MaterialTheme.colors.onPrimary
                    )

                    Spacer(modifier = Modifier.size(15.dp))

                    Text(
                        text = selTime.value.format(DateTimeFormatter.ofPattern("HH:mm")),
                        style = MaterialTheme.typography.h4,
                        color = MaterialTheme.colors.onPrimary
                    )
                }

                Spacer(modifier = Modifier.size(20.dp))

                CustomTimePickerView(
                    onTimeChanged = { time -> selTime.value = time },
                    time = selTime.value
                )

                Spacer(modifier = Modifier.size(20.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.End)
                        .padding(bottom = 16.dp, end = 16.dp),
                    horizontalArrangement = Arrangement.End
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
                            onTimeSelected(selTime.value)
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
}


@Composable
fun CustomTimePickerView(
    onTimeChanged: (LocalTime) -> Unit,
    time: LocalTime = LocalTime.now()
) {
    Card(
        border = BorderStroke(2.dp, colorTextFieldGray)
    ) {
        AndroidView(
            modifier = Modifier
                .wrapContentSize()
                .padding(10.dp),
            factory = { TimePicker(it, null, 1) },
            update = { view ->
                view.setIs24HourView(true)
                view.hour = time.hour
                view.minute = time.minute
                view.setOnTimeChangedListener { _, hour, minute ->
                    onTimeChanged(
                        LocalTime.now().withHour(hour).withMinute(minute)
                    )
                }
            }
        )
    }
}