package com.example.introduccionkotlin

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    companion object{
        const val moneda = "COL"
    }

    var saldo : Float = 300.54f
    var sueldo : Float = 764.82f
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val fecha = "10/06/1991"
        var nombre = "jota"
        var saludo = "HOLA" + nombre
        var vip : Boolean = false
        if (vip )
        saldo += sueldo
        if (vip == true) saludo += "Te queremos mucho"
        else saludo += "Quieres ser vip? paga la cuota"
        println (saludo)

        }
}
