package com.bivizul.strongerabs.domain.models

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class LocaleLang(
    @SerializedName("url")
    val language: String,
)
