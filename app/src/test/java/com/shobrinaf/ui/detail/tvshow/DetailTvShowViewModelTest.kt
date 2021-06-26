package com.shobrinaf.ui.detail.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import com.shobrinaf.data.source.EntertainmentRepository
import com.shobrinaf.data.source.local.entity.TvShowEntity
import com.shobrinaf.utils.DataDummy
import com.shobrinaf.vo.Resource
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailTvShowViewModelTest {
    private lateinit var viewModel: DetailTvShowViewModel
    private val dummyData = Resource.success(DataDummy.generateDummyTvShows()[0])
    private val tvShowId = dummyData.data?.tvShowId

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var entertainmentRepository: EntertainmentRepository

    @Mock
    private lateinit var observer: Observer<Resource<TvShowEntity>>

    @Before
    fun setUp() {
        viewModel = DetailTvShowViewModel(entertainmentRepository)
        if (tvShowId != null) {
            viewModel.setSelectedtvShow(tvShowId)
        }
    }

    @Test
    fun getTvShow() {
        val tvShow = MutableLiveData<Resource<TvShowEntity>>()
        tvShow.value = dummyData

        `when`(tvShowId?.let { entertainmentRepository.getTvShowWithId(it) }).thenReturn(tvShow)

        viewModel.getTvShow.observeForever(observer)
        verify(observer).onChanged(dummyData)
    }

    @Test
    fun setFavorited() {
        val dummyData = Resource.success(DataDummy.generateDummyTvShows()[0])
        val tvShow = MutableLiveData<Resource<TvShowEntity>>()
        tvShow.value = dummyData

        `when`(tvShowId?.let { entertainmentRepository.getTvShowWithId(it) }).thenReturn(tvShow)

        viewModel.getTvShow = tvShowId?.let { entertainmentRepository.getTvShowWithId(it) }!!
        viewModel.setFavorited()
        val data = tvShow.value?.data as TvShowEntity
        verify(entertainmentRepository).setFavoritedTvShow(data, true)
        verifyNoMoreInteractions(observer)
    }
}