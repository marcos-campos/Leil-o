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


}