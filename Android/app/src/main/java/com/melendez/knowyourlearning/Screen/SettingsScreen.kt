package com.melendez.knowyourlearning.Screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.melendez.knowyourlearning.R

@Composable
fun SettingsScreen(navController: NavHostController) {
    SettingsScreenPreview()
}

@Preview(device = "id:pixel_6_pro")
@Composable
fun SettingsScreenPreview() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.padding(12.dp)) {
            AppSetting()
            AccountSetting()
        }
    }
}

@Preview
@Composable
fun AppSetting() {
    Card(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = stringResource(R.string.preference),
            modifier = Modifier.padding(start = 4.dp)
        )
    }
}

@Preview
@Composable
fun AccountSetting() {
    Card(modifier = Modifier.fillMaxWidth()) {
        Text(text = stringResource(R.string.person_setting))
    }
}