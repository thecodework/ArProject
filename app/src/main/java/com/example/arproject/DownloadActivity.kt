package com.example.arproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.adapters.ViewGroupBindingAdapter.setListener
import com.example.arproject.databinding.ActivityDownloadBinding

class DownloadActivity : AppCompatActivity() {
    lateinit var binding: ActivityDownloadBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_download)
        initailizer()
        setListener()
    }

    private fun setListener() {
        binding.btnDownload.setOnClickListener(View.OnClickListener {

        })
    }

    private fun initailizer() {
        TODO("Not yet implemented")
    }
}