package com.EENX15_22_17.digital_journal.android.ui.currentpatients


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Warning
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.Popup
import com.EENX15_22_17.digital_journal.android.R

class CurrentPatientItem {

    //@Preview(showBackground = true)
    @Composable
    fun PatientCard(
        patientId: String = "1",
        name: String = "PatientName",
        securityNumber: String = "00000000",
        navigateSelectedPatient: (patientId: String) -> Unit = {},
        showOverview: (patientId: String) -> Unit = {},
        showComments: (patientId: String) -> Unit = {},
        showWarning: (showWarning: String) -> Unit = {}
    ) {
        var showWarning by remember { mutableStateOf(false) }
        Card(
            modifier = Modifier
                .padding(horizontal = 120.dp)
                .fillMaxWidth()
                .clickable { navigateSelectedPatient(patientId) },
            backgroundColor = Color(R.color.colorPrimary)
        ) {
            Row(horizontalArrangement = Arrangement.SpaceBetween) {
                Text(
                    text = name,
                    modifier = Modifier.padding(16.dp),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = securityNumber,
                    modifier = Modifier.padding(16.dp),
                    fontSize = 20.sp
                )
                Row(horizontalArrangement = Arrangement.End) {
                    IconButton(onClick = { showOverview(patientId) }) {
                        Icon(Icons.Rounded.Info, contentDescription = "Overview")
                    }

                    IconButton(
                        onClick = { showComments(patientId) }) {
                        Icon(Icons.Rounded.Notifications, contentDescription = "Comments")
                    }
                    IconButton(onClick = { showWarning = true }) {
                        Icon(Icons.Rounded.Warning, contentDescription = "Warning")
                    }
                    if (showWarning) {
                        Dialog(onDismissRequest = { showWarning = false }) {
                            Surface(
                                modifier = Modifier
                                    .width(300.dp)
                                    .height(420.dp)
                                    .padding(16.dp)
                            ) {
                                Column {
                                    Text(text = "This is a warning. The id is displayed")
                                    Text(
                                        text = patientId,
                                        modifier = Modifier
                                            .fillMaxHeight()
                                            .fillMaxWidth()
                                    )
                                }
                            }
                        }
                    }
                }


            }
        }

    }
}