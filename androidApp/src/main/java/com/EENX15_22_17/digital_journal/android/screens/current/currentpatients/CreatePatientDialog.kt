package com.EENX15_22_17.digital_journal.android.screens.current.currentpatients

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.EENX15_22_17.digital_journal.android.ui.components.TitledTextField
import com.EENX15_22_17.digital_journal.android.ui.components.TitledDateField
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*


@Composable
fun CreatePatientDialog(
    modifier: Modifier = Modifier,
    onDismiss: () -> Unit,
    onCreateClicked: () -> Unit
) {
    /*TODO: move to viewmodel*/
    var selectedDate = rememberSaveable { mutableStateOf("")}
    val name = rememberSaveable { mutableStateOf("")}

    Dialog(
        onDismissRequest = onDismiss,
    ) {
        Card(
            modifier = modifier,
            elevation = 8.dp,
            shape = MaterialTheme.shapes.large
        ) {
            Column(
                modifier = modifier.padding(vertical = 8.dp, horizontal = 20.dp),
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
                    TitledTextField(
                        modifier = modifier.fillMaxWidth(),
                        title = "Personnummer",
                        onChangeText = {},
                        textValue = ""
                    )
                }

                Spacer(modifier = Modifier.size(20.dp))

                TitledDateField(
                    modifier = modifier.fillMaxWidth(0.5f),
                    title = "Datum",
                    onChangeDate = {selectedDate.value = it; println(it)},
                    value = LocalDate.now().format(DateTimeFormatter.ofPattern("y-MM-dd")),
                )

                Row(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    DismissButton(onDismissClicked = onDismiss)
                    Spacer(modifier = Modifier.width(20.dp))
                    ConfirmButton(onConfirmClicked = onCreateClicked)
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


