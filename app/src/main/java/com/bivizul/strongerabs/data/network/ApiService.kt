package com.bivizul.strongerabs.data.network

import com.bivizul.strongerabs.domain.models.LocaleLang
import com.bivizul.strongerabs.domain.models.Workout
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import java.util.*

interface ApiService {

    @GET("/6strongerabs/workouts.json")
    suspend fun getWorkoutList(): Response<List<Workout>>

    @POST("/6strongerabs/splash.php")
    suspend fun sendLanguage(@Body send: Locale): Response<LocaleLang>
}