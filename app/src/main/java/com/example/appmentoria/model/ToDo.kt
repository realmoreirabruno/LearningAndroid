package com.example.appmentoria.model

import java.text.DateFormat

data class ToDo (
    val name: String,
    val description: String,
    val done: Boolean = false,
    val created: Long = System.currentTimeMillis() //alguma dica?
) {
    val createdDateFormatted: String
        get() = DateFormat.getDateTimeInstance().format(created)
}