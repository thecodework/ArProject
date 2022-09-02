package debsin.thecodework.arfurniture.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import debsin.thecodework.arfurniture.R
import debsin.thecodework.arfurniture.databinding.ActivityDetailsBinding
import debsin.thecodework.arfurniture.model.ModelCategory
import com.google.ar.core.ArCoreApk
import com.google.ar.core.exceptions.UnavailableException


class DetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailsBinding
    var availability: ArCoreApk.Availability = ArCoreApk.Availability.SUPPORTED_NOT_INSTALLED
    var count: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_details)
        initializer()
        setListener()
    }

    private fun setListener() {
        binding.btnAR.setOnClickListener {
            if (count == 0) {
                isARCoreSupportedAndUpToDate()
            } else {
                if (availability == ArCoreApk.Availability.SUPPORTED_INSTALLED) {
                    val intent = Intent(this, ViewARModelActivity::class.java)
                    startActivity(intent)
                } else {
                    navigateToARScreen()
                }
            }
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
                availability = ArCoreApk.Availability.SUPPORTED_INSTALLED
                val intent = Intent(this, ViewARModelActivity::class.java)
                startActivity(intent)
                true
            }
            ArCoreApk.Availability.SUPPORTED_NOT_INSTALLED -> {
                try {
                    if (count < 1) {
                        when (ArCoreApk.getInstance().requestInstall(this, true)) {
                            ArCoreApk.InstallStatus.INSTALL_REQUESTED -> {
                                count++
                                availability = ArCoreApk.Availability.SUPPORTED_NOT_INSTALLED
                                true
                            }
                            ArCoreApk.InstallStatus.INSTALLED -> {
                                availability = ArCoreApk.Availability.SUPPORTED_INSTALLED
                                true
                            }
                        }
                    }
                    true
                } catch (e: UnavailableException) {
                    availability = ArCoreApk.Availability.SUPPORTED_NOT_INSTALLED
                    false
                }
            }
            ArCoreApk.Availability.UNSUPPORTED_DEVICE_NOT_CAPABLE -> {
                availability = ArCoreApk.Availability.SUPPORTED_NOT_INSTALLED
                false
            }
            ArCoreApk.Availability.UNKNOWN_CHECKING -> {
                availability = ArCoreApk.Availability.SUPPORTED_NOT_INSTALLED
                false
            }
            ArCoreApk.Availability.UNKNOWN_ERROR -> {
                availability = ArCoreApk.Availability.SUPPORTED_NOT_INSTALLED
                false
            }
            ArCoreApk.Availability.UNKNOWN_TIMED_OUT -> {
                availability = ArCoreApk.Availability.SUPPORTED_NOT_INSTALLED
                false
            }
            ArCoreApk.Availability.SUPPORTED_APK_TOO_OLD -> {
                availability = ArCoreApk.Availability.SUPPORTED_NOT_INSTALLED
                false
            }
        }
    }

    override fun onResume() {
        super.onResume()
        if (count > 0) {
            isARCoreSupportedAndUpToDate()
        }
    }

    private fun navigateToARScreen() {
        val sceneViewerIntent = Intent(Intent.ACTION_VIEW)
        sceneViewerIntent.data =
            Uri.parse(getString(R.string.modelChair))
                .buildUpon()
                .appendQueryParameter("resizable", "true")
                .appendQueryParameter("mode","ar_only")
                .build()
        startActivity(sceneViewerIntent)
    }
}