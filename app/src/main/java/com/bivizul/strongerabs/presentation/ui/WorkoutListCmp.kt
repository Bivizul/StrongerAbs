package com.bivizul.strongerabs.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.bivizul.strongerabs.R
import com.bivizul.strongerabs.presentation.ui.theme.Typography
import com.bivizul.strongerabs.presentation.workout.WorkoutViewModel

@Composable
fun WorkoutListCmp(
    navController: NavController,
    viewModel: WorkoutViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
) {

    val allWorkouts = viewModel.workoutList.observeAsState(listOf()).value

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        backgroundColor = colorResource(id = R.color.black_light),
        content = { padding ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = stringResource(id = R.string.choose_your_workout),
                    style = Typography.h2
                )

                LazyColumn(
                    modifier = Modifier.padding(8.dp)
                ) {
                    items(allWorkouts) { item ->
                        ItemWorkoutCmp(item = item, navController = navController)
                    }
                }
            }
        }
    )
}