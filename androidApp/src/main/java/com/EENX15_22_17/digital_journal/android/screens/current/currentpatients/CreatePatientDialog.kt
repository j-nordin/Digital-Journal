package com.EENX15_22_17.digital_journal.android.screens.current.currentpatients

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.EENX15_22_17.digital_journal.android.ui.components.TitledTextField
import com.EENX15_22_17.digital_journal.android.ui.components.TitledDateField
import com.EENX15_22_17.digital_journal.android.ui.components.TitledTextFieldDigitKeyboard
import com.EENX15_22_17.digital_journal.android.ui.components.TitledTimeField
import java.time.LocalDate
import java.time.LocalTime


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun CreatePatientDialog(
    modifier: Modifier = Modifier,
    onDismiss: () -> Unit,
) {
    /*TODO: move collected data to viewmodel*/
    val selectedDate = rememberSaveable { mutableStateOf(LocalDate.now())}
    val selectedTime = rememberSaveable { mutableStateOf(LocalTime.now())}
    val name = rememberSaveable { mutableStateOf("")}
    val socialSecurityNumber = rememberSaveable { mutableStateOf("")}

    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Card(
            modifier = modifier.fillMaxWidth(0.85f),
            elevation = 8.dp,
            shape = MaterialTheme.shapes.large
        ) {
            Column(
                modifier = modifier
                    .padding(vertical = 8.dp, horizontal = 20.dp),
            ) {
                Text(
                    modifier = Modifier.padding(vertical = 10.dp),
                    text = "Lägg till ny patient",
                    style = MaterialTheme.typography.h4
                )

                Row(
                    modifier = modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    TitledTextField(
                        modifier = Modifier.fillMaxWidth(0.5f),
                        title = "Namn",
                        onChangeText = { name.value = it },
                        textValue = ""
                    )
                    Spacer(modifier = modifier.width(20.dp))
                    TitledTextFieldDigitKeyboard(
                        modifier = modifier.fillMaxWidth(),
                        title = "Personnummer",
                        onChangeText = { socialSecurityNumber.value = it },
                        textValue = ""
                    )
                }

                Spacer(modifier = Modifier.size(20.dp))


                Row(modifier = modifier.fillMaxWidth()) {
                    TitledDateField(
                        modifier = modifier.fillMaxWidth(0.5f),
                        title = "Datum",
                        onChangedDate = {selectedDate.value = it},
                    )

                    Spacer(modifier = modifier.width(20.dp))

                    TitledTimeField(
                        modifier = modifier.fillMaxWidth(),
                        title = "Tid",
                        onChangedTime = { selectedTime.value = it }
                    )
                }

                Spacer(modifier = Modifier.size(15.dp))

                Row(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    DismissButton(onDismissClicked = onDismiss)
                    Spacer(modifier = Modifier.width(20.dp))
                    ConfirmButton(onConfirmClicked = {
                        /*TODO: Tell viewmodel to tell backend to create a new patient*/
                        onDismiss()
                    })
                }
            }
        }
    }
}


@Composable
private fun DismissButton(
    modifier: Modifier = Modifier,
    onDismissClicked: () -> Unit
) {
    TextButton(
        modifier = modifier,
        onClick = onDismissClicked
    ) {
        Text(text = "Avbryt")
    }
}

@Composable
private fun ConfirmButton(
    modifier: Modifier = Modifier,
    onConfirmClicked: () -> Unit
) {
    Button(
        modifier = modifier,
        onClick = onConfirmClicked
    ) {
        Text(text = "Skapa")
    }
}


