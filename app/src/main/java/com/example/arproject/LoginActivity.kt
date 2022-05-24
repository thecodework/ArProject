package com.example.arproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.adapters.ViewGroupBindingAdapter.setListener
import com.example.arproject.Utils.Companion.changeStatusBar
import com.example.arproject.Utils.Companion.isValidEmail
import com.example.arproject.Utils.Companion.isValidPassword
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
            val password = binding.edPassword.getText().toString().trim()
            val email = binding.edEmail.getText().toString().trim()
            if (isValidEmail(email)) {
                if (isValidPassword(password)) {
                    if (password.length > 6) {
                        val intent = Intent(this, DashboardActivity::class.java)
                        startActivity(intent)
                        Toast.makeText(this, "Valid", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(
                            this,
                            "Password should be greater than 6 digit",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                } else {
                    Toast.makeText(
                        this,
                        "Password should be Strong",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            } else {
                Toast.makeText(this, "Enter valid emailid", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun initializer() {

    }

}