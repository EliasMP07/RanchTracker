package com.devdroid.ranchtracker.iu.bovino.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devdroid.ranchtracker.R
import com.devdroid.ranchtracker.data.local.database.entities.BovinoEntity

class BovinoAdapter(private var bovinos: MutableList<BovinoEntity>) : RecyclerView.Adapter<BovinoAdapter.ViewHolder>(){

    private lateinit var mContext: Context



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        mContext = parent.context

        val view = LayoutInflater.from(mContext).inflate(R.layout.item_bovino, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int = bovinos.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val bovino = bovinos[position]

        with(holder){

        }
    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){

    }
}