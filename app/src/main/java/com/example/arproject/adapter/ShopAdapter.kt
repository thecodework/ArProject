package com.example.arproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.arproject.R
import com.example.arproject.databinding.ActivityDashboardBinding.inflate
import com.example.arproject.databinding.RowCategoryBinding
import com.example.arproject.databinding.RowShopBinding
import com.example.arproject.model.ModelCategory

class ShopAdapter(private val context: Context?, private val arraylist: ArrayList<ModelCategory>) :
    RecyclerView.Adapter<ShopAdapter.myholder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myholder {
        val binding =
            RowShopBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return myholder(binding)
    }

    override fun onBindViewHolder(holder: myholder, position: Int) {
        if (context != null) {
            with(holder) {
                binding.imageItem.setImageResource(arraylist[position].categoryimage)
            }
        }
    }

    override fun getItemCount(): Int {
        return arraylist.size
    }

    class myholder(val binding: RowShopBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }
}