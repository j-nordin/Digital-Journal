package com.EENX15_22_17.digital_journal.android.ui.current

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.EENX15_22_17.digital_journal.android.screens.current.currentpatients.PatientsList

@Composable
fun CurrentScreen(
    navigateSpecificPatient: (visitId: String) -> Unit = {},
    navigateSpecificOverviewPage: (visitId: String) -> Unit = {},
) {
    Button(onClick = { /*TODO: Function to switch drawer state */ }) {
        Text("Menu")
    }
    PatientsList(
        modifier = Modifier.padding(top = 100.dp),
        navigateSpecificPatient = navigateSpecificPatient,
        navigateSpecificOverviewPage = navigateSpecificOverviewPage
    )
}
