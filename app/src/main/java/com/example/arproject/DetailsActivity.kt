package com.example.arproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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
        binding.btnAR.setOnClickListener(View.OnClickListener {

        })
    }

    private fun initializer() {
        Utils.changeStatusBar(this, R.color.white_new)
        val pic: Int = intent.getIntExtra("image", 0)
        binding.imageItem.setImageResource(pic)
    }
}


