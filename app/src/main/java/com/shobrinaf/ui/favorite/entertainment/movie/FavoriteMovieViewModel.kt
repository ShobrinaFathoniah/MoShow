package com.shobrinaf.ui.favorite.entertainment.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.shobrinaf.data.source.EntertainmentRepository
import com.shobrinaf.data.source.local.entity.MovieEntity

class FavoriteMovieViewModel(private val entertainmentRepository: EntertainmentRepository) : ViewModel() {
    fun getFavoriteMovies(): LiveData<PagedList<MovieEntity>> = entertainmentRepository.getFavoritedMovie()
}
