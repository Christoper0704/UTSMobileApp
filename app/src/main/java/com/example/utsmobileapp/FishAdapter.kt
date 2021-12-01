package com.example.utsmobileapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FishAdapter (private val FishList : ArrayList<FishFirebase>) : RecyclerView.Adapter<FishAdapter.FishHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FishAdapter.FishHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_ikan, parent, false)

        return FishHolder(itemView)
    }

    override fun onBindViewHolder(holder: FishAdapter.FishHolder, position: Int) {
        val firebase : FishFirebase = FishList[position]
        holder.namaikan.text = firebase.nama
    }

    override fun getItemCount(): Int {
        return FishList.size
    }

    public class FishHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val namaikan : TextView = itemView.findViewById(R.id.textnama)
    }
}