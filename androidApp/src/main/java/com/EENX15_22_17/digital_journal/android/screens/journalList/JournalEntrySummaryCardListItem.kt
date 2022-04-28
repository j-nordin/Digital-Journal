package com.EENX15_22_17.digital_journal.android.screens.journalList


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Warning
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.EENX15_22_17.digital_journal.android.ui.theme.colorIcon
import com.EENX15_22_17.digital_journal.android.ui.theme.danger
import se.predicare.journal.data.JournalEntryDto

@Composable
// TODO: Replace default parameter-values with PreviewParameter-annotations when tooling is less buggy.
fun JournalEntrySummaryCardListItem(
    journalId: String = "1",
    name: String = "PatientName",
    securityNumber: String = "00000000",
    onNavigateToJournal: (journalId: String) -> Unit = {},
    onNavigateToPatient: (patientId: String) -> Unit = {}
) {
    //TODO: use navigation to show these
    var showWarning by remember { mutableStateOf(false) }
    var showComments by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier
            .padding(horizontal = 120.dp, vertical = 2.dp)
            .fillMaxWidth()
            .clickable { onNavigateToJournal(journalId) },
        backgroundColor = MaterialTheme.colors.primary
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
                // TODO: Navigate using patient id
                IconButton(onClick = { onNavigateToPatient("<patientId goes here>") }) {
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
                        WarningContent(journalId = journalId)
                    }
                } else if (showComments) {
                    Dialog(onDismissRequest = { showComments = false }) {
                        CommentsContent(journalId = journalId)
                    }
                }
            }
        }
    }
}

//TODO: Replace with the real warningContent
@Composable
fun WarningContent(journalId: String) {
    //TODO: Get font sizes (and other theme-related stuff) from the theme
    Surface(
        modifier = Modifier
            .width(300.dp)
            .height(420.dp)
            .padding(16.dp)
    ) {
        Column {
            Text(
                text = "This is a warning. The id is displayed below",
                style = MaterialTheme.typography.h6
            )
            Text(
                text = journalId,
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h4
            )
        }
    }
}

//TODO: Replace with the real commentContent
@Composable
fun CommentsContent(journalId: String) {
    Surface(
        modifier = Modifier
            .width(300.dp)
            .height(420.dp)
            .padding(16.dp)
    ) {
        Column {
            Text(
                text = "This is a comment. The id is displayed below",
                style = MaterialTheme.typography.h6
            )
            Text(
                text = journalId,
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h4
            )
        }
    }
}


@Preview
@Composable
fun JournalList(
    modifier: Modifier = Modifier,
    @PreviewParameter(SampleCurrentPatientsProvider::class)
    journals: List<JournalEntryDto>,
    onNavigateToJournal: (journalId: String) -> Unit = {},
    onNavigateToPatient: (patientId: String) -> Unit = {}
) {
    val scrollState = rememberScrollState()
    Box(
        modifier
            .height(400.dp)
    ) {
        Column(
            Modifier.verticalScroll(scrollState)
        ) {
            for (journal in journals) {
                JournalEntrySummaryCardListItem(
                    journalId = journal._id ?: "",
                    name = journal.patientInfo.patientData?.name ?: "",
                    securityNumber = journal.patientInfo.patientData?.personalId ?: "",
                    // TODO: Navigate using real patientID
                    onNavigateToPatient = { onNavigateToPatient("<patientId goes here>") },
                    onNavigateToJournal = { onNavigateToJournal(it) }
                )
            }
        }
    }
}
