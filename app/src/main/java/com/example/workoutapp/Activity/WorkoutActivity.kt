package com.example.workoutapp.Activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.view.WindowManager
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.workoutapp.Adapter.LessonAdapter
import com.example.workoutapp.Domain.Lesson
import com.example.workoutapp.Domain.Workout
import com.example.workoutapp.R
import com.example.workoutapp.databinding.ActivityWorkoutBinding

class WorkoutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWorkoutBinding
    private lateinit var lessonAdapter: LessonAdapter
    private lateinit var lessonlist:List<Lesson>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityWorkoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        val workout = intent.getSerializableExtra("object") as? Workout





        workout?.let {

            binding.titletxt.text=workout.title
            binding.descriptiontxt.text= workout.description
            binding.pic.setImageDrawable(ContextCompat.getDrawable(binding.root.context,workout.picPath))


        }

        binding.backBtn.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)

        }

        val workouttitle = intent.getStringExtra("workout_title") ?: "default"

        lessonlist = when(workouttitle){
            "Workout 1" -> getLessonForWorlout1()
            "Workout 2" -> getLessonForWorkout2()
            "Workout 3" -> getLessonForWorkout3()
            else -> emptyList()
        }


        lessonAdapter = LessonAdapter(lessonlist)
        binding.view3.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.view3.adapter = this.lessonAdapter












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