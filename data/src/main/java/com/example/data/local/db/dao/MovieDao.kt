package com.example.data.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.model.MovieEntity
import io.reactivex.Single

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(userEntity: MovieEntity)

    @Query("SELECT * FROM movie WHERE id = :id")
    fun findMovieById(id: String): Single<MovieEntity>
}
