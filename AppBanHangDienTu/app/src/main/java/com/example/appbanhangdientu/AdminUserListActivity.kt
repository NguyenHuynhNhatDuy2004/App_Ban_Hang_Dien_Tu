package com.example.appbanhangdientu

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appbanhangdientu.adapter.AdminUserAdapter
import com.example.appbanhangdientu.data.AdminMockData
import com.example.appbanhangdientu.databinding.ActivityAdminUserListBinding

class AdminUserListActivity : BaseActivity() {
    private lateinit var binding: ActivityAdminUserListBinding
    private lateinit var adapter: AdminUserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdminUserListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backBtn.setOnClickListener { finish() }

        initRecyclerView()
    }

    private fun initRecyclerView() {
        adapter = AdminUserAdapter(
            items = AdminMockData.userAccounts,
            onToggleLockClick = { user ->
                user.isLocked = !user.isLocked
                adapter.notifyDataSetChanged()
            }
        )

        binding.userRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.userRecyclerView.adapter = adapter
    }
}
