package com.example.apiproject

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface FishDataService {

    @GET("api/species/{species}.json?")

    fun getFishDataByFish(
        @Path("fish") fish: String,

    ): Call<List<FishData>>

}