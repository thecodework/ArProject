package com.example.arproject

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.arproject.Utils.Companion.isValidEmail
import com.example.arproject.Utils.Companion.isValidPassword
import com.example.arproject.Utils.Companion.showDialog
import com.example.arproject.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        initializer()
        setListener()
    }

    private fun setListener() {
        binding.btnLoginActivity.setOnClickListener {
            val password = binding.edPassword.text.toString().trim()
            val email = binding.edEmail.text.toString().trim()
            if (password.isNotEmpty() && email.isNotEmpty()) {
                if (isValidEmail(email)) {
                    if (isValidPassword(password)) {
                        if (password.length > 6) {
                            val intent = Intent(this, DashboardActivity::class.java)
                            startActivity(intent)
                            showDialog(this, "Login Successfully")
                        } else {
                            showDialog(this, "Password should be greater than 6 digit")
                        }
                    } else {
                        showDialog(
                            this,
                            "Password should be contain one capital letter,one symbol & one number"
                        )
                    }
                } else {
                    showDialog(this, "Enter valid emailId")
                }
            } else {
                showDialog(this, "Enter valid Email & Password")
            }
        }
    }

    private fun initializer() {
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
    }
}