package com.example.arproject.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.arproject.DemoData
import com.example.arproject.DetailsActivity
import com.example.arproject.R
import com.example.arproject.adapter.ShopAdapter
import com.example.arproject.databinding.FragmentShopBinding
import com.example.arproject.model.ModelCategory
import com.example.arproject.model.UserModel


class ShopFragment : Fragment(), ShopAdapter.ItemClick {
    lateinit var binding: FragmentShopBinding
    var demoProductList: ArrayList<ModelCategory> = DemoData.getProductList(8)

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
        val user = UserModel()
        user.image = demoProductList[position].categoryimage
        user.name = demoProductList[position].categoryname
        user.price = demoProductList[position].price
        user.rating = demoProductList[position].rating
        intent.putExtra("USER_KEY", user)
        startActivity(intent)
    }
}