package com.example.pokemoncards.model

import com.fasterxml.jackson.annotation.JsonProperty

class Card {
    @JsonProperty("images")
    var images: Images? = null
}