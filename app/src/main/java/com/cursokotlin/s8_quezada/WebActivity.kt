package com.cursokotlin.s8_quezada

import android.os.Bundle
import android.webkit.WebViewClient
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cursokotlin.s8_quezada.databinding.ActivityWebBinding

class WebActivity : AppCompatActivity() {

    private lateinit var binding:ActivityWebBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityWebBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnRegresar.setOnClickListener{
            finish()
        }

        val url = intent.getStringExtra("url")?:""

        // Habilitar JavaScript si el sitio lo necesita
        binding.webView.settings.javaScriptEnabled = true

        // Para que el enlace se abra dentro del WebView y no en el navegador externo
        binding.webView.webViewClient = WebViewClient()

        // Cargar una URL (puede ser local o remota)
        binding.webView.loadUrl(url)
    }
}