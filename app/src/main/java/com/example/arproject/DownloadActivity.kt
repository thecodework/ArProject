package com.example.arproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.arproject.databinding.ActivityDownloadBinding
import okhttp3.*
import java.io.IOException

class DownloadActivity : AppCompatActivity() {
    private val client = OkHttpClient()
    lateinit var binding: ActivityDownloadBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_download)
        initializer()
        setListener()
    }

    private fun setListener() {
        binding.btnDownload.setOnClickListener {
            downloadFile()
        }
    }

    private fun downloadFile() {
        val request = Request.Builder()
            .url("http://publicobject.com/helloworld.txt")
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {
                response.use {
                    if (!response.isSuccessful) throw IOException("Unexpected code $response")

                    for ((name, value) in response.headers) {
                        println("$name: $value")
                    }
                    println(response.body!!.string())
                }
            }
        })
    }

    private fun initializer() {

    }
}