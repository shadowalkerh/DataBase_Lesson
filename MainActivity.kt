package com.example.db2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import java.util.*

class MainActivity : AppCompatActivity() {
    val lessons = mutableListOf<Lesson>()
    lateinit var lessonRecyclerView: RecyclerView

    val REQUEST_INPUT = 10
    lateinit var dao: LessonDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //lessons.add(Lesson("001","math","08:00","10:00","Tom","120"))

        //val TView = findViewById<RecyclerView>(R.id.recyclerView)
        val btnShow = findViewById<Button>(R.id.btnShowAll)
        val btnAdd = findViewById<Button>(R.id.btnAddNewLesson)
        val btnDelete = findViewById<Button>(R.id.btnDeleteAll)

        lessonRecyclerView = findViewById(R.id.recyclerView)
        lessonRecyclerView.adapter = LessonAdapter(lessons,this)
        lessonRecyclerView.layoutManager = LinearLayoutManager(this)

        val db = Room.databaseBuilder(
            applicationContext,
            LessonDatabase::class.java, "lessons_db"
        )
            .allowMainThreadQueries()
            .build()

        dao = db.lessonDao()
        btnShow.setOnClickListener {
            val newLesson = dao.getAllLessons()
            lessons.clear()
            lessons.addAll(newLesson)
            lessonRecyclerView.adapter?.notifyDataSetChanged()
        }

        btnAdd.setOnClickListener {
            val inIntent = Intent (this, InputActivity::class.java)
            startActivityForResult(inIntent,REQUEST_INPUT)
        }

        btnDelete.setOnClickListener {
            dao.deleteAllLessons()
            lessons.clear()
            lessonRecyclerView.adapter?.notifyDataSetChanged()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_INPUT && resultCode == RESULT_OK){
            val newLesson = data!!.getParcelableExtra<Lesson>("newlesson")
            lessons.add(newLesson!!)
            dao.insertNewLesson(newLesson)
            lessonRecyclerView.adapter?.notifyItemInserted(lessons.lastIndex)
        }
    }
}