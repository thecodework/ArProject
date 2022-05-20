package com.example.arproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.arproject.databinding.RowShopBinding
import com.example.arproject.model.ModelCategory

class ShopAdapter(
    private val context: Context?,
    private val arraylist: ArrayList<ModelCategory>,
    private val item: ItemClick
) :
    RecyclerView.Adapter<ShopAdapter.MyHolder>() {

    interface ItemClick {
        fun onClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val binding =
            RowShopBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyHolder(binding)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        if (context != null) {
            with(holder) {
                binding.imageItem.setImageResource(arraylist[position].categoryimage)
                binding.imageItem.setOnClickListener {
                    item.onClick(position)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return arraylist.size
    }

    class MyHolder(val binding: RowShopBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }
}