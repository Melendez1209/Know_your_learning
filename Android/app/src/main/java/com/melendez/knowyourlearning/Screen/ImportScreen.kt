package com.melendez.knowyourlearning.Screen

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.chargemap.compose.numberpicker.NumberPicker
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.melendez.knowyourlearning.R
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.datetime.date.datepicker
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun ImportScreen(navController: NavHostController) {
    ImportScreenPreview()
}

@OptIn(ExperimentalPagerApi::class)
@Preview
@Composable
fun ImportScreenPreview() {

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

    val tabs = remember { mutableStateListOf(Chinese, Math, English) }

    val state = rememberPagerState(initialPage = 0)
    val scope = rememberCoroutineScope()

    //Layout
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.padding(12.dp)) {

            ScrollableTabRow(
                selectedTabIndex = state.currentPage,
                modifier = Modifier.fillMaxWidth()
            ) {
                tabs.forEachIndexed { index, tab ->
                    Box(
                        modifier = Modifier
                            .height(30.dp)
                            .fillMaxWidth()
                            .clickable { scope.launch { state.animateScrollToPage(index, 0f) } },
                        contentAlignment = Alignment.TopCenter
                    ) {
                        Text(text = tab, modifier = Modifier.align(alignment = Alignment.Center))
                    }
                }
            }

            HorizontalPager(
                state = state,
                count = tabs.size,
                modifier = Modifier.padding(vertical = 12.dp),
                itemSpacing = 12.dp
            ) { page ->
                Card(modifier = Modifier.fillMaxWidth()) {

                    Log.d(TAG, "ImportPagePreview: Loading:" + tabs[page] + page)
                    val subject = tabs[page]
                    var fullMark by remember { mutableStateOf(150) }
                    var Mark by remember { mutableStateOf(fullMark - 15) }

                    Text(
                        text = subject,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .align(alignment = Alignment.CenterHorizontally)
                            .padding(vertical = 4.dp)
                    )

                    Row(
                        modifier = Modifier
                            .padding(4.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        Row {
                            Text(
                                text = stringResource(R.string.full_marks),
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.align(alignment = Alignment.CenterVertically)
                            )
                            NumberPicker(
                                value = fullMark,
                                onValueChange = {
                                    fullMark = it
                                    Log.i(TAG, "ImportPagePreview: fullMark:" + fullMark)
                                },
                                range = Mark..230
                            )
                        }

                        Row {
                            Text(
                                text = stringResource(R.string.mark),
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.align(alignment = Alignment.CenterVertically)
                            )
                            NumberPicker(
                                value = Mark,
                                onValueChange = {
                                    Mark = it
                                    Log.i(TAG, "ImportPagePreview: Mark:" + Mark)
                                },
                                range = 0..fullMark
                            )
                        }
                    }

                }
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
