package com.example.pokemoncards.model

import com.fasterxml.jackson.annotation.JsonProperty

class Images {
    @JsonProperty("fixed_height_downsampled")
    var downSized: DownSized? = null
}