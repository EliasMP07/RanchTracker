package com.devdroid.ranchtracker.iu.bovino.view.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.devdroid.ranchtracker.R
import com.devdroid.ranchtracker.data.source.local.entities.BovinoEntity
import com.devdroid.ranchtracker.databinding.ItemBovinoBinding
import com.devdroid.ranchtracker.domain.model.BovinoItem

class BovinoAdapter(private val iOnClickListener: IOnClcikListener) : ListAdapter<BovinoItem, BovinoAdapter.BindViewHolder>(DifffCallBack) {

    interface IOnClcikListener{
        fun clickEliminar(bovinoItem: BovinoItem)
    }

    private object DifffCallBack: DiffUtil.ItemCallback<BovinoItem>() {
        override fun areItemsTheSame(oldItem: BovinoItem, newItem: BovinoItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: BovinoItem, newItem: BovinoItem): Boolean {
            return oldItem == newItem
        }

    }
    inner class BindViewHolder(private val binding: ItemBovinoBinding): RecyclerView.ViewHolder(binding.root){
        fun enlazar(bovinoItem: BovinoItem){
            binding.apply {
                numArete.text = bovinoItem.numArete
                genderType.text = bovinoItem.genderType
                peso.text = bovinoItem.peso.toString()
                date.text = bovinoItem.año.toString()
                tipo.text = bovinoItem.categoryType


            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindViewHolder {
        return BindViewHolder(
            ItemBovinoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: BindViewHolder, position: Int) {
        val bovino = getItem(position)

        holder.enlazar(bovino)
    }


}