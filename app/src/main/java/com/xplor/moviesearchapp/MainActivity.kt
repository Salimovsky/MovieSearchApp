package com.xplor.moviesearchapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.xplor.moviesearchapp.ui.main.MovieSearchFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    // Add splash screen to show spinner indicator till the app fetches its config from service
    // add cache
    // add localization
    // add support for accessibility
    // add unit tests

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MovieSearchFragment.newInstance())
                .commitNow()
        }
    }
}