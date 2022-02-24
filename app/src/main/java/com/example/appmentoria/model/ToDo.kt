package com.example.appmentoria.model

import java.text.DateFormat

data class ToDo (
    val stringResourceId: Int, //TODO: Eliminar essa propriedade
    val name: String,
    val description: String,
    val done: Boolean = false,
    val created: Long = System.currentTimeMillis()
) {
    val createdDateFormatted: String
        get() = DateFormat.getDateTimeInstance().format(created) //TODO: Verificar se é necessário
}