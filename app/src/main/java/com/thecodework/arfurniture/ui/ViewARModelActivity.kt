package com.thecodework.arfurniture.ui

import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.thecodework.arfurniture.R
import com.thecodework.arfurniture.databinding.ActivityViewArmodelBinding
import com.thecodework.arfurniture.utils.Utils
import com.google.ar.sceneform.AnchorNode
import com.google.ar.sceneform.assets.RenderableSource
import com.google.ar.sceneform.rendering.ModelRenderable
import com.google.ar.sceneform.ux.ArFragment
import com.google.ar.sceneform.ux.TransformableNode

class ViewARModelActivity : AppCompatActivity() {

    lateinit var binding: ActivityViewArmodelBinding
    private var arFragment: ArFragment? = null
    private var modelRenewable: ModelRenderable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_view_armodel)
        init()
    }

    private fun init() {
        Utils.hideStatusBar(binding.btnArrowBack)
        arFragment = supportFragmentManager.findFragmentById(R.id.fragment) as ArFragment?
        setUpModel()
        setUpPlane()
        setOnClickListener()
    }

    private fun setOnClickListener() {
        binding.btnArrowBack.setOnClickListener {
            finish()
        }
        binding.imageCross.setOnClickListener {
            Utils.showARDialog(this)
        }
    }

    private fun setUpModel() {
        ModelRenderable.builder()
            .setSource(
                this, RenderableSource.builder()
                    .setSource(
                        this,
                        Uri.parse("chair.glb"),
                        RenderableSource.SourceType.GLB
                    )
                    .setRecenterMode(RenderableSource.RecenterMode.CENTER)
                    .build()
            )
            .build()
            .thenAccept { renewable: ModelRenderable ->
                modelRenewable = renewable
                Toast.makeText(
                    this,
                    "Please tap on the white dots to load model",
                    Toast.LENGTH_LONG
                ).show()
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
        node.scaleController.maxScale = 1.0f
        node.scaleController.minScale = 0.5f
        node.select()
    }
}