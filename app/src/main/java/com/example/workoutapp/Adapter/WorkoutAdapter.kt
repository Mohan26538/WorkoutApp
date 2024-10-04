package com.example.workoutapp.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.workoutapp.Activity.WorkoutActivity
import com.example.workoutapp.Domain.Workout
import com.example.workoutapp.databinding.ViewholderWorkoutBinding

class WorkoutAdapter(private val listofworkout: List<Workout>) : RecyclerView.Adapter<WorkoutAdapter.WorkoutViewHolder>() {

    inner class WorkoutViewHolder(private val binding: ViewholderWorkoutBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(workout:Workout){
            binding.titletxt.text=workout.title
            binding.durationtxt.text=workout.duration
            binding.Kcaltxt.text="${workout.Kcal} Kcal"

            binding.pic.setImageDrawable(ContextCompat.getDrawable(binding.root.context, workout.picPath))




            binding.root.setOnClickListener{
                val context = binding.root.context
                val intent= Intent(context,WorkoutActivity::class.java)
                intent.putExtra("object",workout)
               context.startActivity(intent)
            }






        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkoutViewHolder {
        val binding = ViewholderWorkoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return WorkoutViewHolder(binding)
    }

    override fun getItemCount(): Int = listofworkout.size

    override fun onBindViewHolder(holder: WorkoutViewHolder, position: Int) {
        holder.bind(listofworkout[position])
    }
}