package com.example.db2

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface LessonDao {
    @Query("SELECT * FROM lessons")
    fun getAllLessons(): List<Lesson>

    @Query("SELECT * FROM lessons WHERE name LIKE :lesson_name LIMIT 1")
    fun findByName(lesson_name: String): Lesson

    @Insert
    fun insertNewLesson(lesson: Lesson)

    @Query("DELETE FROM lessons")
    fun deleteAllLessons()
}