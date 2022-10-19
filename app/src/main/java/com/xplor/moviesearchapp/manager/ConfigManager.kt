package com.xplor.moviesearchapp.manager

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ConfigManager @Inject constructor() {
// this config should be fetched from service and cached for few days
// https://api.themoviedb.org/3/configuration?api_key=apiKey

    private val imageBaseUrl = "https://image.tmdb.org/t/p/"
    private val backdropSizes = listOf("w300","w780","w1280","original")
    private val logoSizes = listOf("w45","w92","w154","w185","w300","w500","original")
    private val posterSizes = listOf("w92","w154","w185","w342","w500","w780","original")
    private val profileSizes = listOf("w45","w185","h632","original")
    private val stillSizes = listOf("w92","w185","w300","original")

    // add logic to figure out which size to use depending on device dimension and type, etc: tablet vs smartphone..
    fun getThumbnailPath() =  imageBaseUrl + stillSizes[1]
}