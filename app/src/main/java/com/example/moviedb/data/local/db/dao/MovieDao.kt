package com.example.moviedb.data.local.db.dao

import androidx.room.*
import com.example.moviedb.data.model.Movie
import io.reactivex.Single

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(movie: Movie?)

    @Query("SELECT * FROM movie WHERE id = :id")
    fun getMovieById(id: String): Single<Movie>

    @Query("SELECT * FROM movie")
    fun getMovies(): Single<List<Movie>>

    @Delete
    fun removeMovie(movie: Movie)

    @Query("DELETE FROM movie WHERE id = :id")
    fun removeMovieById(id: String?)

    @Query("SELECT COUNT(*) FROM movie WHERE id = :id")
    fun countMovie(id: String?): Int
}
