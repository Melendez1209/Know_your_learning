package com.melendez.knowyourlearning.Screen

import android.util.Log
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.melendez.knowyourlearning.Navigation
import com.melendez.knowyourlearning.R
import kotlinx.coroutines.delay

val TAG: String = "OpeningScreen.kt"

@Composable
fun OpeningPage(navController: NavHostController) {
    //Animation
    var startAnnotation by remember {
        mutableStateOf(false)
    }
    val alphaAnim = animateFloatAsState(
        targetValue = if (startAnnotation) 1f else 0f, animationSpec = tween(
            durationMillis = 1400
        )
    )

    LaunchedEffect(key1 = true) {
        startAnnotation = true
        delay(2000)
        navController.popBackStack()
        Navigation(
            navController = navController,
            Start = "AutoNavigation",
            ViewName = "None",
            route = "Main"
        )
        Log.d(TAG, "OpeningPage: Launched")
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
                    .alpha(alpha = alphaAnim.value)
            )
        }
    }

}
