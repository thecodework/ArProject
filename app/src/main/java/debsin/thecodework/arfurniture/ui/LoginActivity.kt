package debsin.thecodework.arfurniture.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import debsin.thecodework.arfurniture.R
import debsin.thecodework.arfurniture.databinding.ActivityLoginBinding
import debsin.thecodework.arfurniture.utils.ProgressDialog
import debsin.thecodework.arfurniture.utils.Utils
import debsin.thecodework.arfurniture.utils.Utils.Companion.isValidEmail
import debsin.thecodework.arfurniture.utils.Utils.Companion.isValidPassword
import debsin.thecodework.arfurniture.utils.Utils.Companion.showDialog

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding
    private var pDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        initializer()
        setListener()
        pDialog = ProgressDialog(this)
    }

    private fun setListener() {
        binding.imgGoogle.setOnClickListener {
            pDialog!!.showProgressDialog()
            changeClass()
        }
        binding.imgFacebook.setOnClickListener {
            pDialog!!.showProgressDialog()
            changeClass()
        }
        binding.btnLoginActivity.setOnClickListener {
            pDialog!!.showProgressDialog()
            val password = binding.edPassword.text.toString().trim()
            val email = binding.edEmail.text.toString().trim()
            if (password.isNotEmpty() && email.isNotEmpty()) {
                if (isValidEmail(email)) {
                    if (isValidPassword(password)) {
                        if (password.length > 8) {
                            if (email == "info@thecodework.com" && password == "ValidPassword12345") {
                                changeClass()
                            }else{
                                showDialog(this, "Wrong Email & Password")
                                pDialog!!.hideProgressDialog()
                            }
                        } else {
                            showDialog(this, "Password should be greater than 8 digit")
                            pDialog!!.hideProgressDialog()
                        }
                    } else {
                        showDialog(this, "Password should be in Alphanumeric pattern")
                        pDialog!!.hideProgressDialog()
                    }
                } else {
                    showDialog(this, "Enter valid emailId")
                    pDialog!!.hideProgressDialog()
                }
            } else {
                showDialog(this, "Enter valid Email & Password")
                pDialog!!.hideProgressDialog()
            }
        }
    }

    private fun initializer() {
        Utils.hideStatusBar(binding.tvfurnish)
    }

    private fun changeClass() {
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, DashboardActivity::class.java)
            pDialog!!.hideProgressDialog()
            startActivity(intent)
        }, 1000)
    }
}