package com.example.todoapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [Todo::class], version = 1)
@TypeConverters(Converters::class)

abstract class AppDatabase:RoomDatabase() {

    abstract fun todoDao():TodoDao

    companion object{
        private var instance:AppDatabase?=null
        fun getDatabase(context: Context):AppDatabase{
            return instance?: synchronized(this){
                val localInstance= Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "Todo_Database"
                ).fallbackToDestructiveMigration().build()
                instance=localInstance
                localInstance
            }
        }
    }

}