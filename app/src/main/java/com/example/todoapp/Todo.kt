package com.example.todoapp

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Date
import java.time.LocalDateTime
@Entity(tableName = "todo_table")
data class Todo(
   @PrimaryKey(autoGenerate = true) val id: Int=0,
    val name: String,
    val content: String,
    val date: LocalDateTime  = LocalDateTime.now()


)
