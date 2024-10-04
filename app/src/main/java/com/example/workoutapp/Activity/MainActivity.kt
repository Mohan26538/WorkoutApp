package com.example.workoutapp.Activity

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
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

        val intent = Intent(this,WorkoutActivity::class.java)


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





}