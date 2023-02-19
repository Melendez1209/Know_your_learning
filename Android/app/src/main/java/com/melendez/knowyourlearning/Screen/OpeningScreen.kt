package com.melendez.knowyourlearning.Screen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.melendez.knowyourlearning.Navigation
import com.melendez.knowyourlearning.R
import kotlinx.coroutines.delay

val TAG: String = "OpeningScreen.kt"

@Composable
fun OpeningScreen(navController: NavHostController) {

    LaunchedEffect(key1 = true) {
        delay(1750)
        navController.popBackStack()
        Navigation(
            navController = navController,
            Start = "AutoNavigation",
            ViewName = "None",
            route = "Main"
        )
        Log.d(TAG, "OpeningScreen: Launched")
    }

    Surface(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.mipmap.ic_launcher_foreground),
                contentDescription = stringResource(R.string.logo),
                modifier = Modifier
                    .size(240.dp)
            )
        }
    }
}
