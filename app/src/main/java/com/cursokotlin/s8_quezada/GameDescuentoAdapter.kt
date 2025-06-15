package com.cursokotlin.s8_quezada

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cursokotlin.s8_quezada.recyclerviewgame.Game
import com.cursokotlin.s8_quezada.recyclerviewgame.GameAdapter.GameHolder

class GameDescuentoAdapter (private val listGame:List<Game>): RecyclerView.Adapter<GameDescuentoAdapter.GameDescuentoHolder>() {
    class GameDescuentoHolder(view: View):RecyclerView.ViewHolder(view){
        var img: ImageView = itemView.findViewById<ImageView>(R.id.img)
        val nombre: TextView = itemView.findViewById<TextView>(R.id.nombre)
        val precio: TextView = itemView.findViewById<TextView>(R.id.precio)
        val desct: TextView = itemView.findViewById<TextView>(R.id.desct)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameDescuentoHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.carousel_item_desct_game,parent,false)
        return GameDescuentoHolder(view)
    }

    override fun getItemCount(): Int = listGame.size

    override fun onBindViewHolder(holder: GameDescuentoHolder, position: Int) {
        holder.img.setImageResource(listGame[position].image)
        holder.nombre.text = listGame[position].name
        holder.precio.text = "$${listGame[position].precio}"
        holder.desct.text = "$${listGame[position].desct}% desct"
    }
}