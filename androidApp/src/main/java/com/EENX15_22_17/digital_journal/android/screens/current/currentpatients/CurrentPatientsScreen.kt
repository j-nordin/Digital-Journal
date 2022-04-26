package com.EENX15_22_17.digital_journal.android.ui.current

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.EENX15_22_17.digital_journal.android.screens.current.currentpatients.CreatePatientDialog
import com.EENX15_22_17.digital_journal.android.screens.current.currentpatients.PatientListViewModel
import com.EENX15_22_17.digital_journal.android.screens.current.currentpatients.PatientsList

@Composable
fun CurrentScreen(
    patientListViewModel: PatientListViewModel,
    navigateSpecificPatient: (visitId: String) -> Unit = {},
    navigateSpecificOverviewPage: (visitId: String) -> Unit = {},
    switchScaffoldDrawerState: () -> Unit,
) {
    val journals by patientListViewModel.journals.collectAsState()

    var showCreatePatientModal by remember { mutableStateOf(false) }
    fun switchStateCreatePatientModal() {showCreatePatientModal = !showCreatePatientModal}

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
        modifier = Modifier.padding(vertical = 100.dp, horizontal = 80.dp),
        horizontalAlignment = Alignment.End
    ) {
        PatientsList(
            patients = journals.map { it.patientInfo },navigateSpecificPatient = navigateSpecificPatient,
            navigateSpecificOverviewPage = navigateSpecificOverviewPage
        )
        Spacer(modifier = Modifier.size(30.dp))
        Button(
            onClick = ::switchStateCreatePatientModal
        ) {
            Text(text = "Ny Patient")
        }
    }



    if (showCreatePatientModal) {
        CreatePatientDialog(
            onDismiss = {switchStateCreatePatientModal()},
        )
    }
}
