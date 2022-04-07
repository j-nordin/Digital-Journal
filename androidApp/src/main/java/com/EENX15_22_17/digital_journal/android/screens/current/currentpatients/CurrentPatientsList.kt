package com.EENX15_22_17.digital_journal.android.screens.current.currentpatients

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp

// Temporary data before backend is implemented
//TODO: Fetch data from API instead of using sampledata from the preview-provider
private val defaultPatients: List<CurrentPatientsData> =
    SampleCurrentPatientsProvider().values.toList()[0]

@Preview
@Composable
fun PatientsList(
    modifier: Modifier = Modifier,
    @PreviewParameter(SampleCurrentPatientsProvider::class)
    patients: List<CurrentPatientsData> = defaultPatients,
    navigateSpecificPatient: (visitId: String) -> Unit = {},
    navigateSpecificOverviewPage: (visitId: String) -> Unit = {}
) {
    val scrollState = rememberScrollState()
    Box(
        modifier
            .height(400.dp)
    ) {
        Column(
            Modifier.verticalScroll(scrollState)
        ) {
            for (patient in patients) {
                PatientCard(
                    visitId = patient.id,
                    name = patient.name,
                    securityNumber = patient.securityNumber,
                    showOverview = { navigateSpecificOverviewPage(it) },
                    navigateSelectedPatient = { navigateSpecificPatient(it) }
                )
            }
        }
    }
}
