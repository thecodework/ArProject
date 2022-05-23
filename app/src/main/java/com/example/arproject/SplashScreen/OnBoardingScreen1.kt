package com.example.arproject.SplashScreen

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.AnimationUtils.loadAnimation
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.arproject.LoginActivity
import com.example.arproject.R
import com.example.arproject.SignUpActivity

public class OnBoardingScreen1: AppCompatActivity(){

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.onboarding_screen1)

        val leftAnim = AnimationUtils.loadAnimation(this, R.anim.slide_in_left)
        val rightAnim = AnimationUtils.loadAnimation(this, R.anim.slide_out_right)

        val loginButton = findViewById<Button>(R.id.btnLogin)
        val signUpButton = findViewById<Button>(R.id.btnSignUpOnBoarding1)

        loginButton.startAnimation(leftAnim)
        signUpButton.startAnimation(rightAnim)


        loginButton.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)

        }

        signUpButton.setOnClickListener{
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }

}