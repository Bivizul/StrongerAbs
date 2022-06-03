package com.bivizul.strongerabs.presentation.workout

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bivizul.strongerabs.domain.utils.Constants.TAG
import com.bivizul.strongerabs.domain.utils.Constants.WORKOUT_SELECT
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WorkoutFragment : Fragment() {

    private val viewModel by viewModels<WorkoutViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return ComposeView(requireContext()).apply {
            val workoutSelect = requireArguments().getInt(WORKOUT_SELECT, 1)
            Log.d(TAG, "workoutSelect: $workoutSelect")
            setContent {
                WorkoutCmp(viewModel, workoutSelect)
            }
        }
    }
}

