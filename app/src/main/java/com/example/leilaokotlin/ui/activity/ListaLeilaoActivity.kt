package com.example.leilaokotlin.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.leilaokotlin.R
import com.example.leilaokotlin.model.Lance
import com.example.leilaokotlin.model.Leilao
import com.example.leilaokotlin.model.Usuario
import com.example.leilaokotlin.ui.recyclerview.adapter.ListaLeilaoAdapter

class ListaLeilaoActivity : AppCompatActivity() {

    val recycler by lazy { findViewById<RecyclerView>(R.id.lista_leilao_recyclerview) }
    val lista = trazerListaLeiloes()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_leilao)

        recycler?.layoutManager = LinearLayoutManager(this)

        val adapter = this?.let { ListaLeilaoAdapter(lista, this) }
        recycler?.adapter = adapter
    }

    private fun trazerListaLeiloes(): MutableList<Leilao> {

        val leilao1 = Leilao("Console")
        leilao1.propoe(Lance(Usuario("Bruno"), 200.00))
        leilao1.propoe(Lance(Usuario("Alex"),250.00))
        leilao1.propoe(Lance(Usuario("Caio"),280.00))

        val leilao2 = Leilao("Carro")
        leilao2.propoe(Lance(Usuario("Caio"), 15000.00))
        leilao2.propoe(Lance(Usuario("Carlos"),10000.00))
        leilao2.propoe(Lance(Usuario("Camila"),13500.00))
        leilao2.propoe(Lance(Usuario("Mario"),17000.00))

        val leilao3 = Leilao("Computador")
        leilao3.propoe(Lance(Usuario("José"), 1000.00))
        leilao3.propoe(Lance(Usuario("Lucas"),500.00))

        val listaLeiloes = mutableListOf<Leilao>()
            listaLeiloes.add(leilao1)
            listaLeiloes.add(leilao2)
            listaLeiloes.add(leilao3)

        return listaLeiloes
    }
}
