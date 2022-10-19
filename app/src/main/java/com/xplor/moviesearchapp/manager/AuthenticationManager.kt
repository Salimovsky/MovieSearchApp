package com.xplor.moviesearchapp.manager

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthenticationManager @Inject constructor() {
    private val API_KEY = "dc48f39a98b6943a6f21997a49d8f3fe"
    fun getToken() = API_KEY
}