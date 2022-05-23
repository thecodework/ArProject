package com.example.arproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Slide
import android.transition.TransitionManager
import android.view.Gravity
import android.widget.Button
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import com.example.arproject.databinding.ActivityLoginBinding
import com.example.arproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.btnViewAR.setOnClickListener{
            val intent = Intent(this, ViewARModelFragment::class.java)
            startActivity(intent)

        }
    }
}