package com.ayala.pdm_labo3.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie_table")
data class Movie (

    @ColumnInfo(name = "title")  val title: String = "N/A",

    @ColumnInfo(name = "year")  val year: String = "N/A",

    @ColumnInfo(name = "released")  val released: String = "N/A",

    @ColumnInfo(name = "runtime")  val runtime: String = "N/A",

    @ColumnInfo(name = "genre")  val genre: String = "N/A",

    @ColumnInfo(name = "director")  val director: String = "N/A",

    @ColumnInfo(name = "actors")  val actors: String = "N/A",

    @ColumnInfo(name = "plot")  val plot: String = "N/A",

    @ColumnInfo(name = "language")  val language: String = "N/A",

    @ColumnInfo(name = "imdbRating")  val imdbRating: String = "N/A",

    @ColumnInfo(name = "poster")  val poster: String = "N/A"


){
    @PrimaryKey(autoGenerate = true) var id :Long = 0
}