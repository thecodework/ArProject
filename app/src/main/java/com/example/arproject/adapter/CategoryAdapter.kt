package com.example.arproject.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.arproject.R
import com.example.arproject.databinding.RowCategoryBinding
import com.example.arproject.model.ModelCategory

class CategoryAdapter(
    private val arraylist: ArrayList<ModelCategory>
) :
    RecyclerView.Adapter<CategoryAdapter.MyHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: RowCategoryBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.row_category, parent, false
        )
        return MyHolder(binding)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) =
        holder.bind(arraylist[position])


    override fun getItemCount(): Int {
        return arraylist.size
    }

    class MyHolder(val binding: RowCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(modelCategory: ModelCategory) {
            binding.modelCategory = modelCategory
            binding.executePendingBindings()
        }
    }
}