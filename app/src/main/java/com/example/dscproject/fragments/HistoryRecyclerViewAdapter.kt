package com.example.dscproject.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dscproject.OnPilihanClickListener
import com.example.dscproject.R
import com.example.dscproject.model.History
import com.example.dscproject.model.Sessions
import org.w3c.dom.Text


class HistoryRecyclerViewAdapter(private var history: List<History>):
    RecyclerView.Adapter<HistoryRecyclerViewAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val namadokter:TextView=itemView.findViewById(R.id.namadoktera)
        val nourut:TextView=itemView.findViewById(R.id.nourutan)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val v=LayoutInflater.from(parent.context).inflate(R.layout.history_layout, parent, false)

        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return history.size

    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.namadokter.text=history[position].namadokter
        holder.nourut.text=history[position].nourut
    }


}