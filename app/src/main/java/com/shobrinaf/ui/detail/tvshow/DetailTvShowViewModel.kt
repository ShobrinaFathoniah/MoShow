package com.shobrinaf.ui.detail.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.shobrinaf.data.source.EntertainmentRepository
import com.shobrinaf.data.source.local.entity.TvShowEntity
import com.shobrinaf.vo.Resource

class DetailTvShowViewModel(private val entertainmentRepository: EntertainmentRepository) :
        ViewModel() {
    val tvShowId = MutableLiveData<Int>()

    fun setSelectedtvShow(tvShowId: Int) {
        this.tvShowId.value = tvShowId
    }

    var getTvShow: LiveData<Resource<TvShowEntity>> = Transformations.switchMap(tvShowId) { mTvShowId ->
        entertainmentRepository.getTvShowWithId(mTvShowId)
    }

    fun setFavorited() {
        val newState = !(getTvShow.value?.data?.loved)!!
        getTvShow.value?.data?.let { entertainmentRepository.setFavoritedTvShow(it, newState) }
    }
}