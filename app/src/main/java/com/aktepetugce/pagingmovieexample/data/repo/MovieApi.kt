package com.aktepetugce.pagingmovieexample.data.repo

import com.aktepetugce.pagingmovieexample.data.model.MovieResponse
import com.aktepetugce.pagingmovieexample.util.ApiConstants
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(
        @Query("api_key") apiKey: String  = ApiConstants.API_KEY,
        @Query("language") language: String,
        @Query("page") page: Int
    ): MovieResponse
}