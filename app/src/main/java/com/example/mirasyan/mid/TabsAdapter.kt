package com.example.mirasyan.mid

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_to_do_in_list.view.*

class TabsAdapter(var context: Context, var dataset: ArrayList<TodoInList>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        return TodoViewHolder(LayoutInflater.from(context).inflate(R.layout.activity_to_do_in_list, p0, false))

    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {
        val item = dataset[p1]
        p0.itemView.title.text = item.title
        p0.itemView.date.text = item.date

    }


    inner class TodoViewHolder(view: View) : RecyclerView.ViewHolder(view){
        init {
            view.card.setOnClickListener{
                context.startActivity(Intent(context, TodoActivity::class.java).putExtra("item",dataset[adapterPosition]))
            }
        }

    }


}