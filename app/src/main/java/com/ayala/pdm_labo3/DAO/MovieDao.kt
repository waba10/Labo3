package com.ayala.pdm_labo3.DAO

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ayala.pdm_labo3.Entity.Movie

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movie: Movie)

    @Query("SELECT * FROM movie_table")
    fun getAllMovies(): LiveData<List<Movie>>

    @Query("SELECT * FROM movie_table WHERE id = :id")
    fun getMovie(id: Long): LiveData<List<Movie>>


    @Query("SELECT * FROM movie_table WHERE title = :title")
    fun getMovie(title: Int): LiveData<List<Movie>>


    @Query("DELETE FROM MOVIE_TABLE")
    fun delete()
}