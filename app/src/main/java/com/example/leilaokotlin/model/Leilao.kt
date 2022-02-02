package com.example.leilaokotlin.model

import java.io.Serializable
import java.util.*

class Leilao(var descricao: String? = "",
             var listaLances: MutableList<Lance>? = mutableListOf(),
             var maiorLance: Double? = 0.0,
             var menorLance: Double = 0.0) : Serializable {

    fun getDescription(): String? {
        return descricao
    }

    fun propoe(lance: Lance) {

        if (maiorLance!! > lance.getValue()){
            return
        }

        if (!listaLances?.isEmpty()!!) {

            val usuarioNovo = lance.getUser()
            val ultimoUsuario = listaLances!![0].getUser()

            if (usuarioNovo != null) {
                if (usuarioNovo == ultimoUsuario) {
                    return
                }
            }

            var lancesDoUsuario: Int = 0
            var usuarioExistente: Usuario

            for(x in listaLances!!){
                usuarioExistente = x.getUser()!!
                if (usuarioExistente.equals(usuarioNovo))
                    lancesDoUsuario++
                if (lancesDoUsuario == 5){
                    return
                }
            }
        }

        listaLances?.add(lance)
        listaLances?.sortByDescending { it.valor }

        if (listaLances?.size == 1) {
            maiorLance  = lance.getValue()
            menorLance  = lance.getValue()
        }

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

    fun quantidadeLancesDevolvido(): Int? {
        return listaLances?.size
    }
}