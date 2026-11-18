package com.example.appbanhangdientu

import android.content.Intent
import android.os.Bundle
import com.example.appbanhangdientu.databinding.ActivityAdminDashboardBinding

class AdminDashboardActivity : BaseActivity() {
    private lateinit var binding: ActivityAdminDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdminDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.productMgmtBtn.setOnClickListener {
            startActivity(Intent(this, AdminProductListActivity::class.java))
        }

        binding.orderMgmtBtn.setOnClickListener {
            startActivity(Intent(this, AdminOrderListActivity::class.java))
        }

        binding.revenueBtn.setOnClickListener {
            startActivity(Intent(this, AdminRevenueActivity::class.java))
        }

        binding.userMgmtBtn.setOnClickListener {
            startActivity(Intent(this, AdminUserListActivity::class.java))
        }
    }
}
