package com.melendez.knowyourlearning.Screen

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountBox
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.ThumbUp
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.melendez.knowyourlearning.R
import com.melendez.knowyourlearning.Screen.Pages.AccountPage
import com.melendez.knowyourlearning.Screen.Pages.AnalysisPage
import com.melendez.knowyourlearning.Screen.Pages.HomePage


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(navController: NavHostController) {

    var selectedItem by remember { mutableStateOf(0) }
    val items = listOf(
        stringResource(R.string.home),
        stringResource(R.string.analysis),
        stringResource(R.string.account)
    )

    Scaffold(bottomBar = {
        NavigationBar() {
            items.forEachIndexed { index, item ->
                NavigationBarItem(
                    selected = selectedItem == index,
                    onClick = { selectedItem = index },
                    icon = {
                        Icon(
                            imageVector = when (index) {
                                0 -> Icons.Rounded.Home
                                1 -> Icons.Rounded.ThumbUp
                                else -> Icons.Rounded.AccountBox
                            },
                            contentDescription = item
                        )
                    },
                    label = { Text(item) }
                )
            }
        }
    }) {
        when (selectedItem) {
            0 -> HomePage(navController = navController)
            1 -> AnalysisPage()
            else -> AccountPage()
        }
    }
}