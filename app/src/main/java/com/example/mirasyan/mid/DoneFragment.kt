package com.example.mirasyan.mid

import android.content.res.Configuration
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class DoneFragment : Fragment()
{
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_done, container, false)
        val dataset = ArrayList<TodoInList>()
        for (i in 1..15){
            dataset.add(TodoInList("New title"+i.toString(), "13-11-1997"))
        }
        val doneRecyclerView = root.findViewById(R.id.doneRecyclerView) as RecyclerView
        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            doneRecyclerView.layoutManager = GridLayoutManager(activity, 2)
        } else{
            doneRecyclerView.layoutManager = LinearLayoutManager(activity)
        }
        doneRecyclerView.adapter = TabsAdapter(activity!!, dataset)

        return root

    }
}