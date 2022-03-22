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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationApp()
        }
    }
}

@Composable
fun NavigationApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Index.route) {
        addIndexGraph(navController = navController)
        addNotIndexGraph(navController = navController)
    }
}

sealed class Screen(val route: String) {
    object Index: Screen(route ="index")
    object NotIndex: Screen(route = "notIndex")
}

private fun NavGraphBuilder.addIndexGraph(navController: NavController) {
    composable(route = Screen.Index.route) {
        IndexScreen(navToNotIndex = { navController.navigate(Screen.NotIndex.route) })
    }
}

private fun NavGraphBuilder.addNotIndexGraph(navController: NavController) {
    composable(route = Screen.NotIndex.route) {
        NotIndexScreen(navToIndex = { navController.navigate(Screen.Index.route) })
    }
}

@Preview
@Composable
fun IndexScreen(@PreviewParameter(NotIndexScreenProvider::class) navToNotIndex: () -> Unit) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Button(onClick = navToNotIndex) {
            Text("Click for notTndex")
        }
    }
}

@Preview
@Composable
fun NotIndexScreen(@PreviewParameter(NotIndexScreenProvider::class) navToIndex: () -> Unit) {
    Button(onClick = navToIndex) {
        Text("Click for index")
    }
}
