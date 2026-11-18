package com.example.appbanhangdientu

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.example.appbanhangdientu.data.MockData
import com.example.appbanhangdientu.databinding.ActivityDetailBinding
import java.text.NumberFormat
import java.util.Locale

class DetailActivity : BaseActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val productId = intent.getIntExtra("PRODUCT_ID", 1)
        val product = MockData.products.firstOrNull { it.id == productId } ?: MockData.products[0]

        val formatter = NumberFormat.getCurrencyInstance(Locale.Builder().setLanguage("vi").setRegion("VN").build())

        binding.productImg.setImageResource(product.imageResId)
        binding.titleTxt.text = product.title
        binding.priceTxt.text = formatter.format(product.price)
        binding.ratingTxt.text = "${product.rating} (${product.reviewCount} đánh giá)"
        binding.descTxt.text = product.description

        binding.backBtn.setOnClickListener { finish() }

        binding.addToCartBtn.setOnClickListener {
            Toast.makeText(this, "Đã thêm ${product.title} vào giỏ hàng!", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, CartActivity::class.java))
        }

        binding.buyNowBtn.setOnClickListener {
            startActivity(Intent(this, CheckoutActivity::class.java))
        }
    }
}
