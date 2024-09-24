package com.example.workoutapp.Domain

import java.io.Serializable

data class Lesson(
    var title:String,
    var duration:String,
    var Link:String,
    var picPath:String
) : Serializable
