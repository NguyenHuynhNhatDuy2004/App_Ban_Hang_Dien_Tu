package com.example.appbanhangdientu

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appbanhangdientu.adapter.CartAdapter
import com.example.appbanhangdientu.data.MockData
import com.example.appbanhangdientu.databinding.ActivityCartBinding
import java.text.NumberFormat
import java.util.Locale

class CartActivity : BaseActivity() {
    private lateinit var binding: ActivityCartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val formatter = NumberFormat.getCurrencyInstance(Locale.Builder().setLanguage("vi").setRegion("VN").build())
        val cartItems = MockData.sampleCartItems

        val total = cartItems.sumOf { it.product.price * it.quantity } + 30000.0
        binding.totalTxt.text = formatter.format(total)

        binding.cartView.layoutManager = LinearLayoutManager(this)
        binding.cartView.adapter = CartAdapter(cartItems)

        binding.backBtn.setOnClickListener { finish() }

        binding.checkoutBtn.setOnClickListener {
            startActivity(Intent(this, CheckoutActivity::class.java))
        }

        setupBottomNavigation()
    }

    private fun setupBottomNavigation() {
        binding.homeNav.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
            finish()
        }

        binding.cartNav.setOnClickListener {
            // Already on Cart screen
        }

        binding.bellNav.setOnClickListener {
            startActivity(Intent(this, NotificationActivity::class.java))
            finish()
        }

        binding.profileNav.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
            finish()
        }
    }
}
