package debsin.thecodework.arfurniture.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import debsin.thecodework.arfurniture.ui.DemoData
import debsin.thecodework.arfurniture.ui.DetailsActivity
import debsin.thecodework.arfurniture.R
import debsin.thecodework.arfurniture.adapter.CategoryAdapter
import debsin.thecodework.arfurniture.adapter.ProductAdapter
import debsin.thecodework.arfurniture.databinding.FragmentHomeBinding
import debsin.thecodework.arfurniture.model.ModelCategory


class HomeFragment : Fragment(), ProductAdapter.ItemClick {
    lateinit var binding: FragmentHomeBinding
    var demoProductList: ArrayList<ModelCategory> = DemoData.getProductList(6)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_home, container, false
        )
        initializer()
        return binding.root
    }

    private fun initializer() {
        binding.rvCategory.adapter = CategoryAdapter(demoProductList)
        binding.rvProducts.adapter = ProductAdapter(demoProductList, this)
    }

     override fun onClick(position: Int) {
        val intent = Intent(context, DetailsActivity::class.java)
        intent.putExtra("USER_KEY", demoProductList[position])
        startActivity(intent)
    }
}