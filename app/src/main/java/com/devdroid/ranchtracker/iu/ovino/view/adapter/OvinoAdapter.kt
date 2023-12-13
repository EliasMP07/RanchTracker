package com.devdroid.ranchtracker.iu.ovino.view.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.devdroid.ranchtracker.databinding.ItemOvinoBinding
import com.devdroid.ranchtracker.domain.model.OvinoItem

class OvinoAdapter(private val listener: OnItemClickListener) :
    ListAdapter<OvinoItem, OvinoAdapter.OvinoViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OvinoViewHolder {
        return OvinoViewHolder(
            ItemOvinoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: OvinoViewHolder, position: Int) {
        val ovino = getItem(position)
        holder.bind(ovino)
    }

    inner class OvinoViewHolder(private val binding: ItemOvinoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(ovino: OvinoItem) {
            binding.apply {

            }
        }
    }

    interface OnItemClickListener {
        fun onItemClickDelete(ovino: OvinoItem)
    }

    class DiffCallback : DiffUtil.ItemCallback<OvinoItem>() {
        override fun areItemsTheSame(oldItem: OvinoItem, newItem: OvinoItem) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: OvinoItem, newItem: OvinoItem) =
            oldItem == newItem
    }
}