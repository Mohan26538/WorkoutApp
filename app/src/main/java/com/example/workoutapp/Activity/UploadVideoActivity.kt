package com.example.workoutapp.Activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.workoutapp.Retrofit.RetrofitClient
import com.example.workoutapp.Retrofit.UploadResponse // Import your response class
import com.example.workoutapp.databinding.ActivityUploadVideoBinding
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File

class UploadVideoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUploadVideoBinding
    private lateinit var videoPickerLauncher: ActivityResultLauncher<Intent>
    private var selectedVideoUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityUploadVideoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        videoPickerLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val data = result.data
                selectedVideoUri = data?.data
                binding.selectedVideoTextView.text = selectedVideoUri.toString()
            }
        }

        binding.selectVideoButton.setOnClickListener {
            openVideoPicker()
        }

        binding.uploadButton.setOnClickListener {
            selectedVideoUri?.let {
                uploadVideo(it)
            }
        }
    }

    private fun uploadVideo(videoUri: Uri) {
        val file = File(getPathFromUri(videoUri))
        val requestFile = RequestBody.create("video/*".toMediaTypeOrNull(), file)
        val videoPart = MultipartBody.Part.createFormData("video", file.name, requestFile)

        RetrofitClient.instance.uploadVideo(videoPart).enqueue(object : Callback<UploadResponse> {
            override fun onResponse(call: Call<UploadResponse>, response: Response<UploadResponse>) {
                if (response.isSuccessful) {
                    binding.uploadStatusTextView.text = "Upload Successful: ${response.body()?.message}"
                } else {
                    binding.uploadStatusTextView.text = "Upload Failed: ${response.message()}"
                }
            }

            override fun onFailure(call: Call<UploadResponse>, t: Throwable) {
                binding.uploadStatusTextView.text = "Error: ${t.message}"
            }
        })
    }

    private fun getPathFromUri(uri: Uri): String {
        val cursor = contentResolver.query(uri, null, null, null, null)
        cursor?.use {
            val index = it.getColumnIndex("_data")
            if (it.moveToFirst() && index != -1) {
                return it.getString(index)
            }
        }
        throw IllegalArgumentException("Cannot find path for: $uri") // Error handling
    }

    private fun openVideoPicker() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "video/*"
        videoPickerLauncher.launch(intent)
    }
}
