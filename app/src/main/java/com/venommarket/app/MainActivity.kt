package com.venommarket.app

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val pantalla = LinearLayout(this)
        pantalla.orientation = LinearLayout.VERTICAL
        pantalla.gravity = Gravity.CENTER
        pantalla.setBackgroundColor(Color.WHITE)
        pantalla.setPadding(32, 32, 32, 32)

        val titulo = TextView(this)
        titulo.text = "VENOM MARKET"
        titulo.textSize = 32f
        titulo.setTextColor(Color.BLACK)
        titulo.gravity = Gravity.CENTER

        val subtitulo = TextView(this)
        subtitulo.text = "Tu mercado, en un solo lugar"
        subtitulo.textSize = 18f
        subtitulo.setTextColor(Color.DKGRAY)
        subtitulo.gravity = Gravity.CENTER

        pantalla.addView(titulo)
        pantalla.addView(subtitulo)

        setContentView(pantalla)
    }
}