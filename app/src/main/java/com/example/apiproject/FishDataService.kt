package com.example.apiproject

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface FishDataService {

    @GET("{speciesName}")

    fun getFishDataByFish(
        @Path("speciesName") speciesName: String,

        ): Call<List<FishData>>

}