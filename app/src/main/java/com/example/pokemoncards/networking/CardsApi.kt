package com.example.pokemoncards.networking

import com.example.pokemoncards.model.CardCollection
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CardsApi {
    @GET("cards")
    fun getAllCards(@Query("name") name: String? = null): Call<CardCollection>
}