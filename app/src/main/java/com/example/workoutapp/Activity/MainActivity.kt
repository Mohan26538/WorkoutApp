package com.example.workoutapp.Activity

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.workoutapp.Adapter.WorkoutAdapter
import com.example.workoutapp.Domain.Lesson
import com.example.workoutapp.Domain.Workout
import com.example.workoutapp.R
import com.example.workoutapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )




        binding.view1.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.view1.adapter = WorkoutAdapter(getData())

    }

    private fun getData() : MutableList<Workout> {
            val list = mutableListOf<Workout>()
            list.add(Workout("Running","You just woke up.It is a brand new day. The canvas is blank.How do you begin?",R.drawable.pic_1,"160","9 min",
                mutableListOf()
            ))
            list.add(Workout("Streching","You just woke up.It is a brand new day. The canvas is blank.How do you begin?",R.drawable.pic_2,"230","85 min",
                mutableListOf()
            ))
            list.add(Workout("Yoga","You just woke up.It is a brand new day. The canvas is blank.How do you begin?",R.drawable.pic_3,"180","65 min",
                mutableListOf()
            ))
            return list
        }


    private fun getLessonForWorkout3(): List<Lesson> {
        val list = mutableListOf<Lesson>()

        list.add(Lesson("Lesson 1","23:00","v7AYKMP6rOE","pic_3_1"))
        list.add(Lesson("Lesson 2","27:00","Eml2xnoLpYE","pic_3_2"))
        list.add(Lesson("Lesson 3","25:00","v7SN-d4qXx0","pic_3_3"))
        list.add(Lesson("Lesson 4","21:00","LqXZ628YNj4","pic_3_4"))
        return list

    }

    private fun getLessonForWorkout2(): List<Lesson> {
        val list = mutableListOf<Lesson>()

        list.add(Lesson("Lesson 1","20:23","v7AYKMP6rOE","pic_2_1"))
        list.add(Lesson("Lesson 2","18:27","47ExgzO7Flu","pic_2_2"))
        list.add(Lesson("Lesson 3","32:25","OmLx8tmaQ-4","pic_2_3"))
        list.add(Lesson("Lesson 4","07:52","w86EalEoFRY","pic_2_4"))
        return list

    }

    private fun getLessonForWorlout1(): List<Lesson> {
        val list = mutableListOf<Lesson>()

        list.add(Lesson("Lesson 1","20:23","v7AYKMP6rOE","pic_1_1"))
        list.add(Lesson("Lesson 2","18:27","47ExgzO7Flu","pic_1_2"))
        list.add(Lesson("Lesson 3","32:25","OmLx8tmaQ-4","pic_1_3"))

        return list

    }



}