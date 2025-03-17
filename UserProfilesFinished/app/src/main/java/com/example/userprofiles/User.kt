package com.example.userprofiles

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("name") val name: Name,
    @SerializedName("email") val email: String,
    @SerializedName("location") val location: Location,
    @SerializedName("picture") val picture: Picture
)

data class Name(
    @SerializedName("first") val first: String,
    @SerializedName("last") val last: String
)

data class Picture(
    @SerializedName("large") val large: String
)

data class Location(
    @SerializedName("city") val city: String,
    @SerializedName("state") val state: String,
    @SerializedName("country") val country: String
)
