package com.melendez.knowyourlearning.Screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.melendez.knowyourlearning.R
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.datetime.date.datepicker
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun ImportPage(navController: NavHostController) {
    ImportPagePreview()
}

@Preview
@Composable
fun ImportPagePreview() {

    var pickedDate by remember {
        mutableStateOf(LocalDate.now())
    }

    val formatData by remember {
        derivedStateOf {
            DateTimeFormatter.ofPattern("MMM dd yyyy").format(pickedDate)
        }
    }

    val dateDialogState = rememberMaterialDialogState()

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.padding(12.dp)) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
            ) {
                Text(text = "Demo")
            }
            Button(
                shape = RoundedCornerShape(6.dp),
                onClick = { dateDialogState.show() },
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
            ) { Text(text = stringResource(R.string.ok)) }
        }
    }
    MaterialDialog(dialogState = dateDialogState, shape = RoundedCornerShape(12.dp), buttons = {
        positiveButton(text = stringResource(R.string.ok)) {
            dateDialogState.hide()

            TODO("add event")
        }
        negativeButton(text = stringResource(id = R.string.cancel)) {
            dateDialogState.hide()
        }
    }) {
        datepicker(
            initialDate = LocalDate.now(),
            title = stringResource(R.string.exam_date),
        ) {
            pickedDate = it
        }
    }
}