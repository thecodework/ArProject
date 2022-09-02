package debsin.thecodework.arfurniture.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import debsin.thecodework.arfurniture.ui.DemoData
import debsin.thecodework.arfurniture.R
import debsin.thecodework.arfurniture.adapter.CartAdapter
import debsin.thecodework.arfurniture.databinding.FragmentCartBinding
import debsin.thecodework.arfurniture.model.ModelCategory


class CartFragment : Fragment() {
    lateinit var binding: FragmentCartBinding
    var demoProductList: ArrayList<ModelCategory> = DemoData.getProductList(2)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cart, container, false)
        initializer()
        return binding.root
    }

    private fun initializer() {
        binding.rvShop.adapter = CartAdapter(demoProductList)
    }
}