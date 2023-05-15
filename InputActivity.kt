package com.example.db2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.room.Room
import java.util.*

class InputActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)

        val etID = Date().time.toInt()
        val etName = findViewById<EditText>(R.id.etName)
        val etSTime = findViewById<EditText>(R.id.etSTime)
        val etETime = findViewById<EditText>(R.id.etETime)
        val etTeacher = findViewById<EditText>(R.id.etTeacher)
        val etRoomNumber = findViewById<EditText>(R.id.etRoomNumber)
        val btnOK = findViewById<Button>(R.id.btnOK)

//        val db = Room.databaseBuilder(
//            applicationContext,
//            LessonDatabase::class.java, "lessons_db"
//        )
//            .allowMainThreadQueries()
//            .build()

        btnOK.setOnClickListener {
            val newLesson = Lesson(
                etID,
                etName.text.toString(),
                etSTime.text.toString(),
                etETime.text.toString(),
                etTeacher.text.toString(),
                etRoomNumber.text.toString()
            )
            val retIntent = Intent()
            retIntent.putExtra("newlesson", newLesson)
            setResult(RESULT_OK, retIntent)
            finish()
        }
    }
}