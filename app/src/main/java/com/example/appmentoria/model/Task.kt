package com.example.appmentoria.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.DateFormat

@Entity(tableName = "task_table")
data class Task (
    @ColumnInfo(name = "name") val name: String,
    val description: String,
    val done: Boolean = false,
    val created: Long = System.currentTimeMillis(),
    @PrimaryKey(autoGenerate = true) val id: Int = 0
) {
//    val createdDateFormatted: String
//        get() = DateFormat.getDateTimeInstance().format(created)
}