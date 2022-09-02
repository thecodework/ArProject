package debsin.thecodework.arfurniture.ui

import debsin.thecodework.arfurniture.R
import debsin.thecodework.arfurniture.model.ModelCategory
import kotlin.random.Random

class DemoData {
    companion object {
        fun getProductList(numberOfProduct: Int): ArrayList<ModelCategory> {
            val productList = arrayListOf(
                getDemoModel(1), getDemoModel(2), getDemoModel(3),
                getDemoModel(4), getDemoModel(5), getDemoModel(6)
            )
            return if (numberOfProduct >= productList.size) {
                productList
            } else {
                val list = arrayListOf<ModelCategory>()
                list.addAll(productList.subList(0, numberOfProduct))
                list
            }
        }

        private fun getDemoModel(number: Int): ModelCategory {
            return ModelCategory(
                getProductImage(number),
                getProductName(number),
                Random.nextDouble(0.0, 5.0).toFloat(),
                Random.nextInt(5000, 25000),
                getProductDescription()
            )
        }

        private fun getProductImage(pic: Int): Int {
            val productImageMap: Map<Int, Int> = mapOf(
                1 to R.drawable.blackchair,
                2 to R.drawable.cupboard,
                3 to R.drawable.table,
                4 to R.drawable.whitesofa,
                5 to R.drawable.bedimage,
                6 to R.drawable.desk2
            )
            return productImageMap.getValue(pic)
        }

        private fun getProductName(name: Int): String {
            val productName =
                mapOf(
                    1 to "Chair",
                    2 to "Cupboard",
                    3 to "Table",
                    4 to "Sofa",
                    5 to "Bed",
                    6 to "Desk"
                )
            return productName.getValue(name)
        }

        private fun getProductDescription(): String = "This is a piece of an Art"
    }
}