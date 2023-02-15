package com.melendez.knowyourlearning.Screen.Pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.melendez.knowyourlearning.R

@Preview(device = "id:pixel_6_pro")
@Composable
fun AccountPage() {
    Surface(Modifier.fillMaxSize()) {
        Box(Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable.avatar),
                contentDescription = stringResource(R.string.avatar),
                modifier = Modifier.align(alignment = Alignment.TopCenter)
            )
        }
    }

}