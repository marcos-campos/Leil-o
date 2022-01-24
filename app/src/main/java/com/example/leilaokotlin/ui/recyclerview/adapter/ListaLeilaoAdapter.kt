package com.example.leilaokotlin.ui.recyclerview.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.leilaokotlin.R
import com.example.leilaokotlin.model.Leilao
import com.example.leilaokotlin.ui.activity.LancesLeilaoActivity

class ListaLeilaoAdapter(
    private val listaLeiloes: MutableList<Leilao>,
    private val context: Context
    ): RecyclerView.Adapter<ListaLeilaoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaLeilaoViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.item_leilao, parent, false)
        return ListaLeilaoViewHolder(view)
    }
    override fun getItemCount(): Int = listaLeiloes.size

    override fun onBindViewHolder(holder: ListaLeilaoViewHolder, position: Int) {

        val description = holder.descriptionItem
        description.text = listaLeiloes[position].getDescription().toString()

        val highestBid = holder.highestBid
        highestBid.text = listaLeiloes[position].getMaiorLance().toString()

        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, LancesLeilaoActivity::class.java)

            intent.putExtra("date", listaLeiloes[position])

            it.context.startActivity(intent)
        }
    }
}