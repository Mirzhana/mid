package com.example.mirasyan.mid

import android.app.Activity
import android.content.Intent
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_login.*

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_main.view.*
import kotlinx.android.synthetic.main.fragment_todo.*
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    private var mSectionsPagerAdapter: SectionsPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        val myDB = TodoDatabase.getInstance(this)

        loadData(myDB!!)
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)

        // Set up the ViewPager with the sections adapter.
        container.adapter = mSectionsPagerAdapter

        container.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs))
        tabs.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(container))
        loadData(myDB!!)

        fab.setOnClickListener {

            //                val list = myDB?.newsDao()?.getAll()
//                val news = News(list!!.size + 1, "Title 1", "02-02-1998", "lasdfjlsdfj")
//                myDB.newsDao().insert(news)
//
//                loadData(myDB)

            startActivityForResult(Intent(this, AddTodoActivity::class.java), 1)


        }
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId

        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }
    inner class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment = when (position){
            0 -> TodoFragment()
            1 -> DoneFragment()
            else -> TodoFragment()

        }

        override fun getCount(): Int {

            return 2
        }
    }

    fun loadData(myDB: TodoDatabase) {
        val dataset: ArrayList<Todo> = ArrayList()
        thread {
            val list = myDB.todoDao().getAll()
            for (i in 0..(list.size - 1)) {
                dataset.add(list[i])
            }

            onDataLoaded(dataset)
        }
    }

    fun onDataLoaded(dataset: ArrayList<Todo>) {
        runOnUiThread {
            todoRecyclerView.layoutManager = LinearLayoutManager(this)
            todoRecyclerView.adapter = TodoAdapter(this, dataset)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                val result = data?.getParcelableExtra<Todo>("news")
                val myDB = TodoDatabase.getInstance(this)
                thread {
                    val list = myDB?.todoDao()?.getAll()
                    result?.id =  list!!.size + 1
                    myDB.todoDao().insert(result!!)

                    loadData(myDB)
                }
            }
        }
    }
}
