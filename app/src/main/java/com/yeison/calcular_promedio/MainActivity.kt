package com.yeison.calcular_promedio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    var campoNombre: EditText? = null
    var campoMateria: EditText?= null
    var campoNota:EditText? = null
    var campoNota2:EditText?= null
    var campoNota3:EditText?=null
    var promedio: Double? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        campoNombre=findViewById(R.id.inputname)
        campoMateria=findViewById(R.id.inputMateria)
        campoNota=findViewById(R.id.inputnote1)
        campoNota2=findViewById(R.id.inputnote2)
        campoNota3=findViewById(R.id.inputnote3)

        val miBoton:Button=findViewById(R.id.btncalcular)
        miBoton.setOnClickListener { onClick(1) }

    }

    fun Calculate(): Double {
        var nota1:Double=campoNota?.text.toString().toDouble()
        var nota2:Double=campoNota2?.text.toString().toDouble()
        var nota3:Double=campoNota3?.text.toString().toDouble()



        promedio=((nota1+nota2+nota3)/3)

        return promedio as Double;


    }




    private fun onClick(boton: Int){
        when(boton){
            1->{
                Calculate()
                val intent = Intent(this,MainResults::class.java)
                val miBundle:Bundle = Bundle()
                miBundle.putString("Nombre",campoNombre!!.text.toString())
                miBundle.putString("Materia",campoMateria!!.text.toString())
                miBundle.putString("Nota1",campoNota!!.text.toString())
                miBundle.putString("Nota2",campoNota2!!.text.toString())
                miBundle.putString("Nota3",campoNota3!!.text.toString())
                miBundle.putString("Promedio",promedio!!.toString())
                intent.putExtras(miBundle)
                startActivity(intent)
            }

        }
    }


    }


