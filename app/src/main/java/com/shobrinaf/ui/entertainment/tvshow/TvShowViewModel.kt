package com.shobrinaf.ui.entertainment.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.shobrinaf.data.source.EntertainmentRepository
import com.shobrinaf.data.source.local.entity.TvShowEntity
import com.shobrinaf.vo.Resource

class TvShowViewModel(private val entertainmentRepository: EntertainmentRepository) : ViewModel() {
    fun getTvShows(): LiveData<Resource<List<TvShowEntity>>> = entertainmentRepository.getAllTvShows()
}