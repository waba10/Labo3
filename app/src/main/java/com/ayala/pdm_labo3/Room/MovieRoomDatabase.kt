package com.ayala.pdm_labo3.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.ayala.pdm_labo3.DAO.MovieDao
import com.ayala.pdm_labo3.Entity.Movie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@Database(entities = [Movie::class], version = 1, exportSchema = false)
abstract class MovieRoomDatabase: RoomDatabase() {

    abstract fun movieDao(): MovieDao

    companion object {
        @Volatile
        private var INSTANCE: MovieRoomDatabase?=null

        fun getDatabase(context: Context, scope: CoroutineScope): MovieRoomDatabase {

            return INSTANCE ?: synchronized(this){
                val instance= Room.databaseBuilder(
                    context.applicationContext,
                    MovieRoomDatabase::class.java,
                    "Book_database"
                )
                    .fallbackToDestructiveMigration()
                    .addCallback(DatabseCall(scope))
                    .build()
                INSTANCE= instance
                instance
            }

        }
    }

    private class DatabseCall(private val scope: CoroutineScope) : RoomDatabase.Callback() {
        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)

            INSTANCE?.let { appDatabase ->
                scope.launch(Dispatchers.IO) {
                    LlenarDB(appDatabase.movieDao())
                }
            }
        }

        suspend fun LlenarDB(movieDAO: MovieDao) {
            val movie = Movie("Asd","asd","asd","asd","asd","asd","asd","asd","asd","asd","asd")
            movieDAO.insertMovie(movie)
            //Para probar que funcione agrega unas peliculas acá para que asi se llene la base de datos
            //y por ende el recycler para que te las muestre
            //Esperame un momento xD
        }
    }




}