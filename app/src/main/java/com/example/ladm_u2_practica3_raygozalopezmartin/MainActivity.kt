package com.example.ladm_u2_practica3_raygozalopezmartin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnComenzar.setOnClickListener {
            var otraVentana = Intent(this, Main2Activity::class.java)
            startActivity(otraVentana)
        }

    }
}
