package com.thecodework.arfurniture.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.thecodework.arfurniture.ui.DemoData
import com.thecodework.arfurniture.ui.DetailsActivity
import com.thecodework.arfurniture.R
import com.thecodework.arfurniture.adapter.ShopAdapter
import com.thecodework.arfurniture.databinding.FragmentShopBinding
import com.thecodework.arfurniture.model.ModelCategory


class ShopFragment : Fragment(), ShopAdapter.ItemClick {
    lateinit var binding: FragmentShopBinding
    private var demoProductList: ArrayList<ModelCategory> = DemoData.getProductList(8)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shop, container, false
        )
        initializer()
        return binding.root
    }

    private fun initializer() {
        binding.rvShop.adapter = ShopAdapter(demoProductList, this)
    }

    override fun onClick(position: Int) {
        val intent = Intent(context, DetailsActivity::class.java)
        intent.putExtra("USER_KEY", demoProductList[position])
        startActivity(intent)
    }
}