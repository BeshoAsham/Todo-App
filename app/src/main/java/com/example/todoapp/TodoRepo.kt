package com.example.todoapp

import androidx.lifecycle.LiveData

class TodoRepo (private val todoDao: TodoDao){
    val allUser:LiveData<List<Todo>> = todoDao.getAllTodo()

    suspend fun insertTodo(todo: Todo){
        todoDao.insertTodo(todo)
    }

    suspend fun updateTodo(todo: Todo){
        todoDao.updateTodo(todo)
    }
    suspend fun deleteTodo(todo: Todo){
        todoDao.deleteTodo(todo)
    }

}