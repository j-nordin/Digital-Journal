package com.EENX15_22_17.digital_journal.android.ui.currentpatients

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

class CurrentPatientsList {

    // Temporary data before backend is implemented
    private val patients: List<CurrentPatientsData> = listOf(
        CurrentPatientsData(
            patientId = "1",
            patientName ="Erik Karlsson",
            patientSecurityNumber = "1999-05-02-xxxx"
        ),
        CurrentPatientsData(
            patientId = "2",
            patientName ="Ebba Eriksson",
            patientSecurityNumber = "1990-01-02-xxxx"
        ),
        CurrentPatientsData(
            patientId = "3",
            patientName ="Felicia Adams",
            patientSecurityNumber = "1993-12-15-xxxx"
        )
    )

    @Composable
    fun PatientsList() {
        Column {
            for (patient in patients) {
                CurrentPatientItem().PatientCard(
                    patientId= patient.patientId,
                    name = patient.patientName,
                    securityNumber = patient.patientSecurityNumber
                )
            }
        }
    }
}