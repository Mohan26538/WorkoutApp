package com.example.workoutapp.Retrofit

import retrofit2.Call
import okhttp3.MultipartBody
import okhttp3.Response
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import okhttp3.ResponseBody as ResponseBody1

data class UploadResponse(
    val success: Boolean,
    val message: String
)


interface ApiService {
    @Multipart
    @POST("/upload")
    fun uploadVideo (
        @Part video : MultipartBody.Part
    ): Call<UploadResponse>

}