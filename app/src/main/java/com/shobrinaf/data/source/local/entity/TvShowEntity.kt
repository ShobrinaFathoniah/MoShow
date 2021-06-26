package com.shobrinaf.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tvshowEntities")
data class TvShowEntity(
        @PrimaryKey
        @ColumnInfo(name = "tvShowId")
        var tvShowId: Int,
        @ColumnInfo(name = "title")
        var title: String,
        @ColumnInfo(name = "genres")
        var genres: String,
        @ColumnInfo(name = "episodes")
        var episodes: String,
        @ColumnInfo(name = "duration")
        var duration: String,
        @ColumnInfo(name = "description")
        var description: String,
        @ColumnInfo(name = "imagePath")
        var imagePath: String,
        @ColumnInfo(name = "loved")
        var loved: Boolean = false
)