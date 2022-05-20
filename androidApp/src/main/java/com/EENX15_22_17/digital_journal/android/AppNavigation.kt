package com.EENX15_22_17.digital_journal.android

import androidx.compose.runtime.Composable
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.EENX15_22_17.digital_journal.android.screens.journal.arrival.hazardAssessment.HazardAssessmentScreen
import com.EENX15_22_17.digital_journal.android.screens.journal.arrival.patientInfo.PatientInfoScreen
import com.EENX15_22_17.digital_journal.android.screens.journal.arrival.patientInfo.PatientInfoViewModel
import com.EENX15_22_17.digital_journal.android.screens.journal.events.JournalEventsScreen
import com.EENX15_22_17.digital_journal.android.screens.journal.treatment.interim.InterimJournalScreen
import com.EENX15_22_17.digital_journal.android.screens.journal.treatment.interim.InterimViewModel
import com.EENX15_22_17.digital_journal.android.screens.journal.triage.previousCare.PreviousCareScreen
import com.EENX15_22_17.digital_journal.android.screens.journal.triage.somaticHealth.SomaticHealthScreen
import com.EENX15_22_17.digital_journal.android.screens.journal.triage.suicideAssessment.SuicideAssessmentScreen
import com.EENX15_22_17.digital_journal.android.screens.journal.triage.triageAssessment.TriageAssessmentScreen
import com.EENX15_22_17.digital_journal.android.screens.journalList.JournalListViewModel
import com.EENX15_22_17.digital_journal.android.screens.landingpage.JournalEntryOverviewScreen
import com.EENX15_22_17.digital_journal.android.ui.current.JournalListScreen
import com.EENX15_22_17.digital_journal.android.screens.journal.triage.contactReason.ContactReasonScreen
import com.EENX15_22_17.digital_journal.android.screens.journal.triage.contactReason.ContactReasonViewModel
import org.kodein.di.DI
import org.kodein.di.compose.androidContextDI
import org.kodein.di.instance
import se.predicare.journal.screens.JournalScreen

sealed class ScreenRoute(val route: String) {
    object JournalList : ScreenRoute(route = "journals")
    object JournalOverview : ScreenRoute(route = "journal")
    object PatientOverview : ScreenRoute(route = "patient/{patientId}") {
        fun createRoute(patientId: String) = "patient/$patientId"
    }
}

sealed class JournalScreenRoute(val route: String) {
    val root = ScreenRoute.JournalOverview.route

    //For creating routes to composables
    fun createRoute() = "$root/$route"

    object Overview : JournalScreenRoute("{journalId}") {
        // Overloads and creates a route with a specific id
        override fun createRoute(journalId: String) = "$root/$journalId"
    }
    
    object PatientInfo : JournalScreenRoute("{journalId}/arrival") {
        override fun createRoute(journalId: String) = "$root/$journalId/arrival"
    }

    object HazardAssessment : JournalScreenRoute("{journalId}/hazardAssessment") {
        override fun createRoute(journalId: String) = "$root/$journalId/hazardAssessment"
    }

    object ContactReason : JournalScreenRoute("{journalId}/contactReason") {
        override fun createRoute(journalId: String) = "$root/$journalId/contactReason"
    }

    object PreviousCare : JournalScreenRoute("{journalId}/previousCare") {
        override fun createRoute(journalId: String) = "$root/$journalId/previousCare"
    }

    object SomaticHealth : JournalScreenRoute("{journalId}/somaticHealth") {
        override fun createRoute(journalId: String) = "$root/$journalId/somaticHealth"
    }

    object TriageAssessment : JournalScreenRoute("{journalId}/triageAssessment") {
        override fun createRoute(journalId: String) = "$root/$journalId/triageAssessment"
    }

    object SuicideAssessment : JournalScreenRoute("{journalId}/suicideAssessment") {
        override fun createRoute(journalId: String) = "$root/$journalId/suicideAssessment"
    }

    object JournalEvents : JournalScreenRoute("{journalId}/journalEvents") {
        override fun createRoute(journalId: String) = "$root/$journalId/journalEvents"
    }

    object InterimJournal : JournalScreenRoute("{journalId}/interimJournal") {
        override fun createRoute(journalId: String) = "$root/$journalId/interimJournal"
    }

    abstract fun createRoute(journalId: String): String
}


@Composable
fun NavigationApp(
    navController: NavHostController,
    switchScaffoldDrawerState: () -> Unit
) {
    val di = androidContextDI()
    NavHost(
        navController = navController,
        startDestination = ScreenRoute.JournalList.route
    ) {
        addCurrentBoardGraph(di, navController = navController, switchScaffoldDrawerState = switchScaffoldDrawerState)
        addPatientMeetingGraph(di, navController = navController, switchScaffoldDrawerState = switchScaffoldDrawerState)
    }

}

private fun NavBackStackEntry.getJournalId(): String {
    val journalId = arguments?.getString("journalId")
    requireNotNull(journalId) { "No journalId provided" }
    return journalId
}

