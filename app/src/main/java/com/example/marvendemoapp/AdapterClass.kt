package com.example.marvendemoapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.marvendemoapp.Model.TmdbData
import kotlinx.coroutines.withContext

class AdapterClass(private val mList: MutableList<Result>) : RecyclerView.Adapter<AdapterClass.ViewHolder>() {
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.popularImageView)
        val textView: TextView = itemView.findViewById(R.id.popularText)
        val textView2: TextView = itemView.findViewById(R.id.popularText2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row1, parent, false)
        return ViewHolder(view)
    }
    override fun getItemCount(): Int {
        return mList.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val mList = mList[position]
      Glide.with(holder.itemView.context).load("https://image.tmdb.org/t/p/w500${mList.poster_path}").into(holder.imageView)
        holder.textView.text= mList.title
        holder.textView2.text= mList.release_date
    }

}