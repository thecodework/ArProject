package com.example.arproject.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.arproject.R
import com.example.arproject.databinding.RowShopBinding
import com.example.arproject.model.ModelCategory

class ShopAdapter(
    private val arraylist: ArrayList<ModelCategory>,
    private val item: ItemClick
) :
    RecyclerView.Adapter<ShopAdapter.MyHolder>() {

    interface ItemClick {
        fun onClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: RowShopBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.row_shop, parent, false
        )
        return MyHolder(binding)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        with(holder) {
            holder.bind(arraylist[position])
            binding.imageItem.setOnClickListener {
                item.onClick(position)
            }
        }
    }

    override fun getItemCount(): Int {
        return arraylist.size
    }

    class MyHolder(val binding: RowShopBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(modelCategory: ModelCategory) {
            binding.modelCategory = modelCategory
            binding.executePendingBindings()
        }
    }
}