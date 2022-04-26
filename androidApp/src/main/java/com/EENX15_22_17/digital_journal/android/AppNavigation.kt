package com.EENX15_22_17.digital_journal.android

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.EENX15_22_17.digital_journal.android.screens.arrival.patientinfo.ArrivalPage
import com.EENX15_22_17.digital_journal.android.screens.treatment.ordination.OrdinationScreen
import com.EENX15_22_17.digital_journal.android.screens.arrival.hazardassesment.HazardAssessment
import com.EENX15_22_17.digital_journal.android.screens.current.currentpatients.PatientListViewModel
import com.EENX15_22_17.digital_journal.android.screens.interim.InterimPage
import com.EENX15_22_17.digital_journal.android.screens.interim.InterimViewModel
import com.EENX15_22_17.digital_journal.android.ui.current.CurrentScreen
import com.EENX15_22_17.digital_journal.android.screens.landingpage.LandingPage
import com.EENX15_22_17.digital_journal.android.screens.treatment.checkups.TempMedicalCheckup
import com.EENX15_22_17.digital_journal.android.screens.treatment.interim.TempInterim
import com.EENX15_22_17.digital_journal.android.screens.triage.currentHealth.TempCurrentHealth
import com.EENX15_22_17.digital_journal.android.ui.screen.ContactCauseScreen
import com.EENX15_22_17.digital_journal.android.screens.triage.suicideassessment.SuicideAssessmentScreen
import com.EENX15_22_17.digital_journal.android.screens.triage.somatichealth.SomaticHealthPage
import com.EENX15_22_17.digital_journal.android.screens.triage.previousCare.TempPreviusCare
import se.predicare.journal.screens.JournalScreen
import org.kodein.di.DI
import org.kodein.di.compose.androidContextDI
import org.kodein.di.instance

sealed class Screen(val route: String) {
    object Current : Screen(route = "current")
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
        override fun createRoute(visitId: String) = "$root/$visitId"
    }

    object Arrival : PatientMeetingScreen("{visitId}/arrival") {
        override fun createRoute(visitId: String) = "$root/$visitId/arrival"
    }

    object HazardAssessment : PatientMeetingScreen("{visitId}/hazardAssessment") {
        override fun createRoute(visitId: String) = "$root/$visitId/hazardAssessment"
    }

    object ContactReason : PatientMeetingScreen("{visitId}/contactReason") {
        override fun createRoute(visitId: String) = "$root/$visitId/contactReason"
    }

    object PreviousCare : PatientMeetingScreen("{visitId}/previousCare") {
        override fun createRoute(visitId: String) = "$root/$visitId/previousCare"
    }

    object HealthHistory : PatientMeetingScreen("{visitId}/healthHistory") {
        override fun createRoute(visitId: String) = "$root/$visitId/healthHistory"
    }

    object HealthNow : PatientMeetingScreen("{visitId}/healthNow") {
        override fun createRoute(visitId: String) = "$root/$visitId/healthNow"
    }

    object SuicideAssessment : PatientMeetingScreen("{visitId}/suicideAssessment") {
        override fun createRoute(visitId: String) = "$root/$visitId/suicideAssessment"
    }

    object NursingNeed : PatientMeetingScreen("{visitId}/nursingNeed") {
        override fun createRoute(visitId: String) = "$root/$visitId/nursingNeed"
    }

    object MedicalOrder : PatientMeetingScreen("{visitId}/medicalOrder") {
        override fun createRoute(visitId: String) = "$root/$visitId/medicalOrder"
    }

    object InterimJournal : PatientMeetingScreen("{visitId}/interimJournal") {
        override fun createRoute(visitId: String) = "$root/$visitId/interimJournal"
    }

    abstract fun createRoute(visitId: String): String
}


@Composable
fun NavigationApp(
    navController: NavHostController,
    switchScaffoldDrawerState: () -> Unit
) {
    val di = androidContextDI()

    NavHost(
        navController = navController,
        startDestination = Screen.Current.route
    ) {
        addCurrentBoardGraph(di, navController = navController, switchScaffoldDrawerState = switchScaffoldDrawerState)
        addPatientMeetingGraph(navController = navController, switchScaffoldDrawerState = switchScaffoldDrawerState)
    }
}

