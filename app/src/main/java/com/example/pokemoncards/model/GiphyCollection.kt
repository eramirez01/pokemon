package com.example.pokemoncards.model

import com.fasterxml.jackson.annotation.JsonProperty

class GiphyCollection {
    @JsonProperty("data")
    val cards: List<GiphyItem>? = null
}
