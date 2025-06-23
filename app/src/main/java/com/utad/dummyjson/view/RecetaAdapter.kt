package com.utad.dummyjson.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.utad.dummyjson.model.Receta

class RecetaAdapter (private val onClick: (Receta) -> Unit) :
    RecyclerView.Adapter<RecetaAdapter.ViewHolder>() {

    private var items = listOf<Receta>()

    fun submitList(list: List<Receta>) {
        items = list
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ItemProductBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(product: Receta) {
            binding.title.text = product.title
            binding.name.text = product.title
            binding.difficulty.text= product.title
            binding.cuisine.text= product.title.
           // name, image, difficulty, cuisine, preparation time, cooking
            //time, ingredients e instructions.
            Glide.with(binding.root.context).load(product.image).into(binding.image)
            binding.root.setOnClickListener { onClick(product) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }
}
}