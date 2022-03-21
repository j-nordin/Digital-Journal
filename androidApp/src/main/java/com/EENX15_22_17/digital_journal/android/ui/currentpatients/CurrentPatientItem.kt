package com.EENX15_22_17.digital_journal.android.ui.currentpatients


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Warning
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.EENX15_22_17.digital_journal.android.R

class CurrentPatientItem {

    @Composable
    fun PatientCard(
        name: String,
        securityNumber: String,
        navigateSelectedPatient: (patientId: String) -> Unit = {},
        showOverview: (patientId: Any) -> Unit = {},
        showComments: (patientId: Any) -> Unit = {},
        showWarning: (showWarning: Any) -> Unit = {}
    ) {
        Card(
            modifier = Modifier
                .padding(horizontal = 120.dp)
                .fillMaxWidth()
                .clickable { navigateSelectedPatient },
            backgroundColor = Color(R.color.colorPrimary)
        ) {
            Column {
                Row {
                    Text(
                        text = name,
                        Modifier
                            .padding(16.dp)
                    )
                    Text(
                        text = securityNumber,
                        Modifier
                            .padding(16.dp)
                    )

                    IconButton(onClick = { showOverview }) {
                        Icon(Icons.Rounded.Info, contentDescription = "Overview")
                    }

                    IconButton(
                        onClick = { showComments },
                    ) {
                        Icon(Icons.Rounded.Notifications, contentDescription = "Comments")
                    }
                    IconButton(onClick = { showWarning }) {
                        Icon(Icons.Rounded.Warning, contentDescription = "Warning")
                    }
                }
            }
        }
    }
}