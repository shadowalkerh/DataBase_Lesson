package com.example.db2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class LessonAdapter (val lessonsList: List<Lesson>, val activity: MainActivity): RecyclerView.Adapter<LessonAdapter.LessonViewHolder>(){
    class LessonViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val tvLessonName = itemView.findViewById<TextView>(R.id.textName)
        val tvSTime = itemView.findViewById<TextView>(R.id.textSTime)
        val tvETime = itemView.findViewById<TextView>(R.id.textETime)
        val tvTeacher = itemView.findViewById<TextView>(R.id.textTeacher)
        val tvRoomNumber = itemView.findViewById<TextView>(R.id.textRoomNumber)
        val tvId = itemView.findViewById<TextView>(R.id.textId)
    }

    override fun onBindViewHolder(holder: LessonViewHolder, position: Int) {
        val currentLesson = lessonsList[position]
        holder.tvId.text = "${currentLesson.id}"
        holder.tvLessonName.text = currentLesson.name
        holder.tvSTime.text = currentLesson.startTime
        holder.tvETime.text = currentLesson.endTime
        holder.tvTeacher.text = currentLesson.teacher
        holder.tvRoomNumber.text = "${currentLesson.roomNumber} room"
    }

    override fun getItemCount(): Int {
        return lessonsList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.item_layout,parent,false)
        val viewHolder = LessonViewHolder(itemView)

        return viewHolder
    }
}