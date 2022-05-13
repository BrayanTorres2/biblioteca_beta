package com.ean.biblioteca

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import com.github.barteksc.pdfviewer.PDFView
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage

class leer_libro : AppCompatActivity() {
    val storage = Firebase.storage
    val ONE_MEGABYTE: Long = 1024 * 1024*90
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_leer_libro)
        //Leer el pdf de storageRef
        var nombre_libro=intent.getStringExtra("TITULO LIBRO").toString()
        var proceesbar = findViewById<ProgressBar>(R.id.progressBar)
        var pdf = findViewById<PDFView>(R.id.pdf_viewer)
        val Ref = storage.reference.child("libros")
        Log.d("Firebase", "Files $nombre_libro")
        Ref.child(nombre_libro).getBytes(ONE_MEGABYTE).addOnSuccessListener {
            pdf.fromBytes(it).load()
            proceesbar.visibility= View.INVISIBLE
        }.addOnFailureListener {
            // Handle any errors
            Toast.makeText(this,"No se pudo descargar",Toast.LENGTH_LONG).show()
        }
    }
}