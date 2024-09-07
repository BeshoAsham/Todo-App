package com.example.todoapp

import androidx.room.TypeConverter
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Converters {

    @TypeConverter
    fun fromTimestamp(value: String?): LocalDateTime? {
        return value?.let {
            LocalDateTime.parse(it, DateTimeFormatter.ISO_DATE_TIME)
        }
    }

    @TypeConverter
    fun dateToTimestamp(date: LocalDateTime?): String? {
        return date?.format(DateTimeFormatter.ISO_DATE_TIME)
    }
}
