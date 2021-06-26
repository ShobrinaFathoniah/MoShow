package com.shobrinaf.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.nhaarman.mockitokotlin2.doNothing
import com.nhaarman.mockitokotlin2.verify
import com.shobrinaf.data.source.local.LocalDataSource
import com.shobrinaf.data.source.local.entity.MovieEntity
import com.shobrinaf.data.source.local.entity.TvShowEntity
import com.shobrinaf.data.source.remote.RemoteDataSource
import com.shobrinaf.utils.*
import com.shobrinaf.vo.Resource
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class EntertainmentRepositoryTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)
    private val entertainmentRepository = FakeEntertainmentRepository(remote, local, appExecutors)

    private val moviesResponse = DataDummy.generateRemoteDummyMovies()
    private val movieId = moviesResponse[0].movieId

    private val tvShowResponse = DataDummy.generateRemoteDummyTvShows()
    private val tvShowId = tvShowResponse[0].tvShowId

    private val testExecutors: AppExecutors = AppExecutors(TestExecutor(), TestExecutor(), TestExecutor())


    @Test
    fun getAllMovies() {
        val dummyEntity = MutableLiveData<List<MovieEntity>>()
        dummyEntity.value = DataDummy.generateDummyMovies()
        `when`(local.getAllMovie()).thenReturn(dummyEntity)

        val movieEntities = LiveDataTestUtil.getValue(entertainmentRepository.getAllMovies())
        verify(local).getAllMovie()
        assertNotNull(movieEntities.data)
        assertEquals(moviesResponse.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getAllTvShows() {
        val dummyEntity = MutableLiveData<List<TvShowEntity>>()
        dummyEntity.value = DataDummy.generateDummyTvShows()
        `when`(local.getAllTvShow()).thenReturn(dummyEntity)

        val tvShowEntities = LiveDataTestUtil.getValue(entertainmentRepository.getAllTvShows())
        verify(local).getAllTvShow()
        assertNotNull(tvShowEntities.data)
        assertEquals(tvShowResponse.size.toLong(), tvShowEntities.data?.size?.toLong())
    }

    @Test
    fun getTvShowById() {
        val dummyEntity = MutableLiveData<TvShowEntity>()
        dummyEntity.value = DataDummy.generateDummyTvShows()[0]
        `when`(local.getTvShowById(tvShowId)).thenReturn(dummyEntity)

        val tvShow = LiveDataTestUtil.getValue(entertainmentRepository.getTvShowWithId(tvShowId))
        verify(local).getTvShowById(tvShowId)
        assertNotNull(tvShow.data)
        assertNotNull(tvShow.data?.tvShowId)
        assertEquals(tvShowResponse[0].title, tvShow.data?.title)
        assertEquals(tvShowResponse[0].tvShowId, tvShow.data?.tvShowId)
        assertEquals(tvShowResponse[0].duration, tvShow.data?.duration)
        assertEquals(tvShowResponse[0].genres, tvShow.data?.genres)
        assertEquals(tvShowResponse[0].episodes, tvShow.data?.episodes)
        assertEquals(tvShowResponse[0].description, tvShow.data?.description)
        assertEquals(tvShowResponse[0].imagePath, tvShow.data?.imagePath)
        assertEquals(tvShowResponse[0].loved, tvShow.data?.loved)
    }

    @Test
    fun getMovieById() {
        val dummyEntity = MutableLiveData<MovieEntity>()
        dummyEntity.value = DataDummy.generateDummyMovies()[0]
        `when`(local.getMovieById(movieId)).thenReturn(dummyEntity)

        val movie = LiveDataTestUtil.getValue(entertainmentRepository.getMovieWithId(movieId))
        verify(local).getMovieById(movieId)
        assertNotNull(movie)
        assertNotNull(movie.data?.movieId)
        assertEquals(moviesResponse[0].title, movie.data?.title)
        assertEquals(moviesResponse[0].movieId, movie.data?.movieId)
        assertEquals(moviesResponse[0].duration, movie.data?.duration)
        assertEquals(moviesResponse[0].genres, movie.data?.genres)
        assertEquals(moviesResponse[0].releaseTime, movie.data?.releaseTime)
        assertEquals(moviesResponse[0].description, movie.data?.description)
        assertEquals(moviesResponse[0].imagePath, movie.data?.imagePath)
        assertEquals(moviesResponse[0].loved, movie.data?.loved)
    }

    @Test
    fun getFavoritedMovie() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getFavoritedMovie()).thenReturn(dataSourceFactory)

        entertainmentRepository.getFavoritedMovie()
        val movieEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovies()))
        verify(local).getFavoritedMovie()
        assertNotNull(movieEntities)
        assertEquals(moviesResponse.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getFavoritedTvShow() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(local.getFavoritedTvShow()).thenReturn(dataSourceFactory)

        entertainmentRepository.getFavoritedTvShow()
        val tvShowEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTvShows()))
        verify(local).getFavoritedTvShow()
        assertNotNull(tvShowEntities)
        assertEquals(tvShowResponse.size.toLong(), tvShowEntities.data?.size?.toLong())
    }

    @Test
    fun setFavoriteTvShow() {
        val dummyEntity = DataDummy.generateDummyTvShows()[0]
        val favorite = true

        `when`(appExecutors.diskIO()).thenReturn(testExecutors.diskIO())
        doNothing().`when`(local).updateTvShow(dummyEntity, favorite)
        entertainmentRepository.setFavoritedTvShow(dummyEntity, favorite)
        verify(local).updateTvShow(dummyEntity, favorite)
        assertNotNull(dummyEntity.loved)
    }

    @Test
    fun setUnfavoriteTvShow() {
        val dummyEntity = DataDummy.generateDummyTvShows()[0]
        val favorite = false

        `when`(appExecutors.diskIO()).thenReturn(testExecutors.diskIO())
        doNothing().`when`(local).updateTvShow(dummyEntity, favorite)
        entertainmentRepository.setFavoritedTvShow(dummyEntity, favorite)
        verify(local).updateTvShow(dummyEntity, favorite)
        assertNotNull(dummyEntity.loved)
    }

    @Test
    fun setFavoriteMovie() {
        val dummyEntity = DataDummy.generateDummyMovies()[0]
        val favorite = true

        `when`(appExecutors.diskIO()).thenReturn(testExecutors.diskIO())
        doNothing().`when`(local).updateMovie(dummyEntity, favorite)
        entertainmentRepository.setFavoritedMovie(dummyEntity, favorite)
        verify(local).updateMovie(dummyEntity, favorite)
        assertNotNull(dummyEntity.loved)
    }

    @Test
    fun setUnfavoriteMovie() {
        val dummyEntity = DataDummy.generateDummyMovies()[0]
        val favorite = false

        `when`(appExecutors.diskIO()).thenReturn(testExecutors.diskIO())
        doNothing().`when`(local).updateMovie(dummyEntity, favorite)
        entertainmentRepository.setFavoritedMovie(dummyEntity, favorite)
        verify(local).updateMovie(dummyEntity, favorite)
        assertNotNull(dummyEntity.loved)
    }
}