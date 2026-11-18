package com.example.appbanhangdientu

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appbanhangdientu.adapter.CategoryAdapter
import com.example.appbanhangdientu.adapter.ProductAdapter
import com.example.appbanhangdientu.data.MockData
import com.example.appbanhangdientu.databinding.ActivityMainBinding
import com.example.appbanhangdientu.model.Product

class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding
    private var allProducts: List<Product> = MockData.products

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initCategories()
        initProducts()
        initListeners()
        initSearch()
    }

    private fun initCategories() {
        binding.categoryView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.categoryView.adapter = CategoryAdapter(MockData.categories)
    }

    private fun initProducts() {
        binding.productView.layoutManager = GridLayoutManager(this, 2)
        binding.productView.adapter = ProductAdapter(allProducts)
    }

    private fun initListeners() {
        binding.cartBtn.setOnClickListener {
            startActivity(Intent(this, CartActivity::class.java))
        }

        binding.bellBtn.setOnClickListener {
            startActivity(Intent(this, NotificationActivity::class.java))
        }

        // Bottom Navigation Bar
        binding.homeNav.setOnClickListener {
            // Already on Home screen
        }

        binding.cartNav.setOnClickListener {
            startActivity(Intent(this, CartActivity::class.java))
        }

        binding.bellNav.setOnClickListener {
            startActivity(Intent(this, NotificationActivity::class.java))
        }

        binding.profileNav.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }
    }

    private fun initSearch() {
        binding.searchEdt.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val query = s.toString().trim()
                val filteredList = if (query.isEmpty()) {
                    allProducts
                } else {
                    allProducts.filter { product ->
                        product.title.contains(query, ignoreCase = true) ||
                        product.category.contains(query, ignoreCase = true)
                    }
                }
                binding.productView.adapter = ProductAdapter(filteredList)
            }
            override fun afterTextChanged(s: Editable?) {}
        })
    }
}
