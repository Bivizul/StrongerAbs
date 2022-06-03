package com.bivizul.strongerabs.presentation.workoutlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.bivizul.strongerabs.presentation.ui.WorkoutListCmp
import com.bivizul.strongerabs.presentation.workout.WorkoutViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WorkoutListFragment : Fragment() {

    private val viewModel by viewModels<WorkoutViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                WorkoutListCmp(findNavController(), viewModel)
            }
        }
    }
}