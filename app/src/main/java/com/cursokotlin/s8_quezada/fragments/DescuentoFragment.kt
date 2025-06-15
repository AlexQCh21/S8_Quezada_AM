package com.cursokotlin.s8_quezada.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cursokotlin.s8_quezada.GameDescuentoAdapter
import com.cursokotlin.s8_quezada.R
import com.cursokotlin.s8_quezada.recyclerviewgame.Game
import com.cursokotlin.s8_quezada.recyclerviewgame.GameAdapter

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class DescuentoFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_descuento, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        chargerCardGames(view)
    }

    fun chargerCardGames(view: View) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.carousel_recycler_view_game)
        val adapter = GameDescuentoAdapter(getImageListGame())
        recyclerView.adapter = adapter

        // Layout horizontal (tarjetas una al lado de otra)
        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = layoutManager
    }


    private fun getImageListGame(): List<Game> {
        return listOf(
            Game("GTA V", R.drawable.gta_v,10, 30.0),
            Game("Fifa 2025", R.drawable.deportes,12, 60.0),
            Game("Goat Simulator", R.drawable.simulation,15, 120.0),
            Game("God of War", R.drawable.god_of_war,15, 110.0)
        )
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DescuentoFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}