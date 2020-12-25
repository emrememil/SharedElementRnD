package com.example.sharedelementrnd.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.sharedelementrnd.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_small_images.view.*

class SmallImageListAdapter(val context: Context, val clickListener: SmallImageItemClickListener) :
    RecyclerView.Adapter<SmallImageHolder>() {

    private lateinit var items: List<Int>

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): SmallImageHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_small_images, p0, false)
        return SmallImageHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(p0: SmallImageHolder, p1: Int) {
        val item = items.get(p1)
        p0.bindItem(item)
        p0.itemView.setOnClickListener(View.OnClickListener {
            clickListener.onItemClick(item, p0.itemView.ivSmallImage)
        })
    }

    fun setItems(items: List<Int>) {
        this.items = items
        notifyDataSetChanged()
    }
}

class SmallImageHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bindItem(item: Int) {
        Picasso.get().load(item).resize(512,512).into(itemView.ivSmallImage)
    }
}

interface SmallImageItemClickListener {
    fun onItemClick(item: Int, imageView: ImageView)
}
