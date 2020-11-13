package com.example.pokemoncards.networking

import com.example.pokemoncards.model.GiphyCollection
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GiphyApi {
    @GET("gifs/trending?api_key=cnSWATCVixm9lKU4gWPncyevkt8LaC1m")
    fun getAllCards(@Query("name") name: String? = null): Call<GiphyCollection>
}