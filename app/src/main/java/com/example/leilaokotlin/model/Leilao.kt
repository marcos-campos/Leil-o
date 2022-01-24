package com.example.leilaokotlin.model

import java.io.Serializable
import java.util.*

class Leilao(var descricao: String? = "",
             var listaLances: MutableList<Lance>? = mutableListOf(),
             var maiorLance: Double? = Double.MIN_VALUE,
             var menorLance: Double = Double.MAX_VALUE) : Serializable {

    fun getDescription(): String? {
        return descricao
    }

    fun propoe(lance: Lance) {

        listaLances?.add(lance)
        listaLances?.sortByDescending { it.valor }

        calculaMaiorLance(lance)
        calculaMenorLance(lance)
    }

    fun getMaiorLance(): Double {
        return maiorLance!!
    }

    fun getMenorLances(): Double {
        return menorLance
    }

    fun calculaMaiorLance(lance: Lance) {
        val valor = lance.getValue()

        if (valor > maiorLance!!) {
            maiorLance = valor
        }
    }

    fun calculaMenorLance(lance: Lance) {
        val valor = lance.getValue()

        if (valor < menorLance) {
            menorLance = valor
        }
    }

    fun tresMaioresLances(): List<Lance>? {


        var quantidadeMaximaLances = listaLances?.size

        if (quantidadeMaximaLances != null) {
            if (quantidadeMaximaLances > 3) {
                quantidadeMaximaLances = 3
            }
        }

        return quantidadeMaximaLances?.let { listaLances?.subList(0, it) }

    }
}