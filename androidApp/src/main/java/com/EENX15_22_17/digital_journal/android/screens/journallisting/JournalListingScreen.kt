package com.EENX15_22_17.digital_journal.android.screens.journallisting

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.NoteAdd
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.EENX15_22_17.digital_journal.android.ui.components.TitledTextField
import com.EENX15_22_17.digital_journal.android.ui.ifMobile
import com.EENX15_22_17.digital_journal.android.ui.theme.primary
import se.predicare.journal.data.JournalEntryDto
import se.predicare.journal.screens.PatientInformationDto

@Composable
fun JournalListingScreen(
    journalListingViewModel: JournalListingViewModel,
    navigateSpecificPatient: (visitId: String) -> Unit = {},
    navigateSpecificOverviewPage: (visitId: String) -> Unit = {},
    switchScaffoldDrawerState: () -> Unit,
) {
    val journals by journalListingViewModel.journals.collectAsState()

    var showAddNewDialog by rememberSaveable {
        mutableStateOf(false)
    }

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
            .fillMaxHeight()
            .padding(100.dp ifMobile 16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.End
    ) {
        JournalEntryList(
            journals = journals,
            navigateSpecificPatient = navigateSpecificPatient,
            navigateSpecificOverviewPage = navigateSpecificOverviewPage
        )

        if (showAddNewDialog) {
            var patientId by remember { mutableStateOf("") }
            var personalId by remember { mutableStateOf("") }
            var name by remember { mutableStateOf("") }
            Dialog(onDismissRequest = { showAddNewDialog = false }) {
                Card {
                    Column(Modifier.padding(16.dp)) {
                        TitledTextField(
                            title = "Patient System ID",
                            onChangeText = { patientId = it },
                            textValue = patientId
                        )
                        TitledTextField(
                            title = "Patient Personal ID",
                            onChangeText = { personalId = it },
                            textValue = personalId
                        )
                        TitledTextField(
                            title = "Name",
                            onChangeText = { name = it },
                            textValue = name
                        )


                        Button(onClick = {
                            val newJournal = JournalEntryDto().apply {
                                patientInfo.patientData = PatientInformationDto.Patient(
                                    patientId,
                                    personalId,
                                    name
                                )
                            }
                            journalListingViewModel.createNew(newJournal)
                            showAddNewDialog = false
                        }) {
                            Text("Add")
                        }
                    }
                }
            }
        }

        ExtendedFloatingActionButton(
            backgroundColor = primary,
            icon = { Icon(imageVector = Icons.Default.NoteAdd, "Add new journal")},
            text = { Text("New") },
            onClick = {
                showAddNewDialog = true
            }
        )
    }
}
