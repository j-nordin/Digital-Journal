package com.EENX15_22_17.digital_journal.android


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import com.EENX15_22_17.digital_journal.android.ui.arrivalpage.ArrivalPage
import com.EENX15_22_17.digital_journal.android.ui.triage.history.HealthHistoryPage


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //NavigationApp()
            HealthHistoryPage()
        }
    }
}

@Composable
fun ArrivalScreen(
    visitId: String,
    navBack: () -> Unit
) {
    ArrivalPage(
        visitId = visitId,
        navBack = navBack
    )
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