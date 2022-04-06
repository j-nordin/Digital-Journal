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
import com.EENX15_22_17.digital_journal.android.ui.landingpage.LandingPage
import com.EENX15_22_17.digital_journal.android.ui.screen.ContactCauseScreen
import com.EENX15_22_17.digital_journal.android.ui.triage.history.HealthHistoryPage

sealed class Screen(val route: String) {
    object Overview : Screen(route = "overview")
    object PatientMeeting : Screen(route = "patientMeeting")
    object PatientOverview : Screen(route = "patientOverview/{visitId}") {
        fun createRoute(visitId: String) = "patientOverview/$visitId"
    }
}

sealed class PatientMeetingScreen(val route: String) {
    val root = Screen.PatientMeeting.route

    //For creating routes to composables
    fun createRoute() = "$root/$route"

    object Landing : PatientMeetingScreen("{visitId}") {
        // Overloads and creates a route with a specific id
        fun createRoute(visitId: String) = "$root/$visitId"
    }

    object Arrival : PatientMeetingScreen("{visitId}/arrival") {
        fun createRoute(visitId: String) = "$root/$visitId/arrival"
    }

    object HazardAssessment : PatientMeetingScreen("{visitId}/hazardAssessment") {
        fun createRoute(visitId: String) = "$root/$visitId/hazardAssessment"
    }

    object ContactReason : PatientMeetingScreen("{visitId}/contactReason") {
        fun createRoute(visitId: String) = "$root/$visitId/contactReason"
    }

    object PreviousCare : PatientMeetingScreen("{visitId}/previousCare") {
        fun createRoute(visitId: String) = "$root/$visitId/previousCare"
    }

    object HealthHistory : PatientMeetingScreen("{visitId}/healthHistory") {
        fun createRoute(visitId: String) = "$root/$visitId/healthHistory"
    }

    object HealthNow : PatientMeetingScreen("{visitId}/healthNow") {
        fun createRoute(visitId: String) = "$root/$visitId/healthNow"
    }

    object SuicideAssessment : PatientMeetingScreen("{visitId}/suicideAssessment") {
        fun createRoute(visitId: String) = "$root/$visitId/suicideAssessment"
    }

    object NursingNeed : PatientMeetingScreen("{visitId}/nursingNeed") {
        fun createRoute(visitId: String) = "$root/$visitId/nursingNeed"
    }

    object MedicalOrder : PatientMeetingScreen("{visitId}/medicalOrder") {
        fun createRoute(visitId: String) = "$root/$visitId/medicalOrder"
    }

