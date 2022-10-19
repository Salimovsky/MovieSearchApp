package com.xplor.moviesearchapp.manager

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CredentialsManager @Inject constructor() {
    // such api could be retrieved from backend upon login
    private val _apiKey = "dc48f39a98b6943a6f21997a49d8f3fe"
    fun getApiToken() = _apiKey
}