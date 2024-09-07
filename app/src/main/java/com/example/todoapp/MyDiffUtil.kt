package com.example.todoapp

import androidx.recyclerview.widget.DiffUtil

class MyDiffUtil(
    val oldList: List<Todo>,
    val newList: List<Todo>
) : DiffUtil.Callback() {
    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].ID == newList[newItemPosition].ID
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}