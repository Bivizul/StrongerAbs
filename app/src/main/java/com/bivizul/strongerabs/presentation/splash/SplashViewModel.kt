package com.bivizul.strongerabs.presentation.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bivizul.strongerabs.data.network.ApiRepositoryImpl
import com.bivizul.strongerabs.domain.SendLanguageUseCase
import com.bivizul.strongerabs.domain.models.LocaleLang
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(private val repository: ApiRepositoryImpl) : ViewModel() {

    private val _splash = MutableLiveData<LocaleLang>()
    val splash: LiveData<LocaleLang>
        get() = _splash

    private val sendLanguageUseCase = SendLanguageUseCase(repository)

    fun getSplash(send: Locale) {
        viewModelScope.launch(Dispatchers.IO) {
            sendLanguageUseCase.invoke(send).let {
                _splash.postValue(it.body())
            }
        }
    }
}