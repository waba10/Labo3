package com.ayala.pdm_labo3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ayala.pdm_labo3.Adapters.MovieAdapter
import com.ayala.pdm_labo3.ViewModel.MovieViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //En esta línea solo cambia rv_movies_list por el xml donde pongas el recycler
        val recyclerView = findViewById<RecyclerView>(R.id.rv_movies_list)
        val adapter = MovieAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)


        val viewModel = ViewModelProviders.of(this).get(MovieViewModel::class.java)

        viewModel.getAll().observe(this, Observer { books ->
            books?.let { adapter.setMovies(it) }
        })
    }
}
