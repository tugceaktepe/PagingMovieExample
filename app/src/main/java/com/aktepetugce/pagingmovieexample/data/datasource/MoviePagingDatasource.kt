package com.aktepetugce.pagingmovieexample.data.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.aktepetugce.pagingmovieexample.data.RetrofitService
import com.aktepetugce.pagingmovieexample.data.model.Movie
import kotlinx.coroutines.delay

class MoviePagingDatasource(private val apiService: RetrofitService) : PagingSource<Int, Movie>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        return try {
            val start = params.key ?: STARTING_KEY
            if (start != STARTING_KEY) delay(LOAD_DELAY_MILLIS)
            val response = apiService.getTopRatedMovies(language = "en-US", page = start)
            LoadResult.Page(
                data = response.body()!!.results,
                prevKey = if (start == 1) null else start - 1,
                nextKey = start + 1)
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    companion object{
        private const val STARTING_KEY = 1
        private const val LOAD_DELAY_MILLIS = 500L
    }

}