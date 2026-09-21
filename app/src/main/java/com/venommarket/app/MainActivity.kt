package com.venommarket.app

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView

class MainActivity : Activity() {

    private var carrito = 0
    private lateinit var carritoTexto: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val scroll = ScrollView(this)

        val pantalla = LinearLayout(this)
        pantalla.orientation = LinearLayout.VERTICAL
        pantalla.setPadding(24, 24, 24, 24)
        pantalla.setBackgroundColor(Color.WHITE)

        val titulo = TextView(this)
        titulo.text = "VENOM MARKET"
        titulo.textSize = 30f
        titulo.setTextColor(Color.BLACK)
        titulo.gravity = Gravity.CENTER
        titulo.setPadding(0, 20, 0, 8)

        val subtitulo = TextView(this)
        subtitulo.text = "Tu mercado, en un solo lugar"
        subtitulo.textSize = 17f
        subtitulo.setTextColor(Color.DKGRAY)
        subtitulo.gravity = Gravity.CENTER
        subtitulo.setPadding(0, 0, 0, 24)

        carritoTexto = TextView(this)
        carritoTexto.text = "🛒 Carrito: 0 productos"
        carritoTexto.textSize = 18f
        carritoTexto.setTextColor(Color.BLACK)
        carritoTexto.setPadding(0, 12, 0, 20)

        val categorias = TextView(this)
        categorias.text = "CATEGORÍAS"
        categorias.textSize = 20f
        categorias.setTextColor(Color.BLACK)
        categorias.setPadding(0, 8, 0, 12)

        pantalla.addView(titulo)
        pantalla.addView(subtitulo)
        pantalla.addView(carritoTexto)
        pantalla.addView(categorias)

        agregarProducto(pantalla, "Arroz", "850 CUP / kg")
        agregarProducto(pantalla, "Frijoles", "940 CUP / kg")
        agregarProducto(pantalla, "Picadillo", "600 CUP / lb")
        agregarProducto(pantalla, "Huevos", "180 CUP / unidad")
        agregarProducto(pantalla, "Boniato", "80 CUP / lb")
        agregarProducto(pantalla, "Espagueti", "420 CUP")

        val pedidos = Button(this)
        pedidos.text = "VER CARRITO Y PEDIDO"
        pedidos.textSize = 16f

        pedidos.setOnClickListener {
            carritoTexto.text = "🛒 Carrito: $carrito productos"
        }

        pantalla.addView(pedidos)

        scroll.addView(pantalla)
        setContentView(scroll)
    }

    private fun agregarProducto(
        contenedor: LinearLayout,
        nombre: String,
        precio: String
    ) {
        val fila = LinearLayout(this)
        fila.orientation = LinearLayout.VERTICAL
        fila.setPadding(0, 8, 0, 16)

        val producto = TextView(this)
        producto.text = "$nombre\n$precio"
        producto.textSize = 18f
        producto.setTextColor(Color.BLACK)

        val boton = Button(this)
        boton.text = "AGREGAR AL CARRITO"

        boton.setOnClickListener {
            carrito++
            carritoTexto.text = "🛒 Carrito: $carrito productos"
        }

        fila.addView(producto)
        fila.addView(boton)
        contenedor.addView(fila)
    }
}