package com.EENX15_22_17.digital_journal.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModelProvider
import com.EENX15_22_17.digital_journal.android.screens.arrival.patientinfo.ArrivalViewModel
import com.EENX15_22_17.digital_journal.android.ui.theme.DigitalJournalTheme


class MainActivity : ComponentActivity() {
    private lateinit var arrivalViewModel: ArrivalViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arrivalViewModel = ViewModelProvider(this)[ArrivalViewModel::class.java]
        setContent {
            DigitalJournalTheme {
                NavigationApp(arrivalViewModel = arrivalViewModel)
            }
        }
    }
}

@Composable
fun PatientOverviewPage(
    visitId: String,
    navBack: () -> Unit
) {
    Text(text = "The overviewPage for patient: $visitId")
    Button(onClick = navBack) {
        Text(text = "Nav back")
    }
}
