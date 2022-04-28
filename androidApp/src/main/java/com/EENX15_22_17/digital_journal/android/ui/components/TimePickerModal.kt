package com.EENX15_22_17.digital_journal.android.ui.components

import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.window.Dialog
import android.widget.TimePicker
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import com.EENX15_22_17.digital_journal.android.ui.localDateTimeAtSystemTimeZone
import com.EENX15_22_17.digital_journal.android.ui.theme.colorTextFieldGray
import kotlinx.datetime.LocalDateTime
import java.util.*

@Composable
fun TimePickerModal(
    onTimeSelected: (LocalDateTime) -> Unit,
    onDismissRequest: () -> Unit,
    timeValue: LocalDateTime = LocalDateTime.localDateTimeAtSystemTimeZone()
) {
    var selTime by remember { mutableStateOf(timeValue) }

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
                        text = "${selTime.hour} : ${selTime.minute}",
                        style = MaterialTheme.typography.h4,
                        color = MaterialTheme.colors.onPrimary
                    )
                }

                Spacer(modifier = Modifier.size(20.dp))

                CustomTimePickerView(
                    onTimeChanged = { time -> selTime = time },
                    time = selTime
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
                            onTimeSelected(selTime)
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
    onTimeChanged: (LocalDateTime) -> Unit,
    time: LocalDateTime = LocalDateTime.localDateTimeAtSystemTimeZone()
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
                        LocalDateTime(
                            1,
                            1,
                            1,
                            hour,
                            minute
                        )
                    )
                }
            }
        )
    }
}