package com.bivizul.strongerabs.domain.models

import androidx.annotation.Keep

@Keep
data class Workout(
    val id: Int,
    val name: String,
    val workout: String,
    val video: String,
)