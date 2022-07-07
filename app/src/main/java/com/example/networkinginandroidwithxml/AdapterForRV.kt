package com.example.networkinginandroidwithxml

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.networkinginandroidwithxml.databinding.TodoLayoutForRvBinding

//class AdapterForRV : RecyclerView.Adapter<AdapterForRV.ViewHolderRV>() {
class AdapterForRV : ListAdapter<Todo, AdapterForRV.ViewHolderRV>(DiffUtilCallback()) {

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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderRV =
        ViewHolderRV.inflateFrom(parent)

    override fun onBindViewHolder(holder: ViewHolderRV, position: Int) {
        val item = getItem(position)
        holder.bind(item)

    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}