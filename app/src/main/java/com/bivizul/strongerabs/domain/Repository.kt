package com.bivizul.strongerabs.domain

import com.bivizul.strongerabs.domain.models.LocaleLang
import com.bivizul.strongerabs.domain.models.Workout
import retrofit2.Response
import java.util.*

interface Repository {

    suspend fun getWorkoutList(): Response<List<Workout>>

    suspend fun sendLanguage(send: Locale): Response<LocaleLang>

}