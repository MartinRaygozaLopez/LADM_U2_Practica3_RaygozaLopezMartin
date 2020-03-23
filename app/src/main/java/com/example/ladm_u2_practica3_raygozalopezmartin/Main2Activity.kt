package com.example.ladm_u2_practica3_raygozalopezmartin

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {
    var puntos : Array<Int> = Array(4, {0})

    var dado1 = 0
    var dado2 = 0

    var jugador = 0
    var rondas = 1

    var imgDado1 : ImageView ?= null
    var imgDado2 : ImageView ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        btnIniciar.setOnClickListener {
            imgDado1 = findViewById(R.id.imgDado1)
            imgDado2 = findViewById(R.id.imgDado2)
            dado1 = 0
            dado2 = 0
            jugador = 0
            rondas = 1
            puntos = Array(4, {0})
            lblRondas.setText("Ronda 1")
            lblPuntosJ1.setText("Puntos: 0")
            lblPuntosJ2.setText("Puntos: 0")
            lblPuntosJ3.setText("Puntos: 0")
            lblPuntosJ4.setText("Puntos: 0")
            lblTirando.setText("Espere, Iniciando juego...")
            var hilo = HiloControl(this)
            hilo.start()
            btnIniciar.visibility = View.INVISIBLE
        }
    }

    fun obtenerNumeroDados() : Int {
        return (1..6).random().toInt()
    }

    fun sumarPuntos() {
        when(dado1){
            1 -> {
                imgDado1?.setImageResource(R.drawable.uno)
                puntos[jugador] += 1
            }
            2 -> {
                imgDado1?.setImageResource(R.drawable.dos)
                puntos[jugador] += 2
            }
            3 -> {
                imgDado1?.setImageResource(R.drawable.tres)
                puntos[jugador] += 3
            }
            4 -> {
                imgDado1?.setImageResource(R.drawable.cuatro)
                puntos[jugador] += 4
            }
            5 -> {
                imgDado1?.setImageResource(R.drawable.cinco)
                puntos[jugador] += 5
            }
            6 -> {
                imgDado1?.setImageResource(R.drawable.seis)
                puntos[jugador] += 6
            }
        }

        when(dado2){
            1 -> {
                imgDado2?.setImageResource(R.drawable.uno)
                puntos[jugador] += 1
            }
            2 -> {
                imgDado2?.setImageResource(R.drawable.dos)
                puntos[jugador] += 2
            }
            3 -> {
                imgDado2?.setImageResource(R.drawable.tres)
                puntos[jugador] += 3
            }
            4 -> {
                imgDado2?.setImageResource(R.drawable.cuatro)
                puntos[jugador] += 4
            }
            5 -> {
                imgDado2?.setImageResource(R.drawable.cinco)
                puntos[jugador] += 5
            }
            6 -> {
                imgDado2?.setImageResource(R.drawable.seis)
                puntos[jugador] += 6
            }
        }
    }

    fun asignarPuntos(puntos : Int, jugador : Int) {
        when(jugador) {
            0 -> {
                lblPuntosJ1.setText("Puntos: ${puntos}")
            }
            1 -> {
                lblPuntosJ2.setText("Puntos: ${puntos}")
            }
            2 -> {
                lblPuntosJ3.setText("Puntos: ${puntos}")
            }
            3 -> {
                lblPuntosJ4.setText("Puntos: ${puntos}")
            }
        }
    }

    fun mostrarGanador() {
        var puntajeFinal = ArrayList<Int>()

        puntajeFinal.add(puntos[0])
        puntajeFinal.add(puntos[1])
        puntajeFinal.add(puntos[2])
        puntajeFinal.add(puntos[3])

        var ganador = ""

        if(puntajeFinal[0] == puntajeFinal.max()){
            ganador = "JUGADOR 1"
        }

        if(puntajeFinal[1] == puntajeFinal.max()){
            ganador = "JUGADOR 2"
        }

        if(puntajeFinal[2] == puntajeFinal.max()){
            ganador = "JUGADOR 3"
        }

        if(puntajeFinal[3] == puntajeFinal.max()){
            ganador = "JUGADOR 4"
        }

        AlertDialog.Builder(this)
            .setTitle("¡FELICIDADES!")
            .setMessage(ganador + " EN HORA BUEN, ES EL GANADOR")
            .setPositiveButton("OK") {p, i -> }
            .show()
    }
}
