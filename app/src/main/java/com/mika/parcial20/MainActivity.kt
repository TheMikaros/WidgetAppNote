package com.mika.parcial20

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.*


class MainActivity : AppCompatActivity() {

//    private val recView: RecyclerView = findViewById(R.id.recylcerview)
//    private val listaitems = mutableListOf(
//        Itemlist("red", "Esta es una nota de prueba", "")
//    )
//
//
//    private val adaptador = AdapItem(listaitems){
//        val items: RecyclerView = findViewById(R.id.recylcerview)
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val fech: EditText = findViewById(R.id.capfecha)
        fech.setOnClickListener {
            showDatePickerDialog()
        }
        val btnnew: Button = findViewById(R.id.btnnew)
        val rbgrp: RadioGroup = findViewById(R.id.rdgrp)
        val rbnte: RadioButton = findViewById(R.id.rdnota)
        val rbRec: RadioButton = findViewById(R.id.rdrec)

        val nota : EditText = findViewById(R.id.txtnota)
        val btnAddNote: Button = findViewById(R.id.btnNoteCreate)
        val btnAddRec: Button = findViewById(R.id.btnRecCreate)

        val btnred : ImageButton = findViewById(R.id.redColor)
        val btnblu: ImageButton = findViewById(R.id.blueColor)
        val btngrey: ImageButton = findViewById(R.id.greenColor)
        val btnpurple: ImageButton = findViewById(R.id.purplecolor)
        val btnwhite: ImageButton = findViewById(R.id.whiteColor)

        val LayNote: LinearLayout = findViewById(R.id.notalayaut)
        val LayRec: LinearLayout = findViewById(R.id.reclayout)

        var type: String = "white"
        var text: String
        var date: String


        rbgrp.clearCheck()

        btnAddNote.setOnClickListener {
            text = nota.text.toString()
            date = ""
            if(nota.toString() != ""){
                listaitems.add(0, Itemlist(type, text, date))
                Toast.makeText(this,"Nota Añadida",
                    Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this,"No pueden haber una nota vacias",
                    Toast.LENGTH_SHORT).show()
            }

        }

        btnblu.setOnClickListener {
            text="blue"
            LayNote.setBackgroundResource(R.drawable.blue_background)
        }

        btnred.setOnClickListener {
            text="red"
            LayNote.setBackgroundResource(R.drawable.red_background)
        }

        btngrey.setOnClickListener {
            text="green"
            LayNote.setBackgroundResource(R.drawable.green_background)
        }

        btnpurple.setOnClickListener {
            text="purple"
            LayNote.setBackgroundResource(R.drawable.purple_background)
        }

        btnwhite.setOnClickListener {
            text="white"
            LayNote.setBackgroundResource(R.drawable.notabackground)
        }


        btnnew.setOnClickListener {
            if(rbgrp.visibility == View.GONE){
                rbgrp.visibility = View.VISIBLE
                btnnew.setText("Ocultar")
            }else {
                rbgrp.visibility = View.GONE
                rbgrp.clearCheck()
                btnnew.text = "Nuev@"
                LayNote.visibility = View.GONE
                LayRec.visibility = View.GONE
            }
        }

        rbnte.setOnClickListener {
            if(LayNote.visibility == View.GONE){
                LayRec.visibility = View.GONE
                LayNote.visibility = View.VISIBLE
            }else {
                LayNote.visibility = View.GONE
                rbgrp.clearCheck()
                LayNote.setBackgroundResource(R.drawable.notabackground)
            }
        }

        rbRec.setOnClickListener {
            if(LayRec.visibility == View.GONE){
                LayRec.visibility = View.VISIBLE
                LayNote.visibility = View.GONE
                LayNote.setBackgroundResource(R.drawable.notabackground)
            }
            else {
                LayRec.visibility = View.GONE
                rbgrp.clearCheck()
            }
        }

    } //end on create

    private fun showDatePickerDialog() {
        val newFragment = DatePickerFragment.newInstance(DatePickerDialog.OnDateSetListener { _, year, month, day ->
            // +1 because January is zero
            val selectedDate = day.toString() + " / " + (month + 1) + " / " + year
            val fech2:EditText = findViewById(R.id.capfecha)
            fech2.setText(selectedDate)
        })

        newFragment.show(supportFragmentManager, "datePicker")
    }

    fun onClick(view: View) {
        when (view.id) {
            R.id.capfecha -> showDatePickerDialog()
        }
    }
}