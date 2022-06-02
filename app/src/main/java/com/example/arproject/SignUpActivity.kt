package com.example.arproject

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.arproject.databinding.ActivitySignupBinding
import com.example.arproject.utils.ProgressDialog
import com.example.arproject.utils.Utils

class SignUpActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignupBinding
    private var pDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_signup)
        initializer()
        setListener()
        pDialog = ProgressDialog(this)
    }

    private fun initializer() {
        Utils.hideStatusBar(binding.tvfurnish)
    }

    private fun setListener() {
        binding.btnCreateAccount.setOnClickListener {
            pDialog!!.showProgressDialog()
            val password = binding.edPassword.text.toString().trim()
            val email = binding.edEmail.text.toString().trim()
            val name = binding.edName.text.toString().trim()
            if (password.isNotEmpty() && email.isNotEmpty() && name.isNotEmpty()) {
                if (Utils.isValidEmail(email)) {
                    if (Utils.isValidPassword(password)) {
                        if (password.length > 8) {
                            Handler(Looper.getMainLooper()).postDelayed({
                                val intent = Intent(this, LoginActivity::class.java)
                                pDialog!!.hideProgressDialog()
                                startActivity(intent)
                            }, 1000)
                        } else {
                            Utils.showDialog(this, "Password should be greater than 8 digit")
                            pDialog!!.hideProgressDialog()
                        }
                    } else {
                        Utils.showDialog(this, "Password should be in Alphanumeric pattern")
                        pDialog!!.hideProgressDialog()
                    }
                } else {
                    Utils.showDialog(this, "Enter valid emailId")
                    pDialog!!.hideProgressDialog()
                }
            } else {
                Utils.showDialog(this, "Enter valid Email & Password")
                pDialog!!.hideProgressDialog()
            }
        }
    }
}