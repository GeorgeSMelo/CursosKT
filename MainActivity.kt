package com.example.introduccionkotlin

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    companion object {
        const val moneda = "COL"
    }

    var saldo: Float = 300.54f
    var sueldo: Float = 764.82f
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val fecha = "10/06/1991"
        var nombre = "jota"
        var saludo = "HOLA" + nombre
        var vip: Boolean = false
        if (vip) {
            saldo += sueldo
        }
        if (vip == true) saludo += "Te queremos mucho"
        else saludo += "Quieres ser vip? paga la cuota"

        var mes = fecha.subSequence(3, 5).toString().toInt()
        when (mes) {
            1 -> print("\n En Enero hay la super oferta del 7% de interes")
            2, 3 -> print("\n En invierno ni hay ofertas de inversiones")
            4, 5, 6 -> print("\n En primavera hay ofertas de inversiones con el 1.5% de interes")
            7, 8, 9 -> print("\n En verano hay ofertas de inversiones con el 2,5% de interes")
            10, 11, 12 -> print("\n En otoño hay ofertas de inversiones con el 3.5% de interes")
            else -> print("\n La fecha es erronea")
        }


        println(saludo)
        var PIN: Int = 1234
        var Intentos: Int = 0
        var ClaveIngresada: Int = 1232
        do {
            println("Ingrese el PIN: ")
            println("Clave Ingresada: + ${ClaveIngresada++}")
            Intentos++
        } while (Intentos < 3  && ClaveIngresada != PIN)

    }
}

