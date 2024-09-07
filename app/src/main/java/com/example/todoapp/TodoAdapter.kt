package com.example.todoapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.databinding.TodoItemBinding


class TodoAdapter(
    val onItemClick: (Todo) -> Unit, val onItemDelete: (Todo) -> Unit
) : RecyclerView.Adapter<TodoAdapter.TodoHolder>() {

    private val todoList: MutableList<Todo> = mutableListOf()

    override fun getItemCount() = todoList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoHolder {
        val binding = TodoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TodoHolder(binding)
    }

    inner class TodoHolder(val binding: TodoItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindData(todo: Todo) {
            binding.todo = todo
            binding.root.setOnClickListener { onItemClick(todo) }
        }
    }

    override fun onBindViewHolder(holder: TodoHolder, position: Int) {
        holder.bindData(todoList[position])
    }

    fun setTODOList(list: List<Todo>) {
        val diffUtil = MyDiffUtil(todoList, list)
        val diffResult = DiffUtil.calculateDiff(diffUtil)
        todoList.clear()
        todoList.addAll(list)
        diffResult.dispatchUpdatesTo(this)
    }
}

