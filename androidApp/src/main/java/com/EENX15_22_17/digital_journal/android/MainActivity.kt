package com.EENX15_22_17.digital_journal.android


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.EENX15_22_17.digital_journal.android.ui.arrivalpage.ArrivalPage
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationApp()
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
fun HazardScreen(visitId: String) {
    Column() {
        Text(text = "This is the hazerd screen for visitId $visitId")
    }
}

@Composable
fun PatientMeetingLandingScreen(
    @PreviewParameter(OverviewScreenProvider::class) navToOverview: () -> Unit,
    navToArrival: () -> Unit,
    visitId: String = "0"
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(40.dp)
    ) {
        Text(text = "This is patient meeting with id: $visitId")
        Button(onClick = navToOverview) {
            Text("Click to get pack to current board")
        }
        Button(onClick = navToArrival) {
            Text("Go to arrival page for patient")
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