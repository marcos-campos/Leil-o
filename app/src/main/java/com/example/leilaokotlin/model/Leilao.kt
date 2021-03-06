package com.example.leilaokotlin.model

import java.io.Serializable
import java.lang.RuntimeException

class Leilao(var descricao: String? = "",
             var listaLances: MutableList<Lance>? = mutableListOf(),
             var maiorLance: Double? = 0.0,
             var menorLance: Double = 0.0) : Serializable {

    fun getDescription(): String? {
        return descricao
    }

    fun propoe(lance: Lance) {
        valida(lance)
        listaLances?.add(lance)
        listaLances?.sortByDescending { it.valor }

        defineMaiorEMenorLanceParaPrimeiroLance(lance)
        calculaMaiorLance(lance)
    }

    private fun defineMaiorEMenorLanceParaPrimeiroLance(lance: Lance) {
        if (listaLances?.size == 1) {
            maiorLance = lance.getValue()
            menorLance = lance.getValue()
        }
    }

    private fun valida(lance: Lance) {
        if (lanceForMenorQueOUltimoLance(lance))
            throw RuntimeException("Lance menor que o último lance")
        if (!listaLances?.isEmpty()!!) {

            val usuarioNovo = lance.getUser()
            val ultimoUsuario = listaLances!![0].getUser()

            if (usuarioForMesmoUltimoLance(usuarioNovo, ultimoUsuario))
                throw RuntimeException("Mesmo usuário do último lance")

            if (usuarioDeuCincoLances(usuarioNovo))
            throw RuntimeException("Usuário já deu cinco lances")
        }
    }

    private fun usuarioDeuCincoLances(usuarioNovo: Usuario?): Boolean {
        var lancesDoUsuario: Int = 0
        var usuarioExistente: Usuario

        for (x in listaLances!!) {
            usuarioExistente = x.getUser()!!
            if (usuarioExistente.equals(usuarioNovo))
                lancesDoUsuario++
            if (lancesDoUsuario == 5) {
                return true
            }
        }
        return false
    }

    private fun usuarioForMesmoUltimoLance(
        usuarioNovo: Usuario?,
        ultimoUsuario: Usuario?
    ): Boolean {
        if (usuarioNovo != null) {
            if (usuarioNovo == ultimoUsuario) {
                return true
            }
        }
        return false
    }

    private fun lanceForMenorQueOUltimoLance(lance: Lance): Boolean {
        if (maiorLance!! > lance.getValue()) {
            return true
        }
        return false
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