package com.example.pokemoncards.model

import com.fasterxml.jackson.annotation.JsonProperty

class CardCollection {
    @JsonProperty("cards")
    val cards: List<Card>? = null
}
