package com.xplor.moviesearchapp.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class MoviesResponse(
    val page: Int? = null,
    val results: List<Movie>? = null,
    @SerializedName("total_results")
    val totalResults: Int? = null,
    @SerializedName("total_pages")
    val totalPages: Int? = null
) : Parcelable

@Parcelize
data class Movie(
    @SerializedName("poster_path")
    val posterPath: String?,
    val adult: Boolean?,
    val overview: String?,
    @SerializedName("release_date")
    val releaseDate: String?,
    @SerializedName("genre_ids")
    val genreIds: List<Int>?,
    val id: Int?,
    @SerializedName("original_title")
    val originalTitle: String?,
    @SerializedName("original_language")
    val originalLanguage: String?,
    val title: String?,
    @SerializedName("backdrop_path")
    val backdropPath: String?,
    val popularity: Number? = null,
    @SerializedName("vote_count")
    val voteCount: Int? = null,
    val video: Boolean? = null,
    @SerializedName("vote_average")
    val voteAverage: Number? = null
) : Parcelable