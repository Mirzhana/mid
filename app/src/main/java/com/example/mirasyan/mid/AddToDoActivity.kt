package com.example.mirasyan.mid

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class AddToDoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_to_do)

        addBtn.setOnClickListener {
            val title = titleEditText.text.toString()
            val description = descrEditText.text.toString()
            val todo = Todo(0, title, "11-10-2018", description)

            setResult(Activity.RESULT_OK, Intent().
                    putExtra("news", news))
            finish()
        }
    }
}
