package com.example.pokemoncards.model

import com.fasterxml.jackson.annotation.JsonProperty

class CardCollection {
    @JsonProperty("data")
    val cards: List<Card>? = null
}
