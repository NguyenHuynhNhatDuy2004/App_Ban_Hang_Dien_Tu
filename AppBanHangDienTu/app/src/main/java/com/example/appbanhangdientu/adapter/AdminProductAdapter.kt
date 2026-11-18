package com.example.appbanhangdientu.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appbanhangdientu.databinding.ViewholderAdminProductBinding
import com.example.appbanhangdientu.model.Product
import java.text.NumberFormat
import java.util.Locale

class AdminProductAdapter(
    private val items: MutableList<Product>,
    private val onEditClick: (Product) -> Unit,
    private val onDeleteClick: (Product) -> Unit
) : RecyclerView.Adapter<AdminProductAdapter.ViewHolder>() {

    class ViewHolder(val binding: ViewholderAdminProductBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ViewholderAdminProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        val formatter = NumberFormat.getCurrencyInstance(Locale.Builder().setLanguage("vi").setRegion("VN").build())

        holder.binding.pic.setImageResource(item.imageResId)
        holder.binding.titleTxt.text = item.title
        holder.binding.priceTxt.text = formatter.format(item.price)

        holder.binding.editBtn.setOnClickListener { onEditClick(item) }
        holder.binding.deleteBtn.setOnClickListener { onDeleteClick(item) }
    }

    override fun getItemCount(): Int = items.size
}
