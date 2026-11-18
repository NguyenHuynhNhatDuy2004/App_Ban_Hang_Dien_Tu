package com.example.appbanhangdientu

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appbanhangdientu.adapter.AdminProductAdapter
import com.example.appbanhangdientu.data.MockData
import com.example.appbanhangdientu.databinding.ActivityAdminProductListBinding
import com.example.appbanhangdientu.model.Product

class AdminProductListActivity : BaseActivity() {
    private lateinit var binding: ActivityAdminProductListBinding
    private lateinit var adapter: AdminProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdminProductListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backBtn.setOnClickListener { finish() }

        binding.addProductBtn.setOnClickListener {
            startActivity(Intent(this, AdminAddEditProductActivity::class.java))
        }

        initRecyclerView()
    }

    override fun onResume() {
        super.onResume()
        adapter.notifyDataSetChanged()
    }

    private fun initRecyclerView() {
        val productsList = MockData.products as MutableList<Product>
        adapter = AdminProductAdapter(
            items = productsList,
            onEditClick = { product ->
                val intent = Intent(this, AdminAddEditProductActivity::class.java)
                intent.putExtra("PRODUCT_ID", product.id)
                startActivity(intent)
            },
            onDeleteClick = { product ->
                productsList.remove(product)
                adapter.notifyDataSetChanged()
            }
        )

        binding.productRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.productRecyclerView.adapter = adapter
    }
}
