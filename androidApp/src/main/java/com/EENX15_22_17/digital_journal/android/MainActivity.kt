package com.EENX15_22_17.digital_journal.android


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.VectorConverter
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

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
    object PatientMeeting : Screen(
        route = "patientMeeting/{meetingId}"
    ) {
        fun createRoute(meetingId: String) = "patientMeeting/$meetingId"
    }
}

@Preview
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

private fun NavGraphBuilder.addPatientMeetingGraph(
    navController: NavController
) {
    composable(route = Screen.PatientMeeting.route) { backStackEntry ->
        val meetingId = backStackEntry.arguments?.getString("meetingId")
        requireNotNull(meetingId) { "No meeting id provided" }
        /*TODO: replace with real patient meeting screen*/
        PatientMeetingScreen(
            navToOverview = { navController.navigate(Screen.Overview.route) },
            meetingId = meetingId
        )
    }
}

@Preview
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

@Preview
@Composable
fun PatientMeetingScreen(
    @PreviewParameter(OverviewScreenProvider::class) navToOverview: () -> Unit,
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
    }
}