package com.example.appmentoria.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

//TODO: app doesn't run because of it..

class TaskViewModelFactory (private val repository: TaskRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TaskViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TaskViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}