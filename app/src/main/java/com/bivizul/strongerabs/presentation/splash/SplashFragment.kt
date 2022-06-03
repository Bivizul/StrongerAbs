package com.bivizul.strongerabs.presentation.splash

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.browser.customtabs.CustomTabsIntent
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import coil.load
import com.bivizul.strongerabs.R
import com.bivizul.strongerabs.databinding.FragmentSplashBinding
import com.bivizul.strongerabs.domain.utils.Constants.SPLASH_IMAGE
import com.bivizul.strongerabs.domain.utils.Constants.SPLASH_MILLIS
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*

@AndroidEntryPoint
class SplashFragment : Fragment(R.layout.fragment_splash) {

    private val viewModel by viewModels<SplashViewModel>()
    private val binding by viewBinding(FragmentSplashBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val locale = getCurrentLocale(requireContext())

        binding.imgSplash.load(SPLASH_IMAGE)

        viewModel.getSplash(locale)
        viewModel.splash.observe(viewLifecycleOwner) {
            CoroutineScope(Dispatchers.Main).launch {
                if (it.language == "no") {
                    delay(SPLASH_MILLIS)
                    findNavController().navigate(R.id.action_splashFragment_to_mainFragment)
                } else {
                    installLanguage(it.language)
                }
            }
        }
    }

    private fun installLanguage(language: String) {
        val builder = CustomTabsIntent.Builder()
        val customTabsIntent = builder.build()
        customTabsIntent.launchUrl(requireActivity(), Uri.parse(language))
    }

    private fun getCurrentLocale(context: Context): Locale =
        context.resources.configuration.locales[0]
}


