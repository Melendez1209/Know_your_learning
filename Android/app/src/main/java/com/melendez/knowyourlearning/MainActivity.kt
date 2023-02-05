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
import com.melendez.knowyourlearning.Pages.ImportPage
import com.melendez.knowyourlearning.Pages.MainPage
import com.melendez.knowyourlearning.Pages.SettingsPage
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
        navController = navController, startDestination = "Main"
    ) {
        composable(route = "Main") {
            MainPage(navController = navController)
        }
        composable(route = "Import") {
            ImportPage(navController = navController)
        }
        composable(route = "Settings") {
            SettingsPage(navController = navController)
        }
    }
}

fun Navigation(
    navController: NavHostController,
    TAG: String,
    Start: String,
    ViewName: String,
    route: String
) {
    val Content1: String = Start + ": " + ViewName + "按钮被点击了"
    val Content2: String = Start + ": 已跳转至" + route + "Page"
    Log.d(TAG, Content1)
    navController.navigate(route)
    Log.d(TAG, Content2)
}