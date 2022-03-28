package com.EENX15_22_17.digital_journal.android


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.navigation

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
    object PatientMeeting : Screen(route = "patientMeeting/{meetingId}") {
        fun createRoute(meetingId : String) = "patientMeeting/$meetingId"
    }
}

sealed class PatientMeetingScreens(open val route: String) {
    abstract class MeetingSubPage(val sub: String) : PatientMeetingScreens(sub) {
        override val route = Screen.PatientMeeting.route + "/" + sub
        fun createRoute(id : String) = Screen.PatientMeeting.createRoute(id) + "/" + sub
    }

    object MainScreen : MeetingSubPage("mainScreen")
    object Arrival : MeetingSubPage("arrival")
    object HazardAssessment : MeetingSubPage("hazardAssessment")
}

@Composable
fun NavigationApp() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.Overview.route
    ) {
        addOverviewGraph(navController = navController)
        addPatientMeetingGraph(navController = navController)
    }
}

private fun NavGraphBuilder.addPatientMeetingGraph(
    navController: NavController
) {
    navigation(
        route = Screen.PatientMeeting.route,
        startDestination = PatientMeetingScreens.MainScreen.route
    ) {
        composable(route = PatientMeetingScreens.MainScreen.route) { backStackEntry ->
            val meetingId = backStackEntry.arguments?.getString("meetingId")

            /*TODO: Handle meeting id not provided, ex show alert*/
            requireNotNull(meetingId) { "No meeting id provided" }

            /*TODO: replace with real patient meeting screen*/
            PatientMeetingScreen(
                navToOverview = { navController.navigate(Screen.Overview.route) },
                navToArrival = { navController.navigate(PatientMeetingScreens.Arrival.createRoute(meetingId)) },
                meetingId = meetingId
            )
        }
        composable(route = PatientMeetingScreens.Arrival.route) { backStackEntry ->
            val meetingId = backStackEntry.arguments?.getString("meetingId")
            requireNotNull(meetingId) { "No meeting id provided" }
            ArrivalScreen(meetingId)
        }
    }
}

private fun NavGraphBuilder.addOverviewGraph(
    navController: NavController
) {
    composable(route = Screen.Overview.route) {
        /*TODO: replace with real overview screen*/
        OverviewScreen(
            navToPatientMeeting = { id ->
                navController.navigate(Screen.PatientMeeting.createRoute(id))
            },
            goBack = { navController.popBackStack() }
        )
    }
}

@Composable
fun ArrivalScreen(meetingId: String) {
    Column() {
        Text(text = "This is the arrival screen for meetingid $meetingId")
    }
}

@Composable
fun HazardScreen(meetingId: String) {
    Column() {
        Text(text = "This is the hazerd screen for meetingid $meetingId")
    }
}

@Composable
fun OverviewScreen(
    @PreviewParameter(OverviewScreenProvider::class) navToPatientMeeting: (String) -> Unit,
    goBack: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(40.dp)
    ) {
        Button(
            onClick = { navToPatientMeeting("1") }
        ) {
            Text("Click for PatientMeeting 1")
        }
        Button(
            onClick = { navToPatientMeeting("2") }
        ) {
            Text("Click for PatientMeeting 2")
        }
        Button(
            onClick = goBack
        ) {
            Text(text = "Go back")
        }
    }
}


@Composable
fun PatientMeetingScreen(
    @PreviewParameter(OverviewScreenProvider::class) navToOverview: () -> Unit,
    navToArrival: () -> Unit,
    meetingId: String = "0"
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(40.dp)
    ) {
        Text(text = "This is patient meeting with id: $meetingId")
        Button(onClick = navToOverview) {
            Text("Click for overview")
        }
        Button(onClick = navToArrival) {
            Text("Go to arrival page for patient")
        }
    }
}