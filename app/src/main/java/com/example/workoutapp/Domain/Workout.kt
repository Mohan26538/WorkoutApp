package com.example.workoutapp.Domain

import java.io.Serializable

data class Workout(
    var title:String,
    var description:String,
    var picPath:Int,
    var Kcal:String,
    var duration:String,
    var lessons : MutableList<Lesson>
) : Serializable
