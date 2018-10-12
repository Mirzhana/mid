package com.example.mirasyan.mid

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_todo.view.*
import java.util.ArrayList

class  TodoAdapter(var context: Context, var dataset: ArrayList<Todo>): RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return NewsViewHolder(LayoutInflater.from(context).inflate(R.layout.activity_to_do_in_list, parent, false))
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var news = dataset[position]
        holder.itemView.titleText.text = news.title
        holder.itemView.dateText.text = news.date

    }
    inner class NewsViewHolder(view: View): RecyclerView.ViewHolder(view)
}