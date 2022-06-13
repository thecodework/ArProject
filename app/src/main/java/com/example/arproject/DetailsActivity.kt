package com.example.arproject

import android.content.ContentValues
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.example.arproject.databinding.ActivityDetailsBinding
import com.example.arproject.model.ModelCategory
import com.google.ar.core.ArCoreApk
import com.google.ar.core.exceptions.UnavailableException


class DetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_details)
        initializer()
        setListener()
    }

    private fun setListener() {
        binding.btnAR.setOnClickListener {
            isARCoreSupportedAndUpToDate()
        }
        binding.imageBack.setOnClickListener {
            finish()
        }
        binding.tvCart.setOnClickListener {
            val intent = Intent(this, DashboardActivity::class.java)
            intent.putExtra("value", "1")
            startActivity(intent)
        }
    }

    private fun initializer() {
        window.statusBarColor = ContextCompat.getColor(this, R.color.statusbar_color)
        val intent = intent
        val user = intent.getSerializableExtra("USER_KEY") as ModelCategory
        binding.imageItem.setImageResource(user.categoryimage)
        binding.tvItem.text = user.categoryname
        binding.rBar.rating = user.rating
        binding.tvPrice.text = user.price.toString()
    }

    private fun isARCoreSupportedAndUpToDate(): Boolean {
        return when (ArCoreApk.getInstance().checkAvailability(this)) {
            ArCoreApk.Availability.SUPPORTED_INSTALLED -> {
                Log.d(ContentValues.TAG, "SUPPORTED_INSTALLED")
                val intent = Intent(this, ViewARModelActivity::class.java)
                startActivity(intent)
                true
            }
            ArCoreApk.Availability.SUPPORTED_NOT_INSTALLED -> {
                try {
                    when (ArCoreApk.getInstance().requestInstall(this, true)) {
                        ArCoreApk.InstallStatus.INSTALL_REQUESTED -> {
                            Log.d(ContentValues.TAG, "ARCore installation requested.")
                            navigateToARScreen()
                            false
                        }
                        ArCoreApk.InstallStatus.INSTALLED -> {
                            Log.d(ContentValues.TAG, "Request installed")
                            true
                        }
                    }
                } catch (e: UnavailableException) {
                    Log.d(ContentValues.TAG, "ARCore not installed", e)
                    navigateToARScreen()
                    false
                }
            }
            ArCoreApk.Availability.UNSUPPORTED_DEVICE_NOT_CAPABLE -> {
                Log.d(ContentValues.TAG, "UNSUPPORTED_DEVICE_NOT_CAPABLE")
                navigateToARScreen()
                false
            }
            ArCoreApk.Availability.UNKNOWN_CHECKING -> {
                Log.d(ContentValues.TAG, "UNKNOWN_CHECKING")
                navigateToARScreen()
                false
            }
            ArCoreApk.Availability.UNKNOWN_ERROR -> {
                Log.d(ContentValues.TAG, "UNKNOWN_ERROR")
                navigateToARScreen()
                false
            }
            ArCoreApk.Availability.UNKNOWN_TIMED_OUT -> {
                Log.d(ContentValues.TAG, "UNKNOWN_TIMED_OUT")
                navigateToARScreen()
                false
            }
            ArCoreApk.Availability.SUPPORTED_APK_TOO_OLD -> {
                Log.d(ContentValues.TAG, "SUPPORTED_APK_TOO_OLD")
                navigateToARScreen()
                false
            }
        }
    }

    private fun navigateToARScreen() {
        val sceneViewerIntent = Intent(Intent.ACTION_VIEW)
        sceneViewerIntent.data =
            Uri.parse("https://arvr.google.com/scene-viewer/1.0?file=https://drive.google.com/u/2/uc?id=1ZrVO6LdVIZS8kfMtQCcP4LmUNk2BlINj&export=download")
        startActivity(sceneViewerIntent)
    }
}