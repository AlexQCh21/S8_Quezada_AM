package com.cursokotlin.s8_quezada.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cursokotlin.s8_quezada.R
import com.cursokotlin.s8_quezada.recyclerviewgame.Game
import com.cursokotlin.s8_quezada.recyclerviewgame.GameAdapter
import com.google.android.material.carousel.CarouselLayoutManager
import com.cursokotlin.s8_quezada.recyclerviewportada.CarouselAdapter

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class HomeFragment : Fragment() {

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
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        chargerRecycler(view)
        chargerCardGames(view)
    }

    fun chargerRecycler(view: View) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.carousel_recycler_view)
        val adapter = CarouselAdapter(getImageList())
        recyclerView.adapter = adapter

        val carouselLayoutManager = CarouselLayoutManager()
        recyclerView.layoutManager = carouselLayoutManager

    }

    fun chargerCardGames(view: View) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.rvGames)
        val adapter = GameAdapter(getImageListGame())
        recyclerView.adapter = adapter

        // Layout horizontal (tarjetas una al lado de otra)
        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = layoutManager
    }


    private fun getImageList(): List<Int> {
        return listOf(
            R.drawable.god_of_war,
            R.drawable.gta_v,
            R.drawable.village,
            R.drawable.spiderman
        )
    }

    private fun getImageListGame(): List<Game> {
        return listOf(
            Game("GTA V", R.drawable.gta_v,10, 30.0),
            Game("Village Resident Evil", R.drawable.village,0, 60.0),
            Game("Spiderman", R.drawable.spiderman,0, 120.0),
            Game("God of War", R.drawable.god_of_war,15, 110.0)
        )
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}