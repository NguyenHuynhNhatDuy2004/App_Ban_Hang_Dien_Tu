package com.example.appbanhangdientu.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appbanhangdientu.DetailActivity
import com.example.appbanhangdientu.databinding.ViewholderProductBinding
import com.example.appbanhangdientu.model.Product
import java.text.NumberFormat
import java.util.Locale

class ProductAdapter(private val items: List<Product>) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    class ViewHolder(val binding: ViewholderProductBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ViewholderProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        val formatter = NumberFormat.getCurrencyInstance(Locale.Builder().setLanguage("vi").setRegion("VN").build())

        holder.binding.pic.setImageResource(item.imageResId)
        holder.binding.titleTxt.text = item.title
        holder.binding.scoreTxt.text = item.rating.toString()
        holder.binding.priceTxt.text = formatter.format(item.price)

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
            intent.putExtra("PRODUCT_ID", item.id)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = items.size
}
