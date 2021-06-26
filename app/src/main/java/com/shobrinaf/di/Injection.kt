package com.shobrinaf.di

import android.content.Context
import com.shobrinaf.data.source.EntertainmentRepository
import com.shobrinaf.data.source.local.LocalDataSource
import com.shobrinaf.data.source.local.room.EntertainmentDatabase
import com.shobrinaf.data.source.remote.RemoteDataSource
import com.shobrinaf.utils.AppExecutors
import com.shobrinaf.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): EntertainmentRepository {
        val database = EntertainmentDatabase.getInstance(context)
        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        val localDataSource = LocalDataSource.getInstance(database.entertainmentDao())
        val appExecutors = AppExecutors()
        return EntertainmentRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}