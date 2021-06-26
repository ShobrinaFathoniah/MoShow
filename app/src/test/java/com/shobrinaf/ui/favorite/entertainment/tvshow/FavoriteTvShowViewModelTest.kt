package com.shobrinaf.ui.favorite.entertainment.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import androidx.paging.PositionalDataSource
import com.shobrinaf.data.source.EntertainmentRepository
import com.shobrinaf.data.source.local.entity.TvShowEntity
import com.shobrinaf.utils.DataDummy
import junit.framework.TestCase.assertEquals
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import java.util.concurrent.Executors

@RunWith(MockitoJUnitRunner::class)
class FavoriteTvShowViewModelTest {
    private lateinit var viewModel: FavoriteTvShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var entertainmentRepository: EntertainmentRepository

    @Mock
    private lateinit var observer: Observer<PagedList<TvShowEntity>>

    @Before
    fun setUp() {
        viewModel = FavoriteTvShowViewModel(entertainmentRepository)
    }

    @Test
    fun `getFavoritTvShows should be success`() {
        val expected = MutableLiveData<PagedList<TvShowEntity>>()
        expected.value = PagedTestDataSource.snapshoot(DataDummy.generateDummyTvShows())
        Mockito.`when`(entertainmentRepository.getFavoritedTvShow()).thenReturn(expected)

        viewModel.getFavoriteTvShows().observeForever(observer)
        Mockito.verify(observer).onChanged(expected.value)

        val expectedValue = expected.value
        val actualValue = viewModel.getFavoriteTvShows().value
        assertEquals(expectedValue, actualValue)
        assertEquals(expectedValue?.snapshot(), actualValue?.snapshot())
        assertEquals(expectedValue?.size, actualValue?.size)
    }

    @Test
    fun `getFavoritTvShows should be success but data is empty`() {
        val expected = MutableLiveData<PagedList<TvShowEntity>>()
        expected.value = PagedTestDataSource.snapshoot()
        Mockito.`when`(entertainmentRepository.getFavoritedTvShow()).thenReturn(expected)

        viewModel.getFavoriteTvShows().observeForever(observer)
        Mockito.verify(observer).onChanged(expected.value)

        val actualDataSize = viewModel.getFavoriteTvShows().value?.size
        Assert.assertTrue("size of data should be 0, actual is $actualDataSize", actualDataSize == 0)
    }

    class PagedTestDataSource private constructor(private val items: List<TvShowEntity>) : PositionalDataSource<TvShowEntity>() {
        companion object {
            fun snapshoot(items: List<TvShowEntity> = listOf()): PagedList<TvShowEntity> {
                return PagedList.Builder(PagedTestDataSource(items), 11)
                        .setNotifyExecutor(Executors.newSingleThreadExecutor())
                        .setFetchExecutor(Executors.newSingleThreadExecutor())
                        .build()
            }
        }

        override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<TvShowEntity>) {
            callback.onResult(items, 0, items.size)
        }

        override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<TvShowEntity>) {
            val start = params.startPosition
            val end = params.startPosition + params.loadSize
            callback.onResult(items.subList(start, end))
        }
    }
}