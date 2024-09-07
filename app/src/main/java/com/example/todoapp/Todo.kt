package com.example.todoapp

import java.time.LocalDateTime

data class Todo(
    val ID: Int,
    val name: String,
    val content: String,
    val date: LocalDateTime = LocalDateTime.now()


)
