package com.shobrinaf.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.shobrinaf.data.source.local.entity.MovieEntity
import com.shobrinaf.data.source.local.entity.TvShowEntity

@Database(entities = [MovieEntity::class, TvShowEntity::class],
        version = 1,
        exportSchema = false)
abstract class EntertainmentDatabase : RoomDatabase() {
    abstract fun entertainmentDao(): EntertainmentDao

    companion object {

        @Volatile
        private var INSTANCE: EntertainmentDatabase? = null

        fun getInstance(context: Context): EntertainmentDatabase =
                INSTANCE ?: synchronized(this) {
                    Room.databaseBuilder(
                            context.applicationContext,
                            EntertainmentDatabase::class.java,
                            "entertainments.db"
                    ).build().apply {
                        INSTANCE = this
                    }
                }
    }
}