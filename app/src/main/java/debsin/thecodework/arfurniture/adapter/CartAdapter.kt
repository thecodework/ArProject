package debsin.thecodework.arfurniture.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import debsin.thecodework.arfurniture.databinding.RowCartBinding
import debsin.thecodework.arfurniture.R
import debsin.thecodework.arfurniture.model.ModelCategory

class CartAdapter(
    private val arraylist: ArrayList<ModelCategory>
) :
    RecyclerView.Adapter<CartAdapter.MyHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: RowCartBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.row_cart, parent, false
        )
        return MyHolder(binding)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        with(holder) {
            holder.bind(arraylist[position])
        }
    }

    override fun getItemCount(): Int {
        return arraylist.size
    }

    class MyHolder(val binding: RowCartBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(modelCategory: ModelCategory) {
            binding.modelCategory = modelCategory
            binding.executePendingBindings()
        }
    }
}