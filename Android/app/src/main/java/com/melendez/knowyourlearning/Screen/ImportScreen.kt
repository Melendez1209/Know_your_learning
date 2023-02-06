package com.melendez.knowyourlearning.Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun ImportPage(navController: NavHostController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Green),
        shape = RoundedCornerShape(size = 24.dp)
    ) {
        Text(text = "ImportPage")
    }
}