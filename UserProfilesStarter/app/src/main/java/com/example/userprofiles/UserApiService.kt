package com.example.userprofiles

import com.google.gson.annotations.SerializedName
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface UserApiService {
    @GET("random")
    suspend fun getRandomUser(
        @Query("format") format: String = "json",
        @Query("type") type: String = "jpg"
    ): User
}

object RetrofitInstance {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://random-d.uk/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api: UserApiService by lazy { retrofit.create(UserApiService::class.java) }
}
