package com.example.pokemoncards.networking

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.MapperFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

object PokemonCardsApi {

    private val client = OkHttpClient.Builder().build()
    private val retrofit = Retrofit.Builder()
        .client(client)
        .baseUrl("https://api.pokemontcg.io/v1/")
        .addConverterFactory(
            JacksonConverterFactory.create(
                ObjectMapper()
                    .disable(MapperFeature.AUTO_DETECT_CREATORS)
                    .disable(MapperFeature.AUTO_DETECT_GETTERS)
                    .disable(MapperFeature.AUTO_DETECT_SETTERS)
                    .disable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
                    .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                    .setSerializationInclusion(JsonInclude.Include.NON_NULL)
            )
        )
        .build()

    @get:Synchronized
    val cardsApi: CardsApi = retrofit.create(CardsApi::class.java)
}
