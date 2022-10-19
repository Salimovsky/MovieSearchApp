package com.xplor.moviesearchapp.data

import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.xplor.moviesearchapp.api.MoviesApi
import com.xplor.moviesearchapp.manager.AuthenticationManager
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MoviesRepository @Inject constructor(
    private val moviesApi: MoviesApi,
    private val authManager: AuthenticationManager
) {
    fun getMovieSearchResults(query: String) =
        Pager(
            config = PagingConfig(
                pageSize = 20,
                maxSize = 80,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { MoviesPagingSource(moviesApi, query, authManager) }
        )
}