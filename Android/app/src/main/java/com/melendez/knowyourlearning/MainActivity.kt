package com.melendez.knowyourlearning

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.melendez.knowyourlearning.Screen.ImportScreen
import com.melendez.knowyourlearning.Screen.MainScreen
import com.melendez.knowyourlearning.Screen.OpeningScreen
import com.melendez.knowyourlearning.Screen.SettingsScreen
import com.melendez.knowyourlearning.ui.theme.KnowYourLearningTheme

val TAG: String = "MainActivity-Melendez"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KnowYourLearningTheme {
                NavigationRoot()
            }
        }
    }
}

@Composable
fun NavigationRoot() {
    val navController = rememberNavController()
    NavHost(
        navController = navController, startDestination = "Opening"
    ) {
        composable(route = "Opening") {
            OpeningScreen(navController = navController)
        }
        composable(route = "Main") {
            MainScreen(navController = navController)
        }
        composable(route = "Import") {
            ImportScreen(navController = navController)
        }
        composable(route = "Settings") {
            SettingsScreen(navController = navController)
        }
    }
}

fun Navigation(
    navController: NavHostController,
    Start: String,
    ViewName: String,
    route: String,
) {
    val Content1: String = Start + ": " + ViewName + "Clicked"
    val Content2: String = Start + ": Jumped to" + route + "Page"

    Log.d(TAG, Content1)
    navController.navigate(route)
    Log.d(TAG, Content2)
}
