package com.example.leilaokotlin.model

import java.io.Serializable

class Lance(var usuario: Usuario? = null,
            var valor: Double = 0.0): Serializable {

    fun getValue(): Double {
        return valor
    }
}