package com.aktepetugce.pagingmovieexample.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.aktepetugce.pagingmovieexample.data.model.Movie
import com.aktepetugce.pagingmovieexample.data.repo.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(private val movieRepository: MovieRepository) :
    ViewModel() {

    fun getAllMovies(): Flow<PagingData<Movie>> {
        return movieRepository.getAllMovies().cachedIn(viewModelScope)
    }
}