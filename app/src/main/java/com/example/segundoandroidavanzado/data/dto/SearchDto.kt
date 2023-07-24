package com.example.segundoandroidavanzado.data.dto

import com.squareup.moshi.Json

data class SearchDto (
    @Json(name = "name") val name: String =""
        )