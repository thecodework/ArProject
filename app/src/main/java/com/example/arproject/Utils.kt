package com.example.arproject

import android.R.attr
import android.app.Activity
import android.text.TextUtils
import android.util.Patterns
import android.view.WindowManager
import androidx.core.content.ContextCompat
import java.util.regex.Matcher
import java.util.regex.Pattern


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
                    "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$"
                val passwordMatcher = Regex(passwordPattern)

                return passwordMatcher.find(password) != null
            } ?: return false
        }
        fun isValidEmail(email: String): Boolean {
            return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()
        }
    }
}