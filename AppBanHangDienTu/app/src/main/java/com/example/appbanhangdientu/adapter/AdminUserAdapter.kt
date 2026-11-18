package com.example.appbanhangdientu.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appbanhangdientu.databinding.ViewholderAdminUserBinding
import com.example.appbanhangdientu.model.UserAccount

class AdminUserAdapter(
    private val items: List<UserAccount>,
    private val onToggleLockClick: (UserAccount) -> Unit
) : RecyclerView.Adapter<AdminUserAdapter.ViewHolder>() {

    class ViewHolder(val binding: ViewholderAdminUserBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ViewholderAdminUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        holder.binding.userNameTxt.text = item.name
        holder.binding.userEmailTxt.text = item.email
        holder.binding.userRoleTxt.text = "Vai trò: ${item.role}"

        if (item.isLocked) {
            holder.binding.toggleLockBtn.text = "🔓 Mở khóa"
            holder.binding.toggleLockBtn.setTextColor(Color.RED)
        } else {
            holder.binding.toggleLockBtn.text = "🔒 Khóa"
            holder.binding.toggleLockBtn.setTextColor(Color.BLACK)
        }

        holder.binding.toggleLockBtn.setOnClickListener { onToggleLockClick(item) }
    }

    override fun getItemCount(): Int = items.size
}
