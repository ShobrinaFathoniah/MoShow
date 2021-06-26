package com.shobrinaf.ui.detail.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.shobrinaf.data.source.EntertainmentRepository
import com.shobrinaf.data.source.local.entity.MovieEntity
import com.shobrinaf.vo.Resource

class DetailMovieViewModel(private val entertainmentRepository: EntertainmentRepository) :
        ViewModel() {
    val movieId = MutableLiveData<Int>()

    fun setSelectedMovie(movieId: Int) {
        this.movieId.value = movieId
    }

    var getMovie: LiveData<Resource<MovieEntity>> = Transformations.switchMap(movieId) { mMovieId ->
        entertainmentRepository.getMovieWithId(mMovieId)
    }

    fun setFavorited() {
        val movieResource = getMovie.value
        if (movieResource != null) {
            val movieFavorited = movieResource.data
            if (movieFavorited != null) {
                val newState = !(movieFavorited.loved)
                entertainmentRepository.setFavoritedMovie(movieFavorited, newState)
            }
        }
    }
}