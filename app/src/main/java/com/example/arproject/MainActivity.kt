package com.example.arproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Slide
import android.transition.TransitionManager
import android.view.Gravity
import android.widget.Button
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {
    lateinit var btnSlideLeft: Button
    lateinit var btnSlideRight: Button
    lateinit var linearLayout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnSlideLeft = findViewById(R.id.btnSlideLeft)
        btnSlideRight = findViewById(R.id.btnSlideRight)
        linearLayout = findViewById(R.id.linearLayout)

        btnSlideLeft.setOnClickListener {
            val slide = Slide()
            slide.slideEdge = Gravity.START
            TransitionManager.beginDelayedTransition(linearLayout, slide)
            //textView.visibility = View.VISIBLE
        }
        btnSlideRight.setOnClickListener {
            val slide = Slide()
            slide.slideEdge = Gravity.END
            TransitionManager.beginDelayedTransition(linearLayout, slide)
            //textView1.visibility = View.VISIBLE
        }
    }
}