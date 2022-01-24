package com.example.leilaokotlin.ui.recyclerview.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.leilaokotlin.R

class ListaLeilaoViewHolder (view: View) : RecyclerView.ViewHolder(view) {

    val descriptionItem by lazy { view.findViewById<TextView>(R.id.item_leilao_descricao) }
    val imageItem by lazy { view.findViewById<ImageView>(R.id.item_leilao_imagem) }
    val highestBid by lazy { view.findViewById<TextView>(R.id.item_leilao_maior_lance) }
}