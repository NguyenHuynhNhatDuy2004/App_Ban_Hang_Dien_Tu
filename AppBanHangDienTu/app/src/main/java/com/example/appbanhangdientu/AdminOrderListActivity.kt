package com.example.appbanhangdientu

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appbanhangdientu.adapter.AdminOrderAdapter
import com.example.appbanhangdientu.data.AdminMockData
import com.example.appbanhangdientu.databinding.ActivityAdminOrderListBinding

class AdminOrderListActivity : BaseActivity() {
    private lateinit var binding: ActivityAdminOrderListBinding
    private lateinit var adapter: AdminOrderAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdminOrderListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backBtn.setOnClickListener { finish() }

        initRecyclerView()
    }

    private fun initRecyclerView() {
        adapter = AdminOrderAdapter(
            items = AdminMockData.orders,
            onChangeStatusClick = { order ->
                order.status = when (order.status) {
                    "Chờ xử lý" -> "Đang giao"
                    "Đang giao" -> "Đã hoàn thành"
                    else -> "Chờ xử lý"
                }
                adapter.notifyDataSetChanged()
            }
        )

        binding.orderRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.orderRecyclerView.adapter = adapter
    }
}
