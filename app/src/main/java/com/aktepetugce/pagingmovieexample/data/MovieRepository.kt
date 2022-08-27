package com.aktepetugce.pagingmovieexample.data

import com.aktepetugce.pagingmovieexample.data.datasource.MoviePagingDatasource

class MovieRepository constructor(private val retrofitService: RetrofitService) {

    fun getAllMovies() = MoviePagingDatasource(retrofitService)

}