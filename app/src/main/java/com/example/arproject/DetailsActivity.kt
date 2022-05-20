package com.example.arproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.arproject.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initializer()
        setListener()
    }

    private fun setListener() {
        binding.btnAR.setOnClickListener {
        }
    }

    private fun initializer() {
        Utils.changeStatusBar(this, R.color.white_new)
        val pic: Int = intent.getIntExtra("image", 0)
        binding.imageItem.setImageResource(pic)
    }
}