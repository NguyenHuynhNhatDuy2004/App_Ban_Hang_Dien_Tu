package com.example.appbanhangdientu.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appbanhangdientu.databinding.ViewholderAdminOrderBinding
import com.example.appbanhangdientu.model.Order
import java.text.NumberFormat
import java.util.Locale

class AdminOrderAdapter(
    private val items: List<Order>,
    private val onChangeStatusClick: (Order) -> Unit
) : RecyclerView.Adapter<AdminOrderAdapter.ViewHolder>() {

    class ViewHolder(val binding: ViewholderAdminOrderBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ViewholderAdminOrderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        val formatter = NumberFormat.getCurrencyInstance(Locale.Builder().setLanguage("vi").setRegion("VN").build())

        holder.binding.orderIdTxt.text = "Mã đơn: ${item.id}"
        holder.binding.orderStatusTxt.text = item.status
        holder.binding.customerNameTxt.text = "Khách: ${item.customerName} (${item.customerPhone})"
        holder.binding.orderTotalTxt.text = "Tổng: ${formatter.format(item.totalPrice)}"

        holder.binding.changeStatusBtn.setOnClickListener { onChangeStatusClick(item) }
    }

    override fun getItemCount(): Int = items.size
}
