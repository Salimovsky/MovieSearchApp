package com.xplor.moviesearchapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.xplor.moviesearchapp.ui.main.MovieSearchFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
//    TODO:
//    + Add unit tests
//    + Add support for accessibility
//    + Migrate UI to use Jetpack Compose instead of views
//    + Add navigation component
//    + Add support for localization
//    + Add splash screen to show spinner indicator till the app fetches its config from service

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