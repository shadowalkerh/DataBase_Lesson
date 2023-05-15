package com.example.db2

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Lesson::class], version = 1)
abstract class LessonDatabase : RoomDatabase() {
    abstract fun lessonDao(): LessonDao
}