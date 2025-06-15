package com.cursokotlin.s8_quezada

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.PopupMenu
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cursokotlin.s8_quezada.databinding.ActivityMainBinding
import com.cursokotlin.s8_quezada.fragments.CategoryFragment
import com.cursokotlin.s8_quezada.fragments.DescuentoFragment
import com.cursokotlin.s8_quezada.fragments.HomeFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(
                v.paddingLeft,
                systemBars.top,
                v.paddingRight,
                v.paddingBottom
            )
            insets
        }

        initIconMenu()
        bottomNavigation(binding)
    }


    private fun bottomNavigation(binding: ActivityMainBinding) {
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.item_1 -> {
                    showHomeFragmentHome()
                    true
                }
                R.id.item_2 -> {
                    showHomeFragmentCategory()
                    true
                }
                R.id.item_3 -> {
                    showHomeFragmentDesct()
                    true
                }
                else -> false
            }
        }
    }


    private fun initIconMenu(){
        val iconButton = findViewById<ImageButton>(R.id.iconButton)

        iconButton.setOnClickListener {
            val popup = PopupMenu(this, iconButton)
            popup.menuInflater.inflate(R.menu.overflow_menu, popup.menu)

            popup.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.option_1 -> {
                        irASoporte()
                        true
                    }
                    R.id.option_2 -> {
                        irAReembolso()
                        true
                    }
                    R.id.option_3 -> {
                        irAAcercaDe()
                        true
                    }
                    else -> false
                }
            }

            popup.show()
        }

    }

    fun showHomeFragmentHome(){
        val homeFragment = HomeFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, homeFragment)
            .addToBackStack(null)
            .commit()
    }

    fun showHomeFragmentCategory(){
        val homeFragment = CategoryFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, homeFragment)
            .addToBackStack(null)
            .commit()
    }

    fun showHomeFragmentDesct(){
        val homeFragment = DescuentoFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, homeFragment)
            .addToBackStack(null)
            .commit()
    }

    fun irASoporte(){
        val intent = Intent(this, WebActivity::class.java)
        intent.putExtra("url", "https://help.steampowered.com/es/")
        startActivity(intent)
    }

    fun irAReembolso(){
        val intent = Intent(this, WebActivity::class.java)
        intent.putExtra("url", "https://store.steampowered.com/steam_refunds/")
        startActivity(intent)
    }

    fun irAAcercaDe(){
        val intent = Intent(this, WebActivity::class.java)
        intent.putExtra("url", "https://www.valvesoftware.com/es/about")
        startActivity(intent)
    }

}