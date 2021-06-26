package com.shobrinaf.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shobrinaf.data.source.EntertainmentRepository
import com.shobrinaf.di.Injection
import com.shobrinaf.ui.detail.movie.DetailMovieViewModel
import com.shobrinaf.ui.detail.tvshow.DetailTvShowViewModel
import com.shobrinaf.ui.entertainment.movie.MovieViewModel
import com.shobrinaf.ui.entertainment.tvshow.TvShowViewModel
import com.shobrinaf.ui.favorite.entertainment.movie.FavoriteMovieViewModel
import com.shobrinaf.ui.favorite.entertainment.tvshow.FavoriteTvShowViewModel

class ViewModelFactory private constructor(private val mEntertainmentRepository: EntertainmentRepository) :
        ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
                instance ?: synchronized(this) {
                    instance ?: ViewModelFactory(Injection.provideRepository(context)).apply {
                        instance = this
                    }
                }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                MovieViewModel(mEntertainmentRepository) as T
            }
            modelClass.isAssignableFrom(TvShowViewModel::class.java) -> {
                TvShowViewModel(mEntertainmentRepository) as T
            }
            modelClass.isAssignableFrom(DetailMovieViewModel::class.java) -> {
                DetailMovieViewModel(mEntertainmentRepository) as T
            }
            modelClass.isAssignableFrom(DetailTvShowViewModel::class.java) -> {
                DetailTvShowViewModel(mEntertainmentRepository) as T
            }
            modelClass.isAssignableFrom(FavoriteMovieViewModel::class.java) -> {
                FavoriteMovieViewModel(mEntertainmentRepository) as T
            }
            modelClass.isAssignableFrom(FavoriteTvShowViewModel::class.java) -> {
                FavoriteTvShowViewModel(mEntertainmentRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }

    }
}