package com.example.taskly.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.taskly.data.model.Task

@Dao
interface TaskDao {
    @Query("SELECT * FROM tasks ORDER BY deadline DESC")
    fun getAllTasks(): LiveData<List<Task>>

    @Query("SELECT * FROM tasks")
    suspend fun getAllTasksList(): List<Task>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task: Task)

    @Delete
    suspend fun deleteTask(task: Task)

    @Update
    suspend fun updateTask(task: Task)
}