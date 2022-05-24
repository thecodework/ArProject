package com.example.arproject

import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import com.example.arproject.databinding.ActivityViewArmodelBinding
import com.google.ar.sceneform.AnchorNode
import com.google.ar.sceneform.assets.RenderableSource
import com.google.ar.sceneform.rendering.ModelRenderable
import com.google.ar.sceneform.ux.ArFragment
import com.google.ar.sceneform.ux.TransformableNode

class ViewARModelActivity : AppCompatActivity() {

    lateinit var binding: ActivityViewArmodelBinding

    private var arFragment: ArFragment? = null
    private var modelRenewable: ModelRenderable? = null


    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_view_armodel)
        init()
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun init() {
        arFragment = supportFragmentManager.findFragmentById(R.id.fragment) as ArFragment?
        setUpModel()
        setUpPlane()
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun setUpModel() {
        ModelRenderable.builder()
            .setSource(
                this, RenderableSource.builder()
                    .setSource(
                        this,
                        Uri.parse("stylised_astronaught.glb"),
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
                Toast.makeText(this@ViewARModelActivity, "Model can't be Loaded", Toast.LENGTH_SHORT)
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