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
    object Overview: Screen(route ="overview")
    /*TODO: should take a patientId as parameter*/
    object PatientMeeting: Screen(route = "patientMeeting")
}

@Preview
@Composable
fun NavigationApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Overview.route) {
        addOverviewGraph(navController = navController)
        addPatientMeetingGraph(navController = navController)
    }
}

private fun NavGraphBuilder.addOverviewGraph(navController: NavController) {
    composable(route = Screen.Overview.route) {
        OverviewScreen(navToPatientMeeting = { navController.navigate(Screen.PatientMeeting.route) })
    }
}

private fun NavGraphBuilder.addPatientMeetingGraph(navController: NavController) {
    composable(route = Screen.PatientMeeting.route) {
        /*TODO patientmeeting screen should take a patient id as argument, the argument comes from the given route*/
        PatientMeetingScreen(navToOverview = { navController.navigate(Screen.Overview.route) })
    }
}

@Preview
@Composable
fun OverviewScreen(@PreviewParameter(OverviewScreenProvider::class) navToPatientMeeting: () -> Unit) {
    Column(modifier = Modifier.fillMaxWidth().padding(40.dp)) {
        Button(onClick = navToPatientMeeting) {
            Text("Click for PatientMeeting")
        }
    }
}

@Preview
@Composable
fun PatientMeetingScreen(@PreviewParameter(OverviewScreenProvider::class) navToOverview: () -> Unit) {
    Button(onClick = navToOverview) {
        Text("Click for overview")
    }
}


