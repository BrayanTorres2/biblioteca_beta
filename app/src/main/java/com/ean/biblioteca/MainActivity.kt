package com.ean.biblioteca

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Este boton me lleva a la actividad de Registrar un usuario
        val boton_registrar_usuario=findViewById<Button>(R.id.bn_registra_am)
        boton_registrar_usuario.setOnClickListener {
            val intent= Intent(this,Registrar::class.java)
            startActivity(intent)
        }
        //Este boton me lleva a la actividad de login
        val boton_login=findViewById<Button>(R.id.bn_login_am)
        boton_login.setOnClickListener {
            val intent= Intent(this,login::class.java)
            startActivity(intent)
        }
    }
}