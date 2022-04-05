package com.EENX15_22_17.digital_journal.android

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.EENX15_22_17.digital_journal.android.ui.current.CurrentScreen
import com.EENX15_22_17.digital_journal.android.ui.arrivalpage.ArrivalPage

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
    object HazardAssessment : PatientMeetingScreens("{visitId}/hazardAssessment") {
        fun createRoute(visitId: String, root: Screen) = "${root.route}/$visitId/hazardAssessment"
    }

    object ContactReason : PatientMeetingScreens("{visitId}/contactReason") {
        fun createRoute(visitId: String, root: Screen) = "${root.route}/$visitId/contactReason"
    }

    object PreviousCare : PatientMeetingScreens("{visitId}/previousCare") {
        fun createRoute(visitId: String, root: Screen) = "${root.route}/$visitId/previousCare"
    }

    object HealthHistory : PatientMeetingScreens("{visitId}/healthHistory") {
        fun createRoute(visitId: String, root: Screen) = "${root.route}/$visitId/healthHistory"
    }

    object HealthNow : PatientMeetingScreens("{visitId}/healthNow") {
        fun createRoute(visitId: String, root: Screen) = "${root.route}/$visitId/healthNow"
    }
    object SuicideAssessment : PatientMeetingScreens("{visitId}/suicideAssessment") {
        fun createRoute(visitId: String, root: Screen) = "${root.route}/$visitId/suicideAssessment"
    }
    object NursingNeed : PatientMeetingScreens("{visitId}/nursingNeed") {
        fun createRoute(visitId: String, root: Screen) = "${root.route}/$visitId/nursingNeed"
    }
    object MedicalOrder : PatientMeetingScreens("{visitId}/medicalOrder") {
        fun createRoute(visitId: String, root: Screen) = "${root.route}/$visitId/medicalOrder"
    }
    object InterimJournal : PatientMeetingScreens("{visitId}/interimJournal") {
        fun createRoute(visitId: String, root: Screen) = "${root.route}/$visitId/interimJournal"
    }
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

            LandingPage(
                navToArrival = {
                    navToArrival(
                        navController = navController,
                        visitId = visitId
                    )
                },
                navToHazard = {
                    navToHazardAssessment(
                        navController = navController,
                        visitId = visitId
                    )
                },
                navToContactReason = {
                    navToContactReason(
                        navController = navController,
                        visitId = visitId
                    )
                },
                navToPreviousCare = {
                    navToPreviousCare(
                        navController = navController,
                        visitId = visitId
                    )
                },
                navToHealthHistory = {
                    navToHealthHistory(
                        navController = navController,
                        visitId = visitId
                    )
                },
                navToHealthNow = {
                    navToHealthNow(
                        navController = navController,
                        visitId = visitId
                    )
                },
                navToSuicideAssessment = {
                    navToSuicideAssessment(
                        navController = navController,
                        visitId = visitId
                    )
                },
                navToNursingNeed = {
                    navToNursingNeed(
                        navController = navController,
                        visitId = visitId
                    )
                },
                navToMedicalOrder = {
                    navToMedicalOrder(
                        navController = navController,
                        visitId = visitId
                    )
                },
                navToInterimJournal = {
                    navToInterimJournal(
                        navController = navController,
                        visitId = visitId
                    )
                }
            )
        }
        composable(
            route = PatientMeetingScreens.Arrival.createRoute(root = Screen.PatientMeeting)
        ) { backStackEntry ->
            val visitId = backStackEntry.arguments?.getString("visitId")
            requireNotNull(visitId) { "No patient id provided" }
            ArrivalPage(
                visitId = visitId,
                navBack = { navController.popBackStack() }
            )
        }
        composable(
            route = PatientMeetingScreens.HazardAssessment.createRoute(Screen.PatientMeeting)
        ) { backStackEntry ->
            val visitId = backStackEntry.arguments?.getString("visitId")
            requireNotNull(visitId) { "No patient id provided " }
            //TODO add hazard composable here
            //Text("hej")
        }
        composable(
            route = PatientMeetingScreens.ContactReason.createRoute(Screen.PatientMeeting)
        ) { backStackEntry ->
            val visitId = backStackEntry.arguments?.getString("visitId")
            requireNotNull(visitId) { "No patient meeting" }
            // TODO add contact reason composable
            ContactCauseScreen()

        }
        composable(
            route = PatientMeetingScreens.PreviousCare.createRoute(Screen.PatientMeeting)
        ) { backStackEntry ->
            val visitId = backStackEntry.arguments?.getString("visitId")
            requireNotNull(visitId) { "No patient meeting" }
            // TODO add PreviousCare composable
        }
        composable(
            route = PatientMeetingScreens.HealthHistory.createRoute(Screen.PatientMeeting)
        ) { backStackEntry ->
            val visitId = backStackEntry.arguments?.getString("visitId")
            requireNotNull(visitId) { "No patient meeting" }
            // TODO add HealthHistory composable
        }
        composable(
            route = PatientMeetingScreens.HealthNow.createRoute(Screen.PatientMeeting)
        ) { backStackEntry ->
            val visitId = backStackEntry.arguments?.getString("visitId")
            requireNotNull(visitId) { "No patient meeting" }
            // TODO add HealthNow composable
        }
        composable(
            route = PatientMeetingScreens.SuicideAssessment.createRoute(Screen.PatientMeeting)
        ) { backStackEntry ->
            val visitId = backStackEntry.arguments?.getString("visitId")
            requireNotNull(visitId) { "No patient meeting" }
            // TODO add SuicideAssessment composable
        }
        composable(
            route = PatientMeetingScreens.NursingNeed.createRoute(Screen.PatientMeeting)
        ) { backStackEntry ->
            val visitId = backStackEntry.arguments?.getString("visitId")
            requireNotNull(visitId) { "No patient meeting" }
            // TODO add nursingNeed composable
        }
        composable(
            route = PatientMeetingScreens.MedicalOrder.createRoute(Screen.PatientMeeting)
        ) { backStackEntry ->
            val visitId = backStackEntry.arguments?.getString("visitId")
            requireNotNull(visitId) { "No patient meeting" }
            // TODO add medicalOrder composable
        }
        composable(
            route = PatientMeetingScreens.InterimJournal.createRoute(Screen.PatientMeeting)
        ) { backStackEntry ->
            val visitId = backStackEntry.arguments?.getString("visitId")
            requireNotNull(visitId) { "No patient meeting" }
            // TODO add interimJournal composable
        }
    }
}