private fun NavGraphBuilder.addPatientMeetingGraph(
    navController: NavController,
    switchScaffoldDrawerState: () -> Unit,
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

            fun navTo(form: PatientMeetingScreen) =
                navController.navToPatientMeetingForm(visitId, form)

            LandingPage(
                visitId = visitId,
                onNavigate = { screen ->
                    val target: PatientMeetingScreen = when(screen) {
                        JournalScreen.PATIENT_INFORMATION -> PatientMeetingScreen.Arrival
                        JournalScreen.ARRIVAL_HAZARD_ASSESSMENT -> PatientMeetingScreen.HazardAssessment
                        JournalScreen.CONTACT_REASON -> PatientMeetingScreen.ContactReason
                        JournalScreen.SUICIDE_ASSESSMENT -> PatientMeetingScreen.SuicideAssessment
                        JournalScreen.PREVIOUS_CARE -> PatientMeetingScreen.PreviousCare
                        JournalScreen.SOMATIC_HEALTH -> PatientMeetingScreen.HealthHistory
                        JournalScreen.TRIAGE_ASSESSMENT -> PatientMeetingScreen.HealthNow
                        JournalScreen.EVENTS -> PatientMeetingScreen.MedicalOrder
                        JournalScreen.INTERIM_JOURNAL -> PatientMeetingScreen.InterimJournal
                    }
                    navTo(target)
                },
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
                onBackClicked = navController::popBackStack,
                onMenuClicked = switchScaffoldDrawerState
            )
        }
        composable(
            route = PatientMeetingScreen.HazardAssessment.createRoute()
        ) { backStackEntry ->
            val visitId = backStackEntry.arguments?.getString("visitId")
            requireNotNull(visitId) { "No patient id provided " }
            HazardAssessment(
                onBackClicked = navController::popBackStack,
                onMenuClicked = switchScaffoldDrawerState,
                visitId = visitId
            )
        }
        composable(
            route = PatientMeetingScreen.ContactReason.createRoute()
        ) { backStackEntry ->
            val visitId = backStackEntry.arguments?.getString("visitId")
            requireNotNull(visitId) { "No patient meeting" }
            ContactCauseScreen(
                onBackClicked = navController::popBackStack,
                onMenuClicked = switchScaffoldDrawerState,
                visitId = visitId
            )
        }
        composable(
            route = PatientMeetingScreen.PreviousCare.createRoute()
        ) { backStackEntry ->
            val visitId = backStackEntry.arguments?.getString("visitId")
            requireNotNull(visitId) { "No patient meeting" }
            TempPreviusCare(
                visitId = visitId,
                onBackClicked = navController::popBackStack,
                onMenuClicked = switchScaffoldDrawerState
            )
        }
        composable(
            route = PatientMeetingScreen.HealthHistory.createRoute()
        ) { backStackEntry ->
            val visitId = backStackEntry.arguments?.getString("visitId")
            requireNotNull(visitId) { "No patient meeting" }
            SomaticHealthPage(
                visitId = visitId,
                onBackClicked = navController::popBackStack,
                onMenuClicked = switchScaffoldDrawerState
            )
        }
        composable(
            route = PatientMeetingScreen.HealthNow.createRoute()
        ) { backStackEntry ->
            val visitId = backStackEntry.arguments?.getString("visitId")
            requireNotNull(visitId) { "No patient meeting" }
            TempCurrentHealth(
                visitId = visitId,
                onBackClicked = navController::popBackStack,
                onMenuClicked = switchScaffoldDrawerState
            )
        }
        composable(
            route = PatientMeetingScreen.SuicideAssessment.createRoute()
        ) { backStackEntry ->
            val visitId = backStackEntry.arguments?.getString("visitId")
            requireNotNull(visitId) { "No patient meeting" }
            SuicideAssessmentScreen(
                visitId = visitId,
                onBackClicked = navController::popBackStack,
                onMenuClicked = switchScaffoldDrawerState
            )
        }
        composable(
            route = PatientMeetingScreen.NursingNeed.createRoute()
        ) { backStackEntry ->
            val visitId = backStackEntry.arguments?.getString("visitId")
            requireNotNull(visitId) { "No patient meeting" }
            TempMedicalCheckup(
                visitId = visitId,
                onBackClicked = navController::popBackStack,
                onMenuClicked = switchScaffoldDrawerState
            )
        }
        composable(
            route = PatientMeetingScreen.MedicalOrder.createRoute()
        ) { backStackEntry ->
            val visitId = backStackEntry.arguments?.getString("visitId")
            requireNotNull(visitId) { "No patient meeting" }
            OrdinationScreen(
                onBackClicked = navController::popBackStack,
                onMenuClicked = switchScaffoldDrawerState
            )
        }
        composable(
            route = PatientMeetingScreen.InterimJournal.createRoute()
        ) { backStackEntry ->
            val visitId = backStackEntry.arguments?.getString("visitId")
            requireNotNull(visitId) { "No patient meeting" }
            //TODO: FIX viewmodel
            InterimPage(
                interimViewModel = InterimViewModel(),
                visitId = visitId,
                onBackClicked = navController::popBackStack,
                onMenuClicked = switchScaffoldDrawerState
            )
        }
    }
}

fun NavController.navToPatientMeetingForm(
    visitId: String,
    patientMeetingScreen: PatientMeetingScreen
) {
    this.navigate(patientMeetingScreen.createRoute(visitId))
}


private fun NavGraphBuilder.addCurrentBoardGraph(
    di: DI,
    navController: NavController,
    switchScaffoldDrawerState: () -> Unit
) {
    val patientListViewModel: PatientListViewModel by di.instance()

    /*TODO: Replace with real overview page */
    composable(route = Screen.PatientOverview.route) { backStackEntry ->
        val visitId = backStackEntry.arguments?.getString("visitId")
        requireNotNull(visitId) { "No patient id provided" }
        PatientOverviewPage(
            visitId = visitId,
            navBack = { navController.popBackStack() }
        )
    }
    composable(route = Screen.Current.route) {
        CurrentScreen(
            patientListViewModel = patientListViewModel,
            navigateSpecificPatient = { id ->
                navController.navigate(
                    PatientMeetingScreen.Landing.createRoute(visitId = id)
                )
            },
            navigateSpecificOverviewPage = { id ->
                navController.navigate(
                    Screen.PatientOverview.createRoute(visitId = id)
                )
            },
            switchScaffoldDrawerState = switchScaffoldDrawerState
        )
    }
}

fun NavController.navToCurrPatients() {
    this.navigate(Screen.Current.route)
}