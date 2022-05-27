package com.example.arproject

import android.content.ContentValues.TAG
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import com.example.arproject.databinding.ActivityViewArmodelBinding
import com.google.ar.core.ArCoreApk
import com.google.ar.core.exceptions.UnavailableException
import com.google.ar.sceneform.AnchorNode
import com.google.ar.sceneform.assets.RenderableSource
import com.google.ar.sceneform.rendering.ModelRenderable
import com.google.ar.sceneform.ux.ArFragment
import com.google.ar.sceneform.ux.TransformableNode

@RequiresApi(Build.VERSION_CODES.N)
class ViewARModelActivity : AppCompatActivity() {

    lateinit var binding: ActivityViewArmodelBinding
    private var arFragment: ArFragment? = null
    private var modelRenewable: ModelRenderable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_view_armodel)
        init()
        isARCoreSupportedAndUpToDate()
    }

    fun isARCoreSupportedAndUpToDate(): Boolean {
        return when (ArCoreApk.getInstance().checkAvailability(this)) {
            ArCoreApk.Availability.SUPPORTED_INSTALLED -> {
                Log.d(TAG, "SUPPORTED_INSTALLED")
                true
            }
            ArCoreApk.Availability.SUPPORTED_APK_TOO_OLD, ArCoreApk.Availability.SUPPORTED_NOT_INSTALLED -> {
                try {
                    // Request ARCore installation or update if needed.
                    when (ArCoreApk.getInstance().requestInstall(this, true)) {
                        ArCoreApk.InstallStatus.INSTALL_REQUESTED -> {
                            Log.d(TAG, "ARCore installation requested.")
                            false
                        }
                        ArCoreApk.InstallStatus.INSTALLED -> {
                            Log.d(TAG, "Request installed")
                            true
                        }
                    }
                } catch (e: UnavailableException) {
                    Log.d(TAG, "ARCore not installed", e)
                    false
                }
            }
            ArCoreApk.Availability.UNSUPPORTED_DEVICE_NOT_CAPABLE -> {
                Log.d(TAG, "UNSUPPORTED_DEVICE_NOT_CAPABLE")
                false
            }
            ArCoreApk.Availability.UNKNOWN_CHECKING -> {
                Log.d(TAG, "UNKNOWN_CHECKING")
                false
            }
            ArCoreApk.Availability.UNKNOWN_ERROR -> {
                Log.d(TAG, "UNKNOWN_ERROR")
                false
            }
            ArCoreApk.Availability.UNKNOWN_TIMED_OUT -> {
                Log.d(TAG, "UNKNOWN_TIMED_OUT")
                false
            }
        }
    }

    private fun init() {
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        arFragment = supportFragmentManager.findFragmentById(R.id.fragment) as ArFragment?
        setUpModel()
        setUpPlane()
    }

    private fun setUpModel() {
        ModelRenderable.builder()
            .setSource(
                this, RenderableSource.builder()
                    .setSource(
                        this,
                        Uri.parse("bluechair.glb"),
                        RenderableSource.SourceType.GLB
                    )
                    .setRecenterMode(RenderableSource.RecenterMode.CENTER)
                    .build()
            )
            .build()
            .thenAccept { renewable: ModelRenderable ->
                modelRenewable = renewable
            }
            .exceptionally {
                Toast.makeText(
                    this@ViewARModelActivity,
                    "Model can't be Loaded",
                    Toast.LENGTH_SHORT
                )
                    .show()
                null
            }
    }

    private fun setUpPlane() {
        arFragment!!.setOnTapArPlaneListener { hitResult, plane, motionEvent ->
            val anchor = hitResult.createAnchor()
            val anchorNode = AnchorNode(anchor)
            anchorNode.setParent(arFragment!!.arSceneView.scene)
            createModel(anchorNode)
        }
    }

    private fun createModel(anchorNode: AnchorNode) {
        val node = TransformableNode(arFragment!!.transformationSystem)
        node.setParent(anchorNode)
        node.renderable = modelRenewable
        node.scaleController.maxScale = 0.5f
        node.scaleController.minScale = 0.25f
        node.select()
    }
}