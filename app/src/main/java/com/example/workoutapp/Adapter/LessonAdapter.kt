package com.example.workoutapp.Adapter

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.workoutapp.Activity.WorkoutActivity
import com.example.workoutapp.Domain.Lesson
import com.example.workoutapp.databinding.ViewholderExerciseBinding

class LessonAdapter (private val  listofLesson: List<Lesson>):RecyclerView.Adapter<LessonAdapter.LessonViewHolder>() {

    inner class  LessonViewHolder(private val binding:ViewholderExerciseBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(lesson: Lesson) {
            binding.titletxt.text= lesson.title
            binding.durationtxt.text=lesson.duration


            binding.picpath.setImageDrawable(ContextCompat.getDrawable(/* context = */ binding.root.context,/* id = */
                lesson.picPath.toInt()))



            binding.root.setOnClickListener(){
                val context = binding.root.context
                val youtubeintent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=${lesson.Link}"))
                context.startActivity(youtubeintent)
            }


        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonViewHolder {
        val binding = ViewholderExerciseBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return LessonViewHolder(binding)
    }

    override fun getItemCount(): Int = listofLesson.size

    override fun onBindViewHolder(holder: LessonViewHolder, position: Int) {
        holder.bind(listofLesson[position])
    }
}