package com.example.arproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.arproject.databinding.ActivityMainBinding
import com.example.arproject.databinding.ActivitySignupBinding

class SignUpActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_signup)

        binding.btnCreateAccount.setOnClickListener {
            val password = binding.edPassword.text.toString().trim()
            val email = binding.edEmail.text.toString().trim()
            val name = binding.edName.text.toString().trim()
            if (password.isNotEmpty() && email.isNotEmpty() && name.isNotEmpty()) {
                if (Utils.isValidEmail(email)) {
                    if (Utils.isValidPassword(password)) {
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
                    Toast.makeText(this, "Enter valid emailId", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Enter field", Toast.LENGTH_SHORT).show()
            }
        }
    }
}