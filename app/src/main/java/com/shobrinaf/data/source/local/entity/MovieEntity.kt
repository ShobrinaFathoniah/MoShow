package com.shobrinaf.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movieEntities")
data class MovieEntity(
        @PrimaryKey
        @ColumnInfo(name = "movieId")
        var movieId: Int,
        @ColumnInfo(name = "title")
        var title: String,
        @ColumnInfo(name = "releaseTime")
        var releaseTime: String,
        @ColumnInfo(name = "genres")
        var genres: String,
        @ColumnInfo(name = "duration")
        var duration: String,
        @ColumnInfo(name = "description")
        var description: String,
        @ColumnInfo(name = "imagePath")
        var imagePath: String,
        @ColumnInfo(name = "loved")
        var loved: Boolean = false
)