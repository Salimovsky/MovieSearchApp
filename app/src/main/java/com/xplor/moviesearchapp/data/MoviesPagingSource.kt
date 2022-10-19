package com.xplor.moviesearchapp.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.xplor.moviesearchapp.api.MoviesApi
import com.xplor.moviesearchapp.manager.AuthenticationManager
import retrofit2.HttpException
import java.io.IOException

private const val MOVIES_SEARCH_START_PAGE_INDEX = 1

class MoviesPagingSource(
    private val moviesApi: MoviesApi,
    private val query: String,
    private val authManager: AuthenticationManager
) : PagingSource<Int, Movie>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        val pageIndex = params.key ?: MOVIES_SEARCH_START_PAGE_INDEX

        return try {
            val response = moviesApi.searchMovie(apiKey = authManager.getToken(), query = query, page = pageIndex)
            val movies = response.results


            LoadResult.Page(
                data = movies ?: emptyList(),
                prevKey = if (pageIndex == MOVIES_SEARCH_START_PAGE_INDEX) null else pageIndex - 1,
                nextKey = if (movies.isNullOrEmpty()) null else pageIndex + 1
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition?.let { position ->
            val page = state.closestPageToPosition(position)
            page?.prevKey?.minus(1) ?: page?.nextKey?.plus(1)
        }
    }
}