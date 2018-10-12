package com.example.mirasyan.mid

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface TodoDAO{
    @Query("Select * FROM todo")
    fun getAll():List<Todo>
    @Insert
    fun insert(news:Todo)

}