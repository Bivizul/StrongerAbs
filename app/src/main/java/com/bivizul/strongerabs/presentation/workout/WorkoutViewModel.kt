package com.bivizul.strongerabs.presentation.workout

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bivizul.strongerabs.data.network.ApiRepositoryImpl
import com.bivizul.strongerabs.domain.GetWorkoutListUseCase
import com.bivizul.strongerabs.domain.models.Workout
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WorkoutViewModel @Inject constructor(private val repository: ApiRepositoryImpl) :
    ViewModel() {

    private val getWorkoutListUseCase = GetWorkoutListUseCase(repository)

    private val _workoutList = MutableLiveData<List<Workout>>()
    val workoutList: LiveData<List<Workout>> = _workoutList

    init {
        getWorkoutList()
    }

    private fun getWorkoutList() {
        viewModelScope.launch(Dispatchers.IO) {
            getWorkoutListUseCase.invoke().let {
                _workoutList.postValue(it.body())
            }
        }
    }
}