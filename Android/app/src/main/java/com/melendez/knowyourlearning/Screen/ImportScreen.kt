package com.melendez.knowyourlearning.Screen

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.melendez.knowyourlearning.R
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.datetime.date.datepicker
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun ImportPage(navController: NavHostController) {
    ImportPagePreview()
}

@OptIn(ExperimentalPagerApi::class)
@Preview
@Composable
fun ImportPagePreview() {

    //Value for date picker
    var pickedDate by remember {
        mutableStateOf(LocalDate.now())
    }

    val formatData by remember {
        derivedStateOf {
            DateTimeFormatter.ofPattern("MMM dd yyyy").format(pickedDate)
        }
    }

    val dateDialogState = rememberMaterialDialogState()

    //Value for page
    val Chinese = stringResource(R.string.Chinese)
    val Math = stringResource(R.string.math)
    val English = stringResource(R.string.english)

    val tabs = remember {
        mutableStateListOf(Chinese, Math, English)
    }

    val state = rememberPagerState(initialPage = 0)
    val scope = rememberCoroutineScope()

    //Layout
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.padding(12.dp)) {

            ScrollableTabRow(selectedTabIndex = state.currentPage) {
                tabs.forEachIndexed { index, tab ->
                    Box(
                        modifier = Modifier
                            .height(30.dp)
                            .fillMaxWidth()
                            .clickable { scope.launch { state.scrollToPage(index, 0f) } },
                        contentAlignment = Alignment.TopCenter
                    ) {
                        Text(text = tab, modifier = Modifier.align(alignment = Alignment.Center))
                    }
                }
            }
            HorizontalPager(state = state, count = tabs.size) { page ->
                Card() {
                    Log.d(TAG, "ImportPagePreview: Loading:" + tabs[page] + page)
                    Text(text = "Page:$page")
                }
            }
            HorizontalPagerIndicator(
                pagerState = state,
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
            )

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