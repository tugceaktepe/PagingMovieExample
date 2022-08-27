package com.aktepetugce.pagingmovieexample.data

import com.aktepetugce.pagingmovieexample.data.model.MovieResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(
        @Query("api_key") api_key: String  = API_KEY,
        @Query("language") language: String,
        @Query("page") page: Int
    ): Response<MovieResponse>

    companion object {
        const val BASEURL = "https://api.themoviedb.org/3/"
        const val API_KEY = "YOUR_API_KEY"
        var retrofitService: RetrofitService? = null
        fun getInstance() : RetrofitService {
            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl(BASEURL)
                    .addConverterFactory(MoshiConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }

    }
}