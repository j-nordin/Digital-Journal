package com.EENX15_22_17.digital_journal.android.ui.current

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
    PatientsList(
        modifier = Modifier.padding(top = 100.dp),
        patients = journals.map { it.patientInfo },
        navigateSpecificPatient = navigateSpecificPatient,
        navigateSpecificOverviewPage = navigateSpecificOverviewPage
    )
}
