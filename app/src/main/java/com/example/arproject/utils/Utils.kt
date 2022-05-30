package com.example.arproject.utils

import android.app.Activity
import android.app.Dialog
import android.text.TextUtils
import android.util.Patterns
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.arproject.R

class Utils {

    companion object {
        fun changeStatusBar(activity: Activity, color: Int) {
            val window = activity.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor = ContextCompat.getColor(activity, color)
        }

        fun isValidPassword(password: String?): Boolean {
            password?.let {
                val passwordPattern =
                    "^(?=.*[a-zA-Z])(?=.*[0-9])[A-Za-z0-9]+\$"
                val passwordMatcher = Regex(passwordPattern)

                return passwordMatcher.find(password) != null
            } ?: return false
        }

        fun isValidEmail(email: String): Boolean {
            return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()
        }

        fun showDialog(activity: Activity, title: String) {
            val dialog = Dialog(activity)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
            dialog.setCancelable(false)
            dialog.setContentView(R.layout.dailogbox)
            val msg = dialog.findViewById(R.id.tvText) as TextView
            msg.text = title
            val btnOk = dialog.findViewById(R.id.btnOk) as Button
            btnOk.setOnClickListener {
                dialog.dismiss()
            }
            dialog.show()
        }
    }
}