package com.example.ladm_u2_practica3_raygozalopezmartin

import android.view.View
import kotlinx.android.synthetic.main.activity_main2.*

class HiloControl(p : Main2Activity) : Thread(){
    var puntero = p
    var iniciado = false

    //Función en la cual se programara lo que hará el hilo en ejecución
    override fun run() {
        super.run()
        iniciado = true
        while(iniciado) {
            sleep(2000)
            puntero.runOnUiThread {

                if (puntero.jugador == 4) {
                    puntero.rondas++
                    puntero.jugador = 0
                    if (puntero.rondas == 5) {
                        puntero.lblEstadoJ4.setText("Estado: Pausado")
                        puntero.lblTirando.setText("   Juego terminado")
                        detener()
                        puntero.rondas = 4
                    }
                    puntero.lblRondas.setText("Rondas " + puntero.rondas)
                }

                if(iniciado) {
                    when (puntero.jugador) {
                    0 -> {
                        puntero.lblEstadoJ1.setText("Estado: Activo")
                        puntero.lblEstadoJ2.setText("Estado: Pausado")
                        puntero.lblEstadoJ3.setText("Estado: Pausado")
                        puntero.lblEstadoJ4.setText("Estado: Pausado")
                    }
                    1 -> {
                        puntero.lblEstadoJ1.setText("Estado: Pausado")
                        puntero.lblEstadoJ2.setText("Estado: Activo")
                        puntero.lblEstadoJ3.setText("Estado: Pausado")
                        puntero.lblEstadoJ4.setText("Estado: Pausado")
                    }
                    2 -> {
                        puntero.lblEstadoJ1.setText("Estado: Pausado")
                        puntero.lblEstadoJ2.setText("Estado: Pausado")
                        puntero.lblEstadoJ3.setText("Estado: Activo")
                        puntero.lblEstadoJ4.setText("Estado: Pausado")
                    }
                    3 -> {
                        puntero.lblEstadoJ1.setText("Estado: Pausado")
                        puntero.lblEstadoJ2.setText("Estado: Pausado")
                        puntero.lblEstadoJ3.setText("Estado: Pausado")
                        puntero.lblEstadoJ4.setText("Estado: Activo")
                    }
                }

                    puntero.lblTirando.setText("Espere, tirando dados...")
                    sleep(1000)

                    puntero.dado1 = puntero.obtenerNumeroDados()
                    puntero.dado2 = puntero.obtenerNumeroDados()
                    puntero.sumarPuntos()
                    puntero.asignarPuntos(puntero.puntos[puntero.jugador], puntero.jugador)
                    puntero.jugador++
                } else {
                    puntero.mostrarGanador()
                    puntero.btnIniciar.visibility = View.VISIBLE
                }
            }
        }
    }

    //Cambia la variable de iniciado a false para terminar la ejecución del hilo
    fun detener() {
        iniciado = false
    }
}