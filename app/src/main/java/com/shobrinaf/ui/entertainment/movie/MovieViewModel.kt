package com.shobrinaf.ui.entertainment.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.shobrinaf.data.source.EntertainmentRepository
import com.shobrinaf.data.source.local.entity.MovieEntity
import com.shobrinaf.vo.Resource

class MovieViewModel(private val entertainmentRepository: EntertainmentRepository) : ViewModel() {
    fun getMovies(): LiveData<Resource<List<MovieEntity>>> = entertainmentRepository.getAllMovies()
}
