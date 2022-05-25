package com.example.arproject

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
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
                            Utils.showDialog(this, "Register Successfully")
                        } else {
                            Utils.showDialog(this, "Password should be greater than 6 digit")
                        }
                    } else {
                        Utils.showDialog(
                            this,
                            "Password should be contain one capital letter,one symbol & one number"
                        )
                    }
                } else {
                    Utils.showDialog(this, "Enter valid emailId")
                }
            } else {
                Utils.showDialog(this, "Enter Field")
            }
        }
    }
}