package com.bivizul.strongerabs.presentation.workout

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.bivizul.strongerabs.R
import com.bivizul.strongerabs.presentation.ui.VideoPlayerCmp
import com.bivizul.strongerabs.presentation.ui.theme.Typography

@Composable
fun WorkoutCmp(
    viewModel: WorkoutViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
    id: Int,
) {
    var title = ""
    var video = ""
    var textWorkout = ""

    viewModel.workoutList.observeAsState().value?.let {
        for (element in it) {
            if (element.id == id) {
                title = element.name
                textWorkout = element.workout
                video = element.video
            }
        }
        Scaffold(
            modifier = Modifier
                .fillMaxSize(),
            backgroundColor = colorResource(id = R.color.black_light),
            content = { padding ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(padding),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        modifier = Modifier.padding(16.dp),
                        text = title,
                        style = Typography.h2
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .verticalScroll(state = rememberScrollState()),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Surface(
                            modifier = Modifier.height(320.dp),
                            color = colorResource(id = R.color.black_light)
                        ) {
                            VideoPlayerCmp(video)
                        }
                        Text(
                            modifier = Modifier
                                .padding(16.dp)
                                .fillMaxWidth(),
                            text = textWorkout,
                            style = Typography.body1
                        )
                    }
                }
            }
        )
    }
}

