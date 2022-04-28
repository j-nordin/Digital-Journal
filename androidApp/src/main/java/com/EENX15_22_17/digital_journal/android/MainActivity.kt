package com.EENX15_22_17.digital_journal.android

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.EENX15_22_17.digital_journal.android.ui.drawer.DigitalJournalScaffold
import com.EENX15_22_17.digital_journal.android.ui.theme.DigitalJournalTheme
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val appState = rememberAppState()
            appState.navController.addOnDestinationChangedListener { controller, destination, arguments ->
                Toast.makeText(this@MainActivity, "Navigating to \"${destination.route} (${destination.arguments.keys.joinToString(", ")})\"", Toast.LENGTH_SHORT).show()
            }
            DigitalJournalScaffold(
                scaffoldState = appState.scaffoldState,
                navToCurrPatients = { appState.navController.navToCurrPatients() }
            ) {
                DigitalJournalTheme {
                    /* TODO: Scaffold state should be accessed by the components by using DI instead*/
                    NavigationApp(
                        navController = appState.navController,
                        switchScaffoldDrawerState = {
                            val dr = appState.scaffoldState.drawerState
                            appState.coroutineScope.launch { if (dr.isOpen) dr.close() else dr.open() }
                        }
                    )
                }
            }
        }
    }
}


@Composable
fun PatientOverviewPage(
    patientId: String,
    navBack: () -> Unit
) {
    Text(text = "The overviewPage for patient: $patientId")
    Button(onClick = navBack) {
        Text(text = "Nav back")
    }
}