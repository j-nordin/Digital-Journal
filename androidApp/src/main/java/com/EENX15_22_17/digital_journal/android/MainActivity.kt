package com.EENX15_22_17.digital_journal.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.material.Button
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import com.EENX15_22_17.digital_journal.android.ui.drawer.DigitalJournalScaffold
import com.EENX15_22_17.digital_journal.android.ui.theme.DigitalJournalTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val appState = rememberAppState()
            DigitalJournalScaffold(
                scaffoldState = appState.scaffoldState,
                navToCurrPatients = { appState.navController.navToCurrPatients() }
            ) {
                DigitalJournalTheme {
                    /* TODO: Scaffold state should be accessed by the components by using DI instead*/
                    NavigationApp(
                        navController = appState.navController,
                        switchScaffoldDrawerState = {
                            switchScaffoldDrawerState(
                                scaffoldState = appState.scaffoldState,
                                coroutineScope = appState.coroutineScope
                            )
                        }
                    )
                }
            }
        }
    }
}

fun switchScaffoldDrawerState(
    scaffoldState: ScaffoldState,
    coroutineScope: CoroutineScope
) {
    val dr = scaffoldState.drawerState
    coroutineScope.launch {
        if (dr.isOpen) dr.close() else dr.open()
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