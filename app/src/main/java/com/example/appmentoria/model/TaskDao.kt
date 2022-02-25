package com.example.appmentoria.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    @Query("SELECT * FROM task_table ORDER BY name ASC")
    fun getAlphabetizedWords(): Flow<List<ToDo>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(name: ToDo)

    @Query("DELETE FROM task_table")
    suspend fun deleteAll()

}