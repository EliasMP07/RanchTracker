package com.devdroid.ranchtracker.iu.ovino.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devdroid.ranchtracker.R
import com.devdroid.ranchtracker.data.models.OvinoModel

class OvinoAdapter(
    private var ovinos: MutableList<OvinoEntity>
): RecyclerView.Adapter<OvinoAdapter.ViewHolder>() {


    private lateinit var mContext: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        mContext = parent.context
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_ovino, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int = ovinos.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ovino = ovinos[position]

        with(holder){

        }
    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){



    }
}