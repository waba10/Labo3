package com.ayala.pdm_labo3.Adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ayala.pdm_labo3.Entity.Movie
import com.ayala.pdm_labo3.R
import kotlinx.android.synthetic.main.cardview_movie.view.*

class MovieAdapter internal constructor(context: Context) :  RecyclerView.Adapter<MovieAdapter.MovieViewHolder>
    ()  {

    private var games = emptyList<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieAdapter.MovieViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.cardview_movie, parent, false)
        return MovieViewHolder(itemView)
    }

    override fun getItemCount() = games.size

    override fun onBindViewHolder(holder: MovieAdapter.MovieViewHolder, position: Int) {
        holder.bind(games[position])

    }

    internal fun setMovies(lista: List<Movie>) {
        this.games = lista
        notifyDataSetChanged()
    }

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(movie: Movie) {
            with(itemView) {

                movie_title_cv.text=movie.title
                movie_rate_cv.text=movie.imdbRating
                movie_plot_cv.text=movie.plot
                movie_runtime_cv.text=movie.runtime

                /*this.setOnClickListener {
                    var mIntent = Intent(it.context,  SecondActivity:: class.java)
                    mIntent.putExtra("key_titulo", movie.title)

                    this.context.startActivity(mIntent)
                }*/

            }

        }
    }
}