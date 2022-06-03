package com.bivizul.strongerabs.presentation.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import com.bivizul.strongerabs.R
import com.bivizul.strongerabs.domain.models.Workout
import com.bivizul.strongerabs.domain.utils.Constants
import com.bivizul.strongerabs.presentation.ui.theme.Typography

@Composable
fun ItemWorkoutCmp(
    item: Workout,
    navController: NavController,
) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(vertical = 4.dp),

        onClick = {
            navController.navigate(R.id.action_workoutListFragment_to_workoutFragment,
                bundleOf(Constants.WORKOUT_SELECT to item.id))
        },
        enabled = true,
        border = BorderStroke(width = 2.dp, color = Color.White),
        colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.pink)),
        elevation = ButtonDefaults.elevation(
            defaultElevation = 2.dp,
            pressedElevation = 8.dp,
            hoveredElevation = 5.dp),
        shape = RoundedCornerShape(20.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.TopStart
        ) {
            Text(
                text = "${item.id}. ${item.name}",
                style = Typography.button,
            )
        }
    }
}
