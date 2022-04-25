package com.EENX15_22_17.digital_journal.android.screens.current.currentpatients

import android.widget.Space
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.EENX15_22_17.digital_journal.android.ui.components.TitledTextField


@Composable
fun CreatePatientDialog(
    modifier: Modifier = Modifier,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
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
                        onChangeText = {},
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
                Row(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    DismissButton(onDismissClicked = onDismiss)
                    Spacer(modifier = Modifier.width(20.dp))
                    ConfirmButton(onConfirmClicked = onConfirm)
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
    Button(
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