private fun NavGraphBuilder.addPatientMeetingGraph(
    di: DI,
    navController: NavController,
    switchScaffoldDrawerState: () -> Unit,
) {
    navigation(
        route = ScreenRoute.JournalOverview.route,
        startDestination = JournalScreenRoute.Overview.route
    ) {
        composable(
            route = JournalScreenRoute.Overview.createRoute()
        ) { backStackEntry ->
            val journalId = backStackEntry.arguments?.getString("journalId")

            /*TODO: Handle meeting id not provided, ex show alert*/
            requireNotNull(journalId) { "No journalId provided" }

            fun navTo(form: JournalScreenRoute) =
                navController.navigateToJournalDetailScreen(journalId, form)

            JournalEntryOverviewScreen(
                journalId = journalId,
                onNavigate = { screen ->
                    val target: JournalScreenRoute = when(screen) {
                        JournalScreen.PATIENT_INFORMATION -> JournalScreenRoute.PatientInfo
                        JournalScreen.ARRIVAL_HAZARD_ASSESSMENT -> JournalScreenRoute.HazardAssessment
                        JournalScreen.CONTACT_REASON -> JournalScreenRoute.ContactReason
                        JournalScreen.SUICIDE_ASSESSMENT -> JournalScreenRoute.SuicideAssessment
                        JournalScreen.PREVIOUS_CARE -> JournalScreenRoute.PreviousCare
                        JournalScreen.SOMATIC_HEALTH -> JournalScreenRoute.SomaticHealth
                        JournalScreen.TRIAGE_ASSESSMENT -> JournalScreenRoute.TriageAssessment
                        JournalScreen.EVENTS -> JournalScreenRoute.JournalEvents
                        JournalScreen.INTERIM_JOURNAL -> JournalScreenRoute.InterimJournal
                    }
                    navTo(target)
                },
                showOverview = { patientId ->
                    navController.navigate(ScreenRoute.PatientOverview.createRoute(patientId = patientId))
                }
            )
        }
        composable(
            route = JournalScreenRoute.PatientInfo.createRoute()
        ) { backStackEntry ->
            val viewModel: PatientInfoViewModel by di.instance(arg = backStackEntry.getJournalId())
            viewModel.update()
            PatientInfoScreen(
                viewModel,
                onBackClicked = navController::popBackStack,
                onMenuClicked = switchScaffoldDrawerState
            )
        }
        composable(
            route = JournalScreenRoute.HazardAssessment.createRoute()
        ) { backStackEntry ->
            HazardAssessmentScreen(
                journalId = backStackEntry.getJournalId(),
                onBackClicked = navController::popBackStack,
                onMenuClicked = switchScaffoldDrawerState
            )
        }
        composable(
            route = JournalScreenRoute.ContactReason.createRoute()
        ) { backStackEntry ->
            val viewModel: ContactReasonViewModel by di.instance(arg = backStackEntry.getJournalId())
            viewModel.update()

            ContactReasonScreen(
                viewModel,
                onBackClicked = navController::popBackStack,
                onMenuClicked = switchScaffoldDrawerState,
            )
        }
        composable(
            route = JournalScreenRoute.SuicideAssessment.createRoute()
        ) { backStackEntry ->
            SuicideAssessmentScreen(
                journalId = backStackEntry.getJournalId(),
                onBackClicked = navController::popBackStack,
                onMenuClicked = switchScaffoldDrawerState
            )
        }
        composable(
            route = JournalScreenRoute.PreviousCare.createRoute()
        ) { backStackEntry ->
            PreviousCareScreen(
                journalId = backStackEntry.getJournalId(),
                onBackClicked = navController::popBackStack,
                onMenuClicked = switchScaffoldDrawerState
            )
        }
        composable(
            route = JournalScreenRoute.SomaticHealth.createRoute()
        ) { backStackEntry ->
            SomaticHealthScreen(
                journalId = backStackEntry.getJournalId(),
                onBackClicked = navController::popBackStack,
                onMenuClicked = switchScaffoldDrawerState
            )
        }
        composable(
            route = JournalScreenRoute.TriageAssessment.createRoute()
        ) { backStackEntry ->
            TriageAssessmentScreen(
                journalId = backStackEntry.getJournalId(),
                onBackClicked = navController::popBackStack,
                onMenuClicked = switchScaffoldDrawerState
            )
        }
        composable(
            route = JournalScreenRoute.JournalEvents.createRoute()
        ) { backStackEntry ->
            JournalEventsScreen(
                journalId = backStackEntry.getJournalId(),
                onBackClicked = navController::popBackStack,
                onMenuClicked = switchScaffoldDrawerState
            )
        }
        composable(
            route = JournalScreenRoute.InterimJournal.createRoute()
        ) { backStackEntry ->
            //TODO: FIX viewmodel
            InterimJournalScreen(
                journalId = backStackEntry.getJournalId(),
                interimViewModel = InterimViewModel(),
                onBackClicked = navController::popBackStack,
                onMenuClicked = switchScaffoldDrawerState
            )
        }
    }
}

fun NavController.navigateToJournalDetailScreen(
    journalId: String,
    detailScreenRoute: JournalScreenRoute
) {
    this.navigate(detailScreenRoute.createRoute(journalId))
}


private fun NavGraphBuilder.addCurrentBoardGraph(
    di: DI,
    navController: NavController,
    switchScaffoldDrawerState: () -> Unit
) {
    val journalListViewModel: JournalListViewModel by di.instance()

    /*TODO: Replace with real overview page */
    composable(route = ScreenRoute.PatientOverview.route) { backStackEntry ->
        val patientId = backStackEntry.arguments?.getString("patientId")
        requireNotNull(patientId) { "No patient id provided" }
        PatientOverviewPage(
            patientId = patientId,
            navBack = { navController.popBackStack() }
        )
    }
    composable(route = ScreenRoute.JournalList.route) {
        JournalListScreen(
            journalListViewModel = journalListViewModel,
            onNavigateToJournal = { journalId ->
                navController.navigate(
                    JournalScreenRoute.Overview.createRoute(journalId = journalId)
                )
            },
            onNavigateToPatient = { patientId ->
                navController.navigate(
                    ScreenRoute.PatientOverview.createRoute(patientId = patientId)
                )
            },
            switchScaffoldDrawerState = switchScaffoldDrawerState
        )
    }
}

fun NavController.navToCurrPatients() {
    this.navigate(ScreenRoute.JournalList.route)
}