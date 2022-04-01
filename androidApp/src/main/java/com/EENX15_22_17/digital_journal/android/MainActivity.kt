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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.*
import com.EENX15_22_17.digital_journal.android.ui.arrivalpage.ArrivalPage
import com.EENX15_22_17.digital_journal.android.ui.currentpatients.PatientsList

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationApp()
        }
    }
}

sealed class Screen(val route: String) {
    object Overview : Screen(route = "overview")
    object PatientMeeting : Screen(route = "patientMeeting")
    object PatientOverview : Screen(route = "patientOverview/{visitId}") {
        fun createRoute(visitId: String) = "patientOverview/$visitId"
    }
}

sealed class PatientMeetingScreens(val route: String) {
    //For creating routes to composables
    fun createRoute(root: Screen) = "${root.route}/$route"

    object MainScreen : PatientMeetingScreens("{visitId}") {
        // Overloads and creates a route with a specific id
        fun createRoute(visitId: String, root: Screen) = "${root.route}/$visitId"
    }

    object Arrival : PatientMeetingScreens("{visitId}/arrival") {
        fun createRoute(visitId: String, root: Screen) = "${root.route}/$visitId/arrival"
    }

    // TODO: Implement routes to rest of the cards
    object HazardAssessment : PatientMeetingScreens("{visitId}/hazardAssessment")
}

@Composable
fun NavigationApp() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.Overview.route
    ) {
        addCurrentBoardGraph(navController = navController)
        addPatientMeetingGraph(navController = navController)
    }
}

private fun NavGraphBuilder.addPatientMeetingGraph(
    navController: NavController,
) {
    navigation(
        route = Screen.PatientMeeting.route,
        startDestination = PatientMeetingScreens.MainScreen.route
    ) {
        composable(
            route = PatientMeetingScreens.MainScreen.createRoute(root = Screen.PatientMeeting)
        ) { backStackEntry ->
            val visitId = backStackEntry.arguments?.getString("visitId")

            /*TODO: Handle meeting id not provided, ex show alert*/
            requireNotNull(visitId) { "No meeting id provided" }

            /*TODO: replace with real patient meeting screen*/
            PatientMeetingLandingScreen(
                navToOverview = { navController.navigate(Screen.Overview.route) },
                navToArrival = {
                    navController.navigate(
                        PatientMeetingScreens.Arrival.createRoute(
                            visitId = visitId,
                            root = Screen.PatientMeeting
                        )
                    )
                },
                visitId = visitId
            )
        }
        composable(
            route = PatientMeetingScreens.Arrival.createRoute(root = Screen.PatientMeeting)
        ) { backStackEntry ->
            val visitId = backStackEntry.arguments?.getString("visitId")
            requireNotNull(visitId) { "No patient id provided" }
            ArrivalScreen(
                visitId,
                navBack = { navController.popBackStack() }
            )
        }
    }
}

private fun NavGraphBuilder.addCurrentBoardGraph(
    navController: NavController
) {
    /*TODO: Replace with real overview page */
    composable(route = Screen.PatientOverview.route) { backStackEntry ->
        val visitId = backStackEntry.arguments?.getString("visitId")
        requireNotNull(visitId) { "No patient id provided" }
        PatientOverviewPage(
            visitId = visitId,
            navBack = { navController.popBackStack() }
        )
    }
    composable(route = Screen.Overview.route) {
        /*TODO: replace with real overview screen*/

        PatientsList(
            navigateSpecificPatient = { id ->
                navController.navigate(
                    PatientMeetingScreens.MainScreen.createRoute(
                        visitId = id,
                        root = Screen.PatientMeeting
                    )
                )
            },
            navigateSpecificOverviewPage = { id ->
                println(id)
                navController.navigate(
                    Screen.PatientOverview.createRoute(
                        visitId = id
                    )
                )
            }
        )
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