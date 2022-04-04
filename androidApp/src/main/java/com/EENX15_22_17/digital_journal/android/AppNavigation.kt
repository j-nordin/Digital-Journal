package com.EENX15_22_17.digital_journal.android

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.EENX15_22_17.digital_journal.android.ui.current.CurrentScreen

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
            ArrivalScreen(visitId)
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
        /*TODO. Rename this so this not is the overview, should be startPage; Ask Jonas*/

        CurrentScreen(
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