package com.shobrinaf.ui.detail.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import com.shobrinaf.data.source.EntertainmentRepository
import com.shobrinaf.data.source.local.entity.MovieEntity
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
class DetailMovieViewModelTest {
    private lateinit var viewModel: DetailMovieViewModel
    private val dummyData = DataDummy.generateDummyMovies()[0]
    private val movieId = dummyData.movieId

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var entertainmentRepository: EntertainmentRepository

    @Mock
    private lateinit var observer: Observer<Resource<MovieEntity>>

    @Before
    fun setUp() {
        viewModel = DetailMovieViewModel(entertainmentRepository)
        viewModel.setSelectedMovie(movieId)
    }

    @Test
    fun getMovie() {
        val dummyData = Resource.success(DataDummy.generateDummyMovies()[0])
        val movie = MutableLiveData<Resource<MovieEntity>>()
        movie.value = dummyData

        `when`(entertainmentRepository.getMovieWithId(movieId)).thenReturn(movie)

        viewModel.getMovie.observeForever(observer)
        verify(observer).onChanged(dummyData)
    }

    @Test
    fun setFavorited() {
        val dummyData = Resource.success(DataDummy.generateDummyMovies()[0])
        val movie = MutableLiveData<Resource<MovieEntity>>()
        movie.value = dummyData

        `when`(entertainmentRepository.getMovieWithId(movieId)).thenReturn(movie)

        viewModel.getMovie = entertainmentRepository.getMovieWithId(movieId)
        viewModel.setFavorited()
        val data = movie.value?.data as MovieEntity
        verify(entertainmentRepository).setFavoritedMovie(data, true)
        verifyNoMoreInteractions(observer)
    }
}