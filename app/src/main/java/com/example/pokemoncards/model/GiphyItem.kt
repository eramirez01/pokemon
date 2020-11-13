package com.example.pokemoncards.model

import com.fasterxml.jackson.annotation.JsonProperty

class GiphyItem {
    @JsonProperty("images")
    var images: Images? = null
}