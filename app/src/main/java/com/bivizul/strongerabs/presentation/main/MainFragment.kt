package com.bivizul.strongerabs.presentation.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import coil.load
import com.bivizul.strongerabs.R
import com.bivizul.strongerabs.databinding.FragmentMainBinding
import com.bivizul.strongerabs.domain.utils.Constants.SPLASH_IMAGE
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.fragment_main) {

    private val binding by viewBinding(FragmentMainBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            imgMain.load(SPLASH_IMAGE)

            tvWorkout.setOnClickListener {
                findNavController().navigate(R.id.action_mainFragment_to_workoutListFragment)
            }

            imgSetting.setOnClickListener {
                findNavController().navigate(R.id.action_mainFragment_to_settingsFragment)
            }
        }
    }
}