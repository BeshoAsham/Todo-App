package com.example.todoapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TodoViewModel(application: Application):AndroidViewModel(application) {

    private val todoRepo:TodoRepo
    val todoList:LiveData<List<Todo>>
    init {
        val todoDao=AppDatabase.getDatabase(application).todoDao()
        todoRepo=TodoRepo(todoDao)
        todoList=todoRepo.allUser
    }
    fun insertTodo(todo: Todo)=viewModelScope.launch {
        todoRepo.insertTodo(todo)
    }
    fun updateTodo(todo: Todo)=viewModelScope.launch {
        todoRepo.updateTodo(todo)
    }
    fun deleteTodo(todo: Todo)=viewModelScope.launch {
        todoRepo.deleteTodo(todo)
    }
}