fun navToArrival(navController: NavController, visitId: String) {
    navController.navigate(
        PatientMeetingScreens.Arrival.createRoute(
            visitId = visitId,
            root = Screen.PatientMeeting
        )
    )
}

fun navToHazardAssessment(navController: NavController, visitId: String) {
    navController.navigate(
        PatientMeetingScreens.HazardAssessment.createRoute(
            visitId = visitId,
            root = Screen.PatientMeeting
        )
    )
}

fun navToContactReason(navController: NavController, visitId: String) {
    navController.navigate(
        PatientMeetingScreens.ContactReason.createRoute(
            visitId = visitId,
            root = Screen.PatientMeeting
        )
    )
}

fun navToPreviousCare(navController: NavController, visitId: String) {
    navController.navigate(
        PatientMeetingScreens.PreviousCare.createRoute(
            visitId = visitId,
            root = Screen.PatientMeeting
        )
    )
}

fun navToHealthHistory(navController: NavController, visitId: String) {
    navController.navigate(
        PatientMeetingScreens.HealthHistory.createRoute(
            visitId = visitId,
            root = Screen.PatientMeeting
        )
    )
}

fun navToHealthNow(navController: NavController, visitId: String) {
    navController.navigate(
        PatientMeetingScreens.HealthNow.createRoute(
            visitId = visitId,
            root = Screen.PatientMeeting
        )
    )
}

fun navToSuicideAssessment(navController: NavController,visitId: String){
    navController.navigate(
        PatientMeetingScreens.SuicideAssessment.createRoute(
            visitId = visitId,
            root = Screen.PatientMeeting
        )
    )
}
fun navToNursingNeed(navController: NavController,visitId: String){
    navController.navigate(
        PatientMeetingScreens.NursingNeed.createRoute(
            visitId = visitId,
            root = Screen.PatientMeeting
        )
    )
}
fun navToMedicalOrder(navController: NavController,visitId: String){
    navController.navigate(
        PatientMeetingScreens.MedicalOrder.createRoute(
            visitId = visitId,
            root = Screen.PatientMeeting
        )
    )
}

fun navToInterimJournal(navController: NavController,visitId: String){
    navController.navigate(
        PatientMeetingScreens.InterimJournal.createRoute(
            visitId = visitId,
            root = Screen.PatientMeeting
        )
    )
}

enum class NavigationEnum {
    ARRIVAL, DANGER, CONTACT_REASON, PREVIOUS_CARE, HEALTH_HISTORY, HEALTH_NOW, SUICIDE_ASSESSMENT, NURSING_NEED, MEDICAL_ORDER, INTERIM_JOURNAL
}


enum class PatientMeetingForms {
    ARRIVAL {
        override fun createRoute(id: String) =
            PatientMeetingScreens.Arrival.createRoute(root = Screen.PatientMeeting, visitId = id)
    },
    LANDING {
        override fun createRoute(id: String) =
            PatientMeetingScreens.MainScreen.createRoute(root = Screen.PatientMeeting, visitId = id)
    };

    abstract fun createRoute(id: String): String
}


fun navToPatientForm(navController: NavController, visitId: String, patientMeetingForms: PatientMeetingForms) {
    navController.navigate(patientMeetingForms.createRoute(visitId))
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