package com.ayala.pdm_labo3.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.ayala.pdm_labo3.Entity.Movie
import com.ayala.pdm_labo3.Repository.MovieRepository
import com.ayala.pdm_labo3.Room.MovieRoomDatabase
import kotlinx.coroutines.launch

class MovieViewModel(application : Application): AndroidViewModel(application) {

    private val repository: MovieRepository

    val allMovies: LiveData<List<Movie>>

    init{
        val MoviesDao = MovieRoomDatabase.getDatabase(application, viewModelScope).movieDao()
        repository= MovieRepository(MoviesDao)
        allMovies=repository.allMovies
    }

    fun insert(movie: Movie)= viewModelScope.launch{
        repository.insert(movie)

    }
    fun getAll(): LiveData<List<Movie>> = repository.getAll()
}