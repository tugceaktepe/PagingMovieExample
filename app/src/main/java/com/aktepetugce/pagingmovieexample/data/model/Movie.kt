package com.aktepetugce.pagingmovieexample.data.model

import com.squareup.moshi.Json

data class Movie(
    @field:Json(name = "original_title") val title: String,
    @field:Json(name = "poster_path") val posterUrl: String? = "",
    @field:Json(name = "popularity") val popularity: Double? = 0.0
)