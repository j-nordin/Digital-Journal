package com.EENX15_22_17.digital_journal.android.ui.currentpatients

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp

class CurrentPatientsList {

    // Temporary data before backend is implemented
    private val defaultPatients: List<CurrentPatientsData> = listOf(
        CurrentPatientsData(
            patientId = "1",
            patientName = "Erik Karlsson",
            patientSecurityNumber = "1999-05-02-xxxx"
        ),
        CurrentPatientsData(
            patientId = "2",
            patientName = "Ebba Eriksson",
            patientSecurityNumber = "1990-01-02-xxxx"
        ),
        CurrentPatientsData(
            patientId = "3",
            patientName = "Felicia Adams",
            patientSecurityNumber = "1993-12-15-xxxx"
        ),
    )

    @Preview
    @Composable
    fun PatientsList(
        @PreviewParameter(SampleCurrentPatientsProvider::class)
        patients: List<CurrentPatientsData> = defaultPatients
    ) {
        val scrollState = rememberScrollState()
        Box(
            Modifier
                .height(400.dp)
                .padding(top = 100.dp)) {
            Column(
                Modifier.verticalScroll(scrollState)
            ) {
                for (patient in patients) {
                    CurrentPatientItem().PatientCard(
                        patientId = patient.patientId,
                        name = patient.patientName,
                        securityNumber = patient.patientSecurityNumber
                    )
                }
            }
        }

    }
}