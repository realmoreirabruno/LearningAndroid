package com.example.appmentoria.model

import androidx.lifecycle.LiveData
import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    @Query("SELECT * FROM task_table ORDER BY name ASC")
    fun getAlphabetizedWords(): LiveData<List<Task>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(name: Task)

    @Query("DELETE FROM task_table")
    suspend fun deleteAll()

    @Delete
    fun delete(todo: Task)

}