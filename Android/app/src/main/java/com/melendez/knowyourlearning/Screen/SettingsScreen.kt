package com.melendez.knowyourlearning.Screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun SettingsPage(navController: NavHostController) {
    SettingsPagePreview()
}

@Preview(device = "id:pixel_6_pro")
@Composable
fun SettingsPagePreview() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.padding(12.dp)) {

        }
    }
}

@Preview
@Composable
fun AppSetting() {
    Card(modifier = Modifier.fillMaxWidth()) {

    }
}