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
    var entero: Int = 12


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val fecha = "01/06/1991"
        var nombre = "jota"
        var saludo = "HOLA" + nombre
        var vip: Boolean = false
        if (vip) {
            saldo += sueldo
        }
        if (vip == true) saludo += "Te queremos mucho"
        else saludo += "Quieres ser vip? paga la cuota"
        mostrar_saldo()
        ingresar_dinero(50.40f)
        retirar_dinero(40.30f)
        retirar_dinero(40.30f)
        retirar_dinero(2040.30f)
        var dia = fecha.subSequence(0, 2).toString().toInt()
        if (dia == 1) ingresar_sueldo()

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
        var ClaveIngresada: Int = 1233
        do {
            println("Ingrese el PIN: ")
            println("Clave Ingresada: + ${ClaveIngresada++}")
            Intentos++
        } while (Intentos < 3 && ClaveIngresada != PIN)

        if (Intentos == 3) println("Tarjeta Bloqueada")

        mostrar_saldo()
    }

    fun mostrar_saldo() {
        println("Tienes $saldo $moneda")
    }

    fun ingresar_sueldo() {
        saldo += sueldo
        println("Se ha ingresado tu sueldo de $sueldo $moneda")
        mostrar_saldo()
    }

    fun ingresar_dinero(cantidad: Float) {
        saldo += cantidad
        println("Se ha ingresado tu sueldo de $cantidad $moneda")
        mostrar_saldo()
    }

    fun retirar_dinero(cantidad: Float) {
        if (verificarCantidad(cantidad)){
            saldo -= cantidad
        println("Se ha retirado tu sueldo de $cantidad $moneda")
        mostrar_saldo()
    }
    else println("Cantidad superior al saldo. Imposible realizar la operación")
}

    fun verificarCantidad(cantidad_a_retirar: Float): Boolean{
        if (cantidad_a_retirar > saldo) return false
        else return true
    }
}

