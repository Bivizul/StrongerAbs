package com.bivizul.strongerabs.data.network

import com.bivizul.strongerabs.domain.Repository
import java.util.*
import javax.inject.Inject


class ApiRepositoryImpl @Inject constructor(private val apiService: ApiService) : Repository {

    override suspend fun getWorkoutList() = apiService.getWorkoutList()

    override suspend fun sendLanguage(send: Locale) = apiService.sendLanguage(send)
}