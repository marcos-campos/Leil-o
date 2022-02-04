package com.example.leilaokotlin.model

import java.io.Serializable
import java.lang.StringBuilder

class Lance(var usuario: Usuario? = null,
            var valor: Double = 0.0): Serializable {

    fun getValue(): Double {
        return valor
    }

    fun getUser(): Usuario? {
        return usuario
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Lance

        if (usuario != other.usuario) return false
        if (valor != other.valor) return false

        return true
    }

    override fun hashCode(): Int {
        var result = usuario?.hashCode() ?: 0
        result = 31 * result + valor.hashCode()
        return result
    }


}