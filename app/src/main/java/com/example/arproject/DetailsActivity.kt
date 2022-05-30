package com.example.arproject

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.arproject.databinding.ActivityDetailsBinding
import com.example.arproject.utils.Utils


class DetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_details)
        initializer()
        setListener()
    }

    private fun setListener() {
        binding.btnAR.setOnClickListener {
            val intent = Intent(this, ViewARModelActivity::class.java)
            startActivity(intent)
        }
        binding.imageBack.setOnClickListener {
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initializer() {
        Utils.changeStatusBar(this, R.color.white_new)
        val pic: Int = intent.getIntExtra("image", 0)
        binding.imageItem.setImageResource(pic)
    }
}