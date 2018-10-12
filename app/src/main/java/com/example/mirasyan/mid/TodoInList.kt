package com.example.mirasyan.mid

import android.os.Parcel
import android.os.Parcelable

data class TodoInList(var title: String, var date: String): Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(date)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<TodoInList> {
        override fun createFromParcel(parcel: Parcel): TodoInList {
            return TodoInList(parcel)
        }

        override fun newArray(size: Int): Array<TodoInList?> {
            return arrayOfNulls(size)
        }
    }

}