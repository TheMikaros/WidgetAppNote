package com.mika.parcial20

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView

class rec_ctl : LinearLayout {
    private lateinit var txtfecha: TextView
    private lateinit var btnabrir: Button
    private lateinit var nota: TextView

    constructor(ctx: Context): super(ctx){
        inicializar()
    }

    constructor(ctx: Context, attrs: AttributeSet): super(ctx,attrs){
        inicializar()
    }

    constructor(ctx: Context, attrs: AttributeSet, defStyleAttr: Int): super(ctx,attrs,defStyleAttr){
        inicializar()
    }


    fun inicializar(){
        //Utilizamos el layout 'control_login' como interfaz del control
        val li = LayoutInflater.from(context)
        li.inflate(R.layout.rec_view,this,true)

        //obtenemos las referencias a los distintos controles
        txtfecha = findViewById(R.id.fechrec) as TextView
        btnabrir = findViewById(R.id.btnlist) as Button
        nota = findViewById(R.id.rectext) as TextView

        asignarEventos()
    }

    fun asignarEventos(){
        btnabrir.setOnClickListener {
            //accion
        }
    }
}