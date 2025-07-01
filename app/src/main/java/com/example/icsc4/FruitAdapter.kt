package com.example.icsc4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy


class FruitAdapter(
    private val fruits: List<Fruit>,
    private val onItemClick: (Fruit) -> Unit
) : RecyclerView.Adapter<FruitAdapter.FruitViewHolder>() {

    class FruitViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.imageView)
        val textName: TextView = view.findViewById(R.id.textName)
        val textOrigin: TextView = view.findViewById(R.id.textOrigin)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_fruit, parent, false)
        return FruitViewHolder(view)
    }

    override fun onBindViewHolder(holder: FruitViewHolder, position: Int) {
        val fruit = fruits[position]
        
        holder.textName.text = fruit.name
        holder.textOrigin.text = "from ${fruit.origin}"
        
        Glide.with(holder.imageView.context)
            .load(fruit.image)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .placeholder(android.R.drawable.ic_menu_gallery)
            .error(android.R.drawable.ic_menu_report_image)
            .centerCrop()
            .into(holder.imageView)

        holder.itemView.setOnClickListener {
            onItemClick(fruit)
        }
    }

    override fun getItemCount() = fruits.size
} 