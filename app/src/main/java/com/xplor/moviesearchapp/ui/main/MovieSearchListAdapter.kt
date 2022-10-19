package com.xplor.moviesearchapp.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.xplor.moviesearchapp.R
import com.xplor.moviesearchapp.data.Movie
import com.xplor.moviesearchapp.databinding.ItemMovieBinding
import com.xplor.moviesearchapp.manager.ConfigManager


class MovieSearchListAdapter(configManager: ConfigManager):
    PagingDataAdapter<Movie, MovieSearchListAdapter.MovieViewHolder>(MOVIE_COMPARATOR) {
    private val imagePath = configManager.getThumbnailPath()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding =
            ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return MovieViewHolder(binding, imagePath)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val currentItem = getItem(position)

        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }

    class MovieViewHolder(private val binding: ItemMovieBinding, private val imagePath: String) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: Movie) {
            binding.apply {
                Picasso.get()
                    .load(imagePath + movie.posterPath)
                    .placeholder(R.drawable.ic_movie)
                    .error(R.drawable.ic_error)
                    .into(movieImage)

                movieTitle.text = movie.title
                movieOverview.text = movie.overview
                movieReleaseDate.text = movie.releaseDate
            }
        }
    }

    companion object {
        private val MOVIE_COMPARATOR = object : DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Movie, newItem: Movie) =
                oldItem == newItem
        }
    }
}