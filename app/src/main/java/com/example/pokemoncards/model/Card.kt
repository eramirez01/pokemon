package com.example.pokemoncards.model

import com.fasterxml.jackson.annotation.JsonProperty

class Card {
    @JsonProperty("imageUrl")
    var imageUrl: String? = null
}