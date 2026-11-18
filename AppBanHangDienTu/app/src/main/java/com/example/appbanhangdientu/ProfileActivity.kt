package com.example.appbanhangdientu

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.example.appbanhangdientu.databinding.ActivityProfileBinding

class ProfileActivity : BaseActivity() {
    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListeners()
        setupBottomNavigation()
    }

    private fun setupListeners() {
        binding.editProfileBtn.setOnClickListener {
            Toast.makeText(this, "Tính năng chỉnh sửa thông tin đang phát triển", Toast.LENGTH_SHORT).show()
        }

        binding.orderHistoryBtn.setOnClickListener {
            Toast.makeText(this, "Chức năng xem lịch sử đơn hàng", Toast.LENGTH_SHORT).show()
        }

        binding.adminDashboardBtn.setOnClickListener {
            startActivity(Intent(this, AdminDashboardActivity::class.java))
        }

        binding.logoutBtn.setOnClickListener {
            Toast.makeText(this, "Đã đăng xuất", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }
    }

    private fun setupBottomNavigation() {
        binding.homeNav.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
            finish()
        }

        binding.cartNav.setOnClickListener {
            startActivity(Intent(this, CartActivity::class.java))
            finish()
        }

        binding.bellNav.setOnClickListener {
            startActivity(Intent(this, NotificationActivity::class.java))
            finish()
        }

        binding.profileNav.setOnClickListener {
            // Already on Profile screen
        }
    }
}
