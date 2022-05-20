package com.example.arproject.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.arproject.DetailsActivity
import com.example.arproject.R
import com.example.arproject.adapter.ShopAdapter
import com.example.arproject.databinding.FragmentShopBinding
import com.example.arproject.model.ModelCategory


class ShopFragment : Fragment(), ShopAdapter.ItemClick {
    lateinit var binding: FragmentShopBinding
    var arraylist: ArrayList<ModelCategory> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShopBinding.inflate(inflater, container, false)
        initializer()
        return binding.root
    }

    private fun initializer() {
        arraylist.add(ModelCategory(R.drawable.sofa1, "Sofa"))
        arraylist.add(ModelCategory(R.drawable.sofa2, "Sofa"))
        arraylist.add(ModelCategory(R.drawable.sofa1, "Sofa"))
        arraylist.add(ModelCategory(R.drawable.sofa2, "Sofa"))
        arraylist.add(ModelCategory(R.drawable.sofa1, "Sofa"))
        arraylist.add(ModelCategory(R.drawable.sofa2, "Sofa"))
        binding.rvShop.adapter = ShopAdapter(context, arraylist, this)
    }

    override fun onClick(position: Int) {
        val intent = Intent(context, DetailsActivity::class.java)
        val pic: Int = arraylist[position].categoryimage
        intent.putExtra("image", pic)
        startActivity(intent)
    }

}