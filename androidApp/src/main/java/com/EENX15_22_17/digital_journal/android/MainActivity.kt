package com.EENX15_22_17.digital_journal.android


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.material.Text
import androidx.compose.ui.tooling.preview.Preview
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


@Composable
fun HelloWorld() {
    return Row() {
        Text(stringResource(R.string.helloworld))
    }
}

@Preview(showBackground = true)
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


