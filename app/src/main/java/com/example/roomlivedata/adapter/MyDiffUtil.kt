package com.example.roomlivedata.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.roomlivedata.model.User

class MyDiffUtil(val oldList: List<User>, val newList: List<User>) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return when {
            oldList[oldItemPosition].id != newList[newItemPosition].id -> false
            oldList[oldItemPosition].name != newList[newItemPosition].name -> false
            oldList[oldItemPosition].old != newList[newItemPosition].old -> false
            else -> true
        }
    }
}