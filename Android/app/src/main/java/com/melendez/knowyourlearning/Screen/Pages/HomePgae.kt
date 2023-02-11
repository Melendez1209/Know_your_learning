package com.melendez.knowyourlearning.Screen.Pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
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

@Composable
fun HomePage(navController: NavHostController){
    Column(modifier = Modifier.padding(12.dp)) {
        MainCard(navController = navController)
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