package com.ayala.pdm_labo3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ayala.pdm_labo3.Adapters.MovieAdapter
import com.ayala.pdm_labo3.ViewModel.MovieViewModel
import kotlinx.android.synthetic.main.movie_list_fragment.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //En esta línea solo cambia rv_movies_list por el xml donde pongas el recycler
        val recyclerView = findViewById(R.id.movie_list_rv ) as RecyclerView
        val adapter = MovieAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        val viewModel = MovieViewModel(application)
        viewModel.allMovies.observe(this, Observer {
            movie -> movie?.let { adapter.setMovies(it) }
        })
    }
}
