package com.ayala.pdm_labo3.Repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.ayala.pdm_labo3.DAO.MovieDao
import com.ayala.pdm_labo3.Entity.Movie


class MovieRepository(private val movieDao: MovieDao) {

    val allMovies: LiveData<List<Movie>> = movieDao.getAllMovies()

    @WorkerThread
    suspend fun insert(movie: Movie){
        movieDao.insertMovie(movie)
    }
    fun getAll(): LiveData<List<Movie>> = movieDao.getAllMovies()
}