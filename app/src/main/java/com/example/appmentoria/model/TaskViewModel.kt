package com.example.appmentoria.model

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.launch

class TaskViewModel (application: Application) : AndroidViewModel(application) {

    // Using LiveData and caching what allWords returns has several benefits:
    // - We can put an observer on the data (instead of polling for changes) and only update the
    //   the UI when the data actually changes.
    // - Repository is completely separated from the UI through the ViewModel.

    val task_repository : TaskRepository = TaskRepository(application)

    val allTasks: LiveData<List<Task>> = task_repository.allTasks

    /**
     * Launching a new coroutine to insert the data in a non-blocking way
     */
    fun insert(name: Task) = viewModelScope.launch {
        task_repository.insert(name)
    }

    fun deleteAll() = viewModelScope.launch {
    }

//    class TaskViewModelFactory(private val repository: TaskRepository) : ViewModelProvider.Factory {
//        override fun <T : ViewModel> create(modelClass: Class<T>): T {
//            if (modelClass.isAssignableFrom(TaskViewModel::class.java)) {
//                @Suppress("UNCHECKED_CAST")
//                return TaskViewModel(repository) as T
//            }
//            throw IllegalArgumentException("Unknown ViewModel class")
//        }

}
