package com.example.arproject

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.arproject.databinding.ActivityDownloadBinding
import okhttp3.*
import java.io.*


class DownloadActivity : AppCompatActivity() {
    private val client = OkHttpClient()
    private val filepath = "MyFileStorage"
    var url: String =
        "https://drive.google.com/u/2/uc?id=1ZrVO6LdVIZS8kfMtQCcP4LmUNk2BlINj&export=download"
    var pdfurl: String = "https://www.hq.nasa.gov/alsj/a17/A17_FlightPlan.pdf"
    lateinit var binding: ActivityDownloadBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_download)
        setListener()
    }

    private fun setListener() {
        binding.btnDownload.setOnClickListener {
            downloadFile()
        }
    }

    private fun downloadFile() {
        val request = Request.Builder()
            .url(url)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {
                response.use {
                    if (!response.isSuccessful) throw IOException("Unexpected code $response")
                    val result = response.body?.byteStream()
                    result?.let {
                        writeResponse(it)
                    }
                }
            }
        })
    }

    fun writeResponse(inputStream: InputStream) {
        try {
            val fileReader = ByteArray(4096)
            var fileSize = 0
            val myExternalFile = File(getExternalFilesDir(filepath), "model.glb")
            val fileOutPutStream = FileOutputStream(myExternalFile)
            val fos: OutputStream = fileOutPutStream
            do {
                val read = inputStream.read(fileReader)
                if (read != -1) {
                    fos.write(fileReader, 0, read)
                    fileSize += read
                }
            } while (read != -1)
            fos.flush()
            fos.close()
        } catch (e: IOException) {
            Log.d("check", e.message.toString())
        }
    }
}