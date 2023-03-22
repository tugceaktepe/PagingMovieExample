package com.aktepetugce.pagingmovieexample.data.datasource.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.aktepetugce.pagingmovieexample.data.model.Movie
import com.aktepetugce.pagingmovieexample.data.repo.MovieApi
import kotlinx.coroutines.delay
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class MoviePagingDatasource @Inject constructor(private val movieApi: MovieApi) : PagingSource<Int, Movie>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        return try {
            val start = params.key ?: STARTING_KEY
            if (start != STARTING_KEY) delay(LOAD_DELAY_MILLIS)
            val response = movieApi.getTopRatedMovies(language = "en-US", page = start)
            val prevKey = if (start == 1) null else start - 1
            val nextKey = start + 1
            LoadResult.Page(
                data = response.results,
                prevKey = prevKey,
                nextKey = nextKey)
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
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