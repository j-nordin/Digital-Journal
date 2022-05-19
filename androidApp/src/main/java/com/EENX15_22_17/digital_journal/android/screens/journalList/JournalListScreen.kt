package com.EENX15_22_17.digital_journal.android.ui.current

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.EENX15_22_17.digital_journal.android.screens.journalList.JournalCreationDialog
import com.EENX15_22_17.digital_journal.android.screens.journalList.JournalListViewModel
import com.EENX15_22_17.digital_journal.android.screens.journalList.JournalList
import com.EENX15_22_17.digital_journal.android.ui.ScreenTitleText
import com.EENX15_22_17.digital_journal.android.ui.theme.TextStyles

@Composable
fun JournalListScreen(
    journalListViewModel: JournalListViewModel,
    onNavigateToJournal: (journalId: String) -> Unit = {},
    onNavigateToPatient: (patientId: String) -> Unit = {},
    switchScaffoldDrawerState: () -> Unit,
) {
    val journals by journalListViewModel.journals.collectAsState()

    var showCreatePatientModal by remember { mutableStateOf(false) }
    fun switchStateCreatePatientModal() {
        showCreatePatientModal = !showCreatePatientModal
    }

    if (showCreatePatientModal) {
        JournalCreationDialog(
            onDismiss = { switchStateCreatePatientModal() },
        )
    }

    Column {
        IconButton(
            modifier = Modifier.padding(15.dp),
            onClick = switchScaffoldDrawerState,
        ) {
            Icon(
                modifier = Modifier
                    .size(35.dp),
                imageVector = Icons.Default.Menu,
                contentDescription = "Menu Button",
            )
        }

        Column(
            modifier = Modifier
                .padding(horizontal = 80.dp),
            verticalArrangement = Arrangement.Top,
        ) {

            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text(
                    "AKTUELLA PATIENTER",
                    color = Color.Black,
                    style = TextStyles.pageTitle
                )
            }

            Spacer(Modifier.size(20.dp))

            JournalList(
                journals = journals,
                onNavigateToJournal = onNavigateToJournal,
                onNavigateToPatient = onNavigateToPatient
            )
            Spacer(modifier = Modifier.size(30.dp))

            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                Button(
                    onClick = ::switchStateCreatePatientModal
                ) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "Ny patient")
                    Spacer(Modifier.size(2.dp))
                    Text(text = "Ny Patient".uppercase())
                }
            }
        }
    }

}