    object InterimJournal : PatientMeetingScreen("{visitId}/interimJournal") {
        fun createRoute(visitId: String) = "$root/$visitId/interimJournal"
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
        startDestination = PatientMeetingScreen.Landing.route
    ) {
        composable(
            route = PatientMeetingScreen.Landing.createRoute()
        ) { backStackEntry ->
            val visitId = backStackEntry.arguments?.getString("visitId")

            /*TODO: Handle meeting id not provided, ex show alert*/
            requireNotNull(visitId) { "No meeting id provided" }

            fun navTo(form: PatientMeetingFormRoute) =
                navToPatientMeetingForm(navController, visitId, form)

            LandingPage(
                visitId = visitId,
                navToArrival = { navTo(PatientMeetingFormRoute.ARRIVAL) },
                navToHazard = { navTo(PatientMeetingFormRoute.HAZARD) },
                navToContactReason = { navTo(PatientMeetingFormRoute.CONTACT_REASON) },
                navToPreviousCare = { navTo(PatientMeetingFormRoute.PREVIOUS_CARE) },
                navToHealthHistory = { navTo(PatientMeetingFormRoute.HEALTH_HISTORY) },
                navToHealthNow = { navTo(PatientMeetingFormRoute.HEALTH_NOW) },
                navToSuicideAssessment = { navTo(PatientMeetingFormRoute.SUICIDE_ASSESSMENT) },
                navToNursingNeed = { navTo(PatientMeetingFormRoute.NURSING_NEED) },
                navToMedicalOrder = { navTo(PatientMeetingFormRoute.MEDICAL_ORDER) },
                navToInterimJournal = { navTo(PatientMeetingFormRoute.INTERIM_JOURNAL) },
                showOverview = { id ->
                    navController.navigate(Screen.PatientOverview.createRoute(visitId = id))
                }
            )
        }
        composable(
            route = PatientMeetingScreen.Arrival.createRoute()
        ) { backStackEntry ->
            val visitId = backStackEntry.arguments?.getString("visitId")
            requireNotNull(visitId) { "No patient id provided" }
            ArrivalPage(
                visitId = visitId,
                navBack = { navController.popBackStack() }
            )
        }
        composable(
            route = PatientMeetingScreen.HazardAssessment.createRoute()
        ) { backStackEntry ->
            val visitId = backStackEntry.arguments?.getString("visitId")
            requireNotNull(visitId) { "No patient id provided " }
            //TODO add hazard composable here
            //Text("hej")
        }
        composable(
            route = PatientMeetingScreen.ContactReason.createRoute()
        ) { backStackEntry ->
            val visitId = backStackEntry.arguments?.getString("visitId")
            requireNotNull(visitId) { "No patient meeting" }
            ContactCauseScreen()
        }
        composable(
            route = PatientMeetingScreen.PreviousCare.createRoute()
        ) { backStackEntry ->
            val visitId = backStackEntry.arguments?.getString("visitId")
            requireNotNull(visitId) { "No patient meeting" }
            // TODO add PreviousCare composable
        }
        composable(
            route = PatientMeetingScreen.HealthHistory.createRoute()
        ) { backStackEntry ->
            val visitId = backStackEntry.arguments?.getString("visitId")
            requireNotNull(visitId) { "No patient meeting" }
            HealthHistoryPage(
                visitId = visitId,
                navBack = { navController.popBackStack() }
            )
        }
        composable(
            route = PatientMeetingScreen.HealthNow.createRoute()
        ) { backStackEntry ->
            val visitId = backStackEntry.arguments?.getString("visitId")
            requireNotNull(visitId) { "No patient meeting" }
            // TODO add HealthNow composable
        }
        composable(
            route = PatientMeetingScreen.SuicideAssessment.createRoute()
        ) { backStackEntry ->
            val visitId = backStackEntry.arguments?.getString("visitId")
            requireNotNull(visitId) { "No patient meeting" }
            // TODO add SuicideAssessment composable
        }
        composable(
            route = PatientMeetingScreen.NursingNeed.createRoute()
        ) { backStackEntry ->
            val visitId = backStackEntry.arguments?.getString("visitId")
            requireNotNull(visitId) { "No patient meeting" }
            // TODO add nursingNeed composable
        }
        composable(
            route = PatientMeetingScreen.MedicalOrder.createRoute()
        ) { backStackEntry ->
            val visitId = backStackEntry.arguments?.getString("visitId")
            requireNotNull(visitId) { "No patient meeting" }
            // TODO add medicalOrder composable
        }
        composable(
            route = PatientMeetingScreen.InterimJournal.createRoute()
        ) { backStackEntry ->
            val visitId = backStackEntry.arguments?.getString("visitId")
            requireNotNull(visitId) { "No patient meeting" }
            // TODO add interimJournal composable
        }
    }
}

enum class PatientMeetingFormRoute {
    ARRIVAL {
        override fun createRoute(id: String) =
            PatientMeetingScreen.Arrival.createRoute(visitId = id)
    },
    LANDING {
        override fun createRoute(id: String) =
            PatientMeetingScreen.Landing.createRoute(visitId = id)
    },
    CONTACT_REASON {
        override fun createRoute(id: String) =
            PatientMeetingScreen.ContactReason.createRoute(visitId = id)
    },
    HAZARD {
        override fun createRoute(id: String) =
            PatientMeetingScreen.HazardAssessment.createRoute(visitId = id)
    },
    PREVIOUS_CARE {
        override fun createRoute(id: String) =
            PatientMeetingScreen.PreviousCare.createRoute(visitId = id)
    },
    HEALTH_HISTORY {
        override fun createRoute(id: String) =
            PatientMeetingScreen.HealthHistory.createRoute(visitId = id)
    },
    HEALTH_NOW {
        override fun createRoute(id: String) =
            PatientMeetingScreen.HealthNow.createRoute(visitId = id)
    },
    SUICIDE_ASSESSMENT {
        override fun createRoute(id: String) =
            PatientMeetingScreen.SuicideAssessment.createRoute(visitId = id)
    },
    NURSING_NEED {
        override fun createRoute(id: String) =
            PatientMeetingScreen.NursingNeed.createRoute(visitId = id)
    },
    MEDICAL_ORDER {
        override fun createRoute(id: String) =
            PatientMeetingScreen.MedicalOrder.createRoute(visitId = id)
    },
    INTERIM_JOURNAL {
        override fun createRoute(id: String) =
            PatientMeetingScreen.InterimJournal.createRoute(visitId = id)
    };

    abstract fun createRoute(id: String): String
}


fun navToPatientMeetingForm(
    navController: NavController,
    visitId: String,
    patientMeetingFormRoute: PatientMeetingFormRoute
) {
    navController.navigate(patientMeetingFormRoute.createRoute(visitId))
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
                    PatientMeetingScreen.Landing.createRoute(visitId = id)
                )
            },
            navigateSpecificOverviewPage = { id ->
                navController.navigate(
                    Screen.PatientOverview.createRoute(visitId = id)
                )
            }
        )
    }
}