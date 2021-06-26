package com.shobrinaf.ui.entertainment.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.shobrinaf.data.source.EntertainmentRepository
import com.shobrinaf.data.source.local.entity.TvShowEntity
import com.shobrinaf.utils.DataDummy
import com.shobrinaf.vo.Resource
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TvShowViewModelTest {

    private lateinit var viewModel: TvShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var entertainmentRepository: EntertainmentRepository

    @Mock
    private lateinit var observer: Observer<Resource<List<TvShowEntity>>>

    @Before
    fun setUp() {
        viewModel = TvShowViewModel(entertainmentRepository)
    }

    @Test
    fun getTvShows() {
        val dummyTvShow = Resource.success(DataDummy.generateDummyTvShows())
        val tvShows = MutableLiveData<Resource<List<TvShowEntity>>>()
        tvShows.value = dummyTvShow

        `when`(entertainmentRepository
                .getAllTvShows())
                .thenReturn(tvShows)
        val tvShowEntities = viewModel.getTvShows().value?.data
        verify(entertainmentRepository).getAllTvShows()
        assertNotNull(tvShowEntities)
        assertEquals(12, tvShowEntities?.size)

        viewModel.getTvShows().observeForever(observer)
        verify(observer).onChanged(dummyTvShow)
    }
}