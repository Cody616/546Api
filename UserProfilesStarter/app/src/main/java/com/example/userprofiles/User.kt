package com.example.userprofiles

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("url") val url: String,
    @SerializedName("message") val message: String? = null
)
