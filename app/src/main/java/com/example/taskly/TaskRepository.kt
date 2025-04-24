package com.example.taskly

import androidx.lifecycle.LiveData
import com.example.taskly.data.db.TaskDao
import com.example.taskly.data.model.Task

class TaskRepository(private val taskDao: TaskDao) {
    val allTasks: LiveData<List<Task>> = taskDao.getAllTasks()

    suspend fun insert(task: Task) = taskDao.insertTask(task)
    suspend fun delete(task: Task) = taskDao.deleteTask(task)
    suspend fun update(task: Task) = taskDao.updateTask(task)
    suspend fun getAllTasksAsList(): List<Task> {
        return taskDao.getAllTasksList()
    }
}