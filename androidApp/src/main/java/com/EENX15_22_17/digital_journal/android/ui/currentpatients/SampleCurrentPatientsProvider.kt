package com.EENX15_22_17.digital_journal.android.ui.currentpatients

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class SampleCurrentPatientsProvider : PreviewParameterProvider<CurrentPatientsData> {
    override val values = sequenceOf(
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
        )
    )
}
