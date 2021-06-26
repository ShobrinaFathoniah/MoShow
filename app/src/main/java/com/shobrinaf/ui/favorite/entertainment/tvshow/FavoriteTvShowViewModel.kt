package com.shobrinaf.ui.favorite.entertainment.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.shobrinaf.data.source.EntertainmentRepository
import com.shobrinaf.data.source.local.entity.TvShowEntity

class FavoriteTvShowViewModel(private val entertainmentRepository: EntertainmentRepository) : ViewModel() {
    fun getFavoriteTvShows(): LiveData<PagedList<TvShowEntity>> = entertainmentRepository.getFavoritedTvShow()

}
