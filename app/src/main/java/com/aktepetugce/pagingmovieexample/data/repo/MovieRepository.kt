package com.aktepetugce.pagingmovieexample.data.repo

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.aktepetugce.pagingmovieexample.data.datasource.remote.MoviePagingDatasource
import com.aktepetugce.pagingmovieexample.data.model.Movie
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieRepository @Inject constructor(private val movieApi: MovieApi) {

    fun getAllMovies(): Flow<PagingData<Movie>> = Pager(
        config = PagingConfig(
            pageSize = NETWORK_PAGE_SIZE,
            enablePlaceholders = false
        ),
        pagingSourceFactory = { MoviePagingDatasource(movieApi) },
        initialKey = 1
    ).flow

    companion object {
        private const val NETWORK_PAGE_SIZE = 10
    }
}