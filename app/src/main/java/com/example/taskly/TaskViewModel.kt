package com.example.taskly

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.taskly.data.db.TaskDatabase
import com.example.taskly.data.model.Task
import kotlinx.coroutines.launch

class TaskViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: TaskRepository
    private val _allTasks = MutableLiveData<List<Task>>()
    val allTasks: LiveData<List<Task>> get() = _allTasks

    init {
        val dao = TaskDatabase.getDatabase(application).taskDao()
        repository = TaskRepository(dao)
        refreshTasks()
    }

    fun insert(task: Task) = viewModelScope.launch {
        repository.insert(task)
        refreshTasks() // <-- ini yang penting
    }

    fun delete(task: Task) = viewModelScope.launch {
        repository.delete(task)
        refreshTasks()
    }

    fun update(task: Task) = viewModelScope.launch {
        repository.update(task)
        refreshTasks()
    }

    fun refreshTasks() = viewModelScope.launch {
        _allTasks.value = repository.getAllTasksAsList()
    }

    fun sortByDeadline() {
        _allTasks.value = _allTasks.value?.sortedBy { it.deadline }
    }

    fun sortByStatus() {
        _allTasks.value = _allTasks.value?.sortedBy { it.isDone }
    }
}