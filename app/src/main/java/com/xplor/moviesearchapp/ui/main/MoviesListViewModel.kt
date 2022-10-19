package com.xplor.moviesearchapp.ui.main

import androidx.lifecycle.*
import androidx.paging.cachedIn
import com.xplor.moviesearchapp.data.MoviesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@HiltViewModel
class MoviesListViewModel @Inject constructor(
    private val repository: MoviesRepository
) : ViewModel() {
    private val currentQuery = MutableLiveData(DEFAULT_QUERY)

    val movies = currentQuery.switchMap { newQuery ->
        repository.getMovieSearchResults(newQuery).flow.cachedIn(viewModelScope)
            .asLiveData(viewModelScope.coroutineContext + Dispatchers.IO)
    }

    fun searchMovies(query: String) {
        currentQuery.value = query
    }

    companion object {
        private const val DEFAULT_QUERY = "action"
    }
}