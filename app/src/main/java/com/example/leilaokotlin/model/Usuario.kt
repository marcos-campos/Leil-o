package com.example.leilaokotlin.model

import java.io.Serializable

class Usuario(nome: String?): Serializable {
    private var nome: String? = null

    fun Usuario(nome: String?) {
        this.nome = nome
    }

}