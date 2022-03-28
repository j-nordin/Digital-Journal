package com.EENX15_22_17.digital_journal.android.ui.currentpatients


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Warning
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.EENX15_22_17.digital_journal.android.ui.theme.colorIcon
import com.EENX15_22_17.digital_journal.android.ui.theme.danger
import com.EENX15_22_17.digital_journal.android.ui.theme.primaryColor

@Composable
// TODO: Replace default parameter-values with PreviewParameter-annotations when tooling is less buggy.
fun PatientCard(
    patientId: String = "1",
    name: String = "PatientName",
    securityNumber: String = "00000000",
    navigateSelectedPatient: (patientId: String) -> Unit = {},
    showOverview: (patientId: String) -> Unit = {}
) {
    var showWarning by remember { mutableStateOf(false) }
    var showComments by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier
            .padding(horizontal = 120.dp, vertical = 2.dp)
            .fillMaxWidth()
            .clickable { navigateSelectedPatient(patientId) },
        backgroundColor = primaryColor
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
                    Icon(
                        imageVector = Icons.Rounded.Info,
                        contentDescription = "Overview",
                        tint = colorIcon
                    )
                }

                IconButton(
                    onClick = { showComments = true }) {
                    Icon(
                        imageVector = Icons.Rounded.Notifications,
                        contentDescription = "Comments",
                        tint = colorIcon
                    )
                }
                IconButton(onClick = { showWarning = true }) {
                    Icon(
                        imageVector = Icons.Rounded.Warning,
                        contentDescription = "Warnings",
                        tint = danger
                    )
                }
                if (showWarning) {
                    Dialog(onDismissRequest = { showWarning = false }) {
                        WarningContent(patientId = patientId)
                    }
                } else if (showComments) {
                    Dialog(onDismissRequest = { showComments = false }) {
                        CommentsContent(patientId = patientId)
                    }
                }
            }
        }
    }

}

@Composable
fun WarningContent(patientId: String) {
    Surface(
        modifier = Modifier
            .width(300.dp)
            .height(420.dp)
            .padding(16.dp)
    ) {
        Column {
            Text(
                text = "This is a warning. The id is displayed below",
                fontSize = 20.sp
            )
            Text(
                text = patientId,
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontSize = 40.sp
            )
        }
    }
}

@Composable
fun CommentsContent(patientId: String) {
    Surface(
        modifier = Modifier
            .width(300.dp)
            .height(420.dp)
            .padding(16.dp)
    ) {
        Column {
            Text(
                text = "This is a comment. The id is displayed below",
                fontSize = 30.sp
            )
            Text(
                text = patientId,
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontSize = 40.sp
            )
        }
    }
}