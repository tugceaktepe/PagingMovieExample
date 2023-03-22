package com.aktepetugce.pagingmovieexample.data.model

import androidx.room.Entity
import com.squareup.moshi.Json

@Entity(tableName = "movies")
data class Movie(
    @field:Json(name = "original_title") val title: String,
    @field:Json(name = "poster_path") val posterUrl: String? = "",
    @field:Json(name = "popularity") val popularity: Double? = 0.0
)