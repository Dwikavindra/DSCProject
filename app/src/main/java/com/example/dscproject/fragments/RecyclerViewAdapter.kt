package com.example.dscproject.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dscproject.OnPilihanClickListener
import com.example.dscproject.R
import com.example.dscproject.model.Sessions


class RecyclerViewAdapter(private var sessions: List<Sessions>,private val onPilihanClickListener: OnPilihanClickListener):
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val session: TextView = itemView.findViewById(R.id.Sesi)
        val waktu: TextView = itemView.findViewById(R.id.waktu)
        val dokter1ruang: TextView = itemView.findViewById(R.id.Ruang2)
        val dokter1nama: TextView = itemView.findViewById(R.id.namadokter2)
        val dokter2ruang: TextView = itemView.findViewById(R.id.Ruang1)
        val dokter2nama: TextView = itemView.findViewById(R.id.namadokter)
        val dokter3ruang: TextView = itemView.findViewById(R.id.Ruang3)
        val dokter3nama: TextView = itemView.findViewById(R.id.namadokter3)
        val buttonpilihan1: Button =itemView.findViewById(R.id.buttonPilih1)
        val buttonpilihan2: Button =itemView.findViewById(R.id.buttonPilih2)
        val buttonpilihan3: Button =itemView.findViewById(R.id.buttonPilih3)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val v=LayoutInflater.from(parent.context).inflate(R.layout.session_layout, parent, false)

        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return sessions.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      holder.session.text=sessions[position].sessions
        holder.waktu.text=sessions[position].time
        holder.dokter1ruang.text=sessions[position].idRuangan[0]
        holder.dokter1nama.text=sessions[position].namadokter[0]
        holder.dokter2ruang.text=sessions[position].idRuangan[1]
        holder.dokter2nama.text=sessions[position].namadokter[1]
        holder.dokter3ruang.text=sessions[position].idRuangan[2]
        holder.dokter3nama.text=sessions[position].namadokter[2]
        holder.buttonpilihan1.setOnClickListener {
          onPilihanClickListener.onPilihanItemClicked()
        }
        holder.buttonpilihan2.setOnClickListener{
            onPilihanClickListener.onPilihanItemClicked()
        }
        holder.buttonpilihan3.setOnClickListener{
            onPilihanClickListener.onPilihanItemClicked()
        }
    }

    }




