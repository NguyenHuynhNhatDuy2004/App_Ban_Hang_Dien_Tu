package com.example.appbanhangdientu

import android.os.Bundle
import com.example.appbanhangdientu.data.MockData
import com.example.appbanhangdientu.databinding.ActivityAdminAddEditProductBinding
import com.example.appbanhangdientu.model.Product

class AdminAddEditProductActivity : BaseActivity() {
    private lateinit var binding: ActivityAdminAddEditProductBinding
    private var editingProduct: Product? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdminAddEditProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val productId = intent.getIntExtra("PRODUCT_ID", -1)
        if (productId != -1) {
            editingProduct = MockData.products.firstOrNull { it.id == productId }
        }

        setupUI()

        binding.backBtn.setOnClickListener { finish() }

        binding.saveBtn.setOnClickListener {
            saveProduct()
        }
    }

    private fun setupUI() {
        if (editingProduct != null) {
            binding.formTitle.text = "Chỉnh Sửa Sản Phẩm"
            binding.titleEdt.setText(editingProduct!!.title)
            binding.categoryEdt.setText(editingProduct!!.category)
            binding.priceEdt.setText(editingProduct!!.price.toString())
            binding.descEdt.setText(editingProduct!!.description)
        } else {
            binding.formTitle.text = "Thêm Sản Phẩm Mới"
        }
    }

    private fun saveProduct() {
        val title = binding.titleEdt.text.toString().trim()
        val category = binding.categoryEdt.text.toString().trim()
        val priceStr = binding.priceEdt.text.toString().trim()
        val desc = binding.descEdt.text.toString().trim()

        if (title.isEmpty() || priceStr.isEmpty()) return

        val price = priceStr.toDoubleOrNull() ?: 0.0
        val productsList = MockData.products as MutableList<Product>

        if (editingProduct != null) {
            val index = productsList.indexOf(editingProduct)
            if (index != -1) {
                productsList[index] = editingProduct!!.copy(
                    title = title,
                    category = if (category.isEmpty()) "Điện thoại" else category,
                    price = price,
                    description = desc
                )
            }
        } else {
            val newId = (productsList.maxOfOrNull { it.id } ?: 0) + 1
            productsList.add(
                Product(
                    id = newId,
                    title = title,
                    description = desc,
                    price = price,
                    imageResId = R.drawable.intro_logo,
                    category = if (category.isEmpty()) "Điện thoại" else category
                )
            )
        }

        finish()
    }
}
