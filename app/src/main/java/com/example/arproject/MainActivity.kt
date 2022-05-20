package com.example.arproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Slide
import android.transition.TransitionManager
import android.view.Gravity
import android.widget.Button
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewARButton = findViewById<Button>(R.id.btnViewAR)
        viewARButton.setOnClickListener{
            val intent = Intent(this, ViewARModelFragment::class.java)
            startActivity(intent)

        }
    }
}