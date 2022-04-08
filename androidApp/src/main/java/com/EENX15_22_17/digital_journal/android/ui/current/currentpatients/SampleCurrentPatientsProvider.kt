package com.EENX15_22_17.digital_journal.android.ui.current.currentpatients

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class SampleCurrentPatientsProvider : PreviewParameterProvider<List<CurrentPatientsData>> {
    override val values = sequenceOf(
        listOf(
            CurrentPatientsData(
                id = "1",
                name = "Erik Karlsson",
                securityNumber = "1999-05-02-xxxx"
            ),
            CurrentPatientsData(
                id = "2",
                name = "Ebba Eriksson",
                securityNumber = "1990-01-02-xxxx"
            ),
            CurrentPatientsData(
                id = "3",
                name = "Felicia Adams",
                securityNumber = "1993-12-15-xxxx"
            )
        )
    )
}
