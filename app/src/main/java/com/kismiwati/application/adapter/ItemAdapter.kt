package com.kismiwati.application.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kismiwati.application.R
import com.kismiwati.application.model.Resto

class ItemAdapter (private  val context: Context,
                   private val dataset: List<Resto>)
    : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>(){

    //digunakan untuk memberikan referensi ke tampilan ke tampilan untuk setiap item data dan gambar
    //digunakan untuk memberikan akses ke semua tampilan untuk item data dalam tampilan

    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title)
        val imageView: ImageView = view.findViewById(R.id.item_image)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int): ItemViewHolder {
        //membuat sebuah view
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return  ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text = context.resources.getString(item.StringResourceId)
        holder.imageView.setImageResource(item.imageResourceId)
    }

    override fun getItemCount() = dataset.size
}