package com.melendez.knowyourlearning.Pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.melendez.knowyourlearning.Navigation
import com.melendez.knowyourlearning.R

val TAG: String = "MainPage-Melendez"

@Composable
fun MainPage(navController: NavHostController) {
    Column(Modifier.padding(12.dp)) {
        MainCard(navController)
        SettingCard(navController)
    }
}

@Composable
fun MainCard(navController: NavHostController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 6.dp),
        shape = RoundedCornerShape(size = 24.dp)
    ) {
        Text(
            text = stringResource(R.string.start_here),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .padding(vertical = 4.dp)
        )

        Card(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(horizontal = 12.dp),
            shape = RoundedCornerShape(12.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.education),
                contentDescription = "An educational illustration"
            )
        }

        Button(
            onClick = {
                Navigation(
                    navController = navController,
                    TAG = com.melendez.knowyourlearning.Pages.TAG,
                    Start = "MainCard",
                    ViewName = "ImportButton",
                    route = "Import"
                )
            },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(vertical = 4.dp),
            shape = RoundedCornerShape(6.dp)
        ) {
            Text(text = stringResource(R.string.importing))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingCard(navController: NavHostController) {
    Card(
        shape = RoundedCornerShape(size = 24.dp),
        modifier = Modifier.padding(top = 6.dp),
        onClick = {
            Navigation(
                navController = navController,
                TAG = com.melendez.knowyourlearning.Pages.TAG,
                Start = "SettingCard",
                ViewName = "SettingCard",
                route = "Settings"
            )
        }) {
        Icon(
            imageVector = Icons.Rounded.Settings,
            contentDescription = "Settings",
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .padding(top = 12.dp)
        )
        Text(
            text = stringResource(R.string.settings),
            fontSize = 16.sp,
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .padding(vertical = 12.dp, horizontal = 16.dp)
        )

    }
}