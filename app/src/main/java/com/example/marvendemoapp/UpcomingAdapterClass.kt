package com.example.marvendemoapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class UpcomingAdapterClass(private val myList:MutableList<Result>): RecyclerView.Adapter<UpcomingAdapterClass.ViewHolder>() {
    class ViewHolder(ItemView: View):RecyclerView.ViewHolder(ItemView){
        val imageView: ImageView = itemView.findViewById(R.id.UpcomingRatedImageView)
        val textView: TextView =itemView.findViewById(R.id.upcomingText)
        val textView2: TextView =itemView.findViewById(R.id.RatedText2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row3, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
      return myList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      val model =myList[position]
        holder.textView2.text=model.title
        holder.textView.text=model.release_date
        Glide.with(holder.itemView.context).load("https://image.tmdb.org/t/p/w500${model.poster_path}").into(holder.imageView)

    }
}