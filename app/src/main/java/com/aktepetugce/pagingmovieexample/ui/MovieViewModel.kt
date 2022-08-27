package com.aktepetugce.pagingmovieexample.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.aktepetugce.pagingmovieexample.data.MovieRepository
import com.aktepetugce.pagingmovieexample.data.model.Movie
import kotlinx.coroutines.flow.Flow

private const val NETWORK_PAGE_SIZE = 50

class MovieViewModel constructor(private val movieRepository: MovieRepository) : ViewModel() {

    val allMovieList : Flow<PagingData<Movie>> = Pager(
            config = PagingConfig(
                pageSize = NETWORK_PAGE_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { movieRepository.getAllMovies()},
            initialKey = 1
        ).flow
        .cachedIn(viewModelScope)


}

@Suppress("UNCHECKED_CAST")
class MovieViewModelFactory constructor(private val movieRepository: MovieRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MovieViewModel::class.java)) {
            MovieViewModel(this.movieRepository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}