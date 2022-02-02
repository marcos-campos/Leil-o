package com.example.leilaokotlin.ui.activity

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.leilaokotlin.R
import com.example.leilaokotlin.model.Leilao

class LancesLeilaoActivity : AppCompatActivity() {

    val descricao by lazy { findViewById<TextView>(R.id.lances_leilao_descricao) }
    val maiorLance by lazy { findViewById<TextView>(R.id.lances_leilao_maior_lance) }
    val menorLance by lazy { findViewById<TextView>(R.id.lances_leilao_menor_lance) }
    val primeiroMaiorLance by lazy { findViewById<TextView>(R.id.lances_leilao_primeiro_maior_lances) }
    val segundoMaiorLance by lazy { findViewById<TextView>(R.id.lances_leilao_segundo_maior_lances) }
    val terceiroMaiorLance by lazy { findViewById<TextView>(R.id.lances_leilao_terceiro_maior_lances) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lances_leilao)

        val info = intent.extras
        val infoLeilao = info?.getSerializable("date") as Leilao

        descricao.text = infoLeilao.getDescription()
        maiorLance.text = infoLeilao.getMaiorLance().toString()
        menorLance.text = infoLeilao.getMenorLances().toString()

        var valorMaiorLance = ""
        if (0 < infoLeilao.tresMaioresLances()!!.size) {
            valorMaiorLance = infoLeilao.tresMaioresLances()?.get(0)?.getValue().toString()
        }

        var valorSegundoMaiorLance = ""
        if (1 < infoLeilao.tresMaioresLances()!!.size) {
            valorSegundoMaiorLance = infoLeilao.tresMaioresLances()?.get(1)?.getValue().toString()
        }

        var valorTerceiroMaiorLance = ""
        if (2 < infoLeilao.tresMaioresLances()!!.size) {
            valorTerceiroMaiorLance = infoLeilao.tresMaioresLances()?.get(2)?.getValue().toString()
        }
        primeiroMaiorLance.text = valorMaiorLance
        segundoMaiorLance.text = valorSegundoMaiorLance
        terceiroMaiorLance.text = valorTerceiroMaiorLance

    }
}

//        var valorMaiorLance = infoLeilao.tresMaioresLances()?.get(0)?.getValue().toString()
//        val valorSegundoMaiorLance = infoLeilao.tresMaioresLances()?.get(1)?.getValue().toString()
//        var valorTerceiroMaiorLance = ""
//        infoLeilao.tresMaioresLances()?.get(2).let { valorTerceiroMaiorLance = it?.getValue().toString() }