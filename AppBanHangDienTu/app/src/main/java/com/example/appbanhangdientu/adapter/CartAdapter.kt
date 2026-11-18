package com.example.appbanhangdientu.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appbanhangdientu.databinding.ViewholderCartBinding
import com.example.appbanhangdientu.model.CartItem
import java.text.NumberFormat
import java.util.Locale

class CartAdapter(private val items: List<CartItem>) :
    RecyclerView.Adapter<CartAdapter.ViewHolder>() {

    class ViewHolder(val binding: ViewholderCartBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ViewholderCartBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        val formatter = NumberFormat.getCurrencyInstance(Locale.Builder().setLanguage("vi").setRegion("VN").build())

        holder.binding.pic.setImageResource(item.product.imageResId)
        holder.binding.titleTxt.text = item.product.title
        holder.binding.feeEachItem.text = formatter.format(item.product.price)
        holder.binding.numberItemTxt.text = "Số lượng: ${item.quantity}"
    }

    override fun getItemCount(): Int = items.size
}
