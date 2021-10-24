package com.mika.parcial20

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

data class Itemlist(val type: String, val text: String, val date: String)

class AdapItem (private val listaitems: MutableList<Itemlist>,
               private val clickListener: (Int) -> Unit) :

    RecyclerView.Adapter<AdapItem.itemViewHolder>() {
        class itemViewHolder(item: View): RecyclerView.ViewHolder(item){
            val type = item.findViewById(R.id.itemtype) as TextView
            val txt_nota = item.findViewById(R.id.typetext) as TextView
            val txt_fecha = item.findViewById(R.id.typefecha) as TextView
            val imgtype = item.findViewById(R.id.typeview) as ImageView
            val itemback = item.findViewById(R.id.itemback) as ConstraintLayout

            fun binditem(item: Itemlist){
                txt_nota.text=item.text
                txt_fecha.text=item.date
                if(item.type == "Recordatorio"){
                    imgtype.setBackgroundResource(R.drawable.eventnote)
                    type.text=item.type
                }else{
                    if(item.type == "red"){
                        itemback.setBackgroundResource(R.drawable.red_background)
                    }else if(item.type == "blue"){
                        itemback.setBackgroundResource(R.drawable.blue_background)
                    }else if(item.type == "green"){
                        itemback.setBackgroundResource(R.drawable.green_background)
                    }else if(item.type == "purple"){
                        itemback.setBackgroundResource(R.drawable.purple_background)
                    }else{
                        itemback.setBackgroundResource(R.drawable.notabackground)
                    }
                    type.text="Nota"
                    imgtype.setBackgroundResource(R.drawable.record)
                }

            }
        }
        override fun onCreateViewHolder (parent: ViewGroup, viewType: Int): itemViewHolder {
            val item = LayoutInflater.from(parent.context)
                .inflate(R.layout.lista_item, parent, false) as androidx.constraintlayout.widget.ConstraintLayout
            return itemViewHolder(item)
        }

        override fun onBindViewHolder (holder: itemViewHolder, position: Int) {
            val newitem=listaitems[position]
            holder.binditem(newitem)
            holder.itemView.setOnClickListener{clickListener(position)}
        }

        override fun getItemCount() = listaitems.size
}