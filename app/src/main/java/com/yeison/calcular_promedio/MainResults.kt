package com.yeison.calcular_promedio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import org.w3c.dom.Text

class MainResults : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_results)

        val campoNombre = findViewById<TextView>(R.id.textResultNombre)
        val campoMateria=findViewById<TextView>(R.id.textResultMateria)
        val campoNota1 = findViewById<TextView>(R.id.textResultNota1)
        val campoNota2= findViewById<TextView>(R.id.textResultNota2)
        val campoNota3= findViewById<TextView>(R.id.textResultNota3)
        val promedio = findViewById<TextView>(R.id.textResultProm)

        var miBundle:Bundle? = this.intent.extras

        if (miBundle != null) {
            campoNombre.text = "${miBundle.getString("Nombre")}"
            campoMateria.text = "${miBundle.getString("Materia")}"
            campoNota1.text = "${miBundle.getString("Nota1")}"
            campoNota2.text = "${miBundle.getString("Nota2")}"
            campoNota3.text = "${miBundle.getString("Nota3")}"
            promedio.text = "${miBundle.getString("Promedio")}"

        }

        if(miBundle?.getString( "Promedio").toString().toDouble()>=3.5){
            promedio.setTextColor(ContextCompat.getColor(this,R.color.verde))
        }else{
            promedio.setTextColor(ContextCompat.getColor(this,R.color.rojo))
        }


        val btnExt: Button=findViewById(R.id.buttonVolver)
        btnExt.setOnClickListener {  onClick() }


    }

    private fun onClick() {
        finish()
    }
}




