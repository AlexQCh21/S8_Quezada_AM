package com.cursokotlin.s8_quezada.recyclerviewgame

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cursokotlin.s8_quezada.R

class GameAdapter(private val listgame: List<Game>):RecyclerView.Adapter<GameAdapter.GameHolder>() {
    class GameHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var img: ImageView = itemView.findViewById<ImageView>(R.id.img)
        val nombre: TextView = itemView.findViewById<TextView>(R.id.nombre)
        val precio: TextView = itemView.findViewById<TextView>(R.id.precio)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.carousel_game_item,parent,false)
        return GameHolder(view)
    }

    override fun getItemCount(): Int = listgame.size

    override fun onBindViewHolder(holder: GameHolder, position: Int) {
        holder.img.setImageResource(listgame[position].image)
        holder.nombre.text = listgame[position].name
        holder.precio.text = "$${listgame[position].precio}"
    }
}