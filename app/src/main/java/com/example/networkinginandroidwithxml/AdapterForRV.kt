package com.example.networkinginandroidwithxml

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.networkinginandroidwithxml.databinding.TodoLayoutForRvBinding


class AdapterForRV : RecyclerView.Adapter<AdapterForRV.ViewHolderRV>() {
/*
class AdapterForRV : ListAdapter<Todo, AdapterForRV.ViewHolderRV>(DiffUtilCallback()) {
*/

    class ViewHolderRV(private val binding: TodoLayoutForRvBinding) :
        RecyclerView.ViewHolder(binding.root) {

        companion object {
            //parent refers to the RecyclerView
            fun inflateFrom(parent: ViewGroup): ViewHolderRV {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = TodoLayoutForRvBinding.inflate(layoutInflater, parent, false)
                return ViewHolderRV(binding)
            }
        }

        fun bind(item: Todo) {
            binding.tvTitle.text = item.title
            binding.cbDone.isChecked = item.completed
        }

    }

    private val diffCallback = object : DiffUtil.ItemCallback<Todo>() {
        override fun areItemsTheSame(oldItem: Todo, newItem: Todo): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Todo, newItem: Todo): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)
    var todos: List<Todo>
        get() = differ.currentList
        set(value) {
            differ.submitList(value)
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderRV =
        ViewHolderRV.inflateFrom(parent)

    override fun onBindViewHolder(holder: ViewHolderRV, position: Int) {
        val item = todos[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = todos.size
}