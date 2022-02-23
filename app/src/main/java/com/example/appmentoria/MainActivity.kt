package com.example.appmentoria

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appmentoria.model.ToDo

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val todos: MutableList<ToDo> = mutableListOf();

        todos.addAll(
            listOf(
                ToDo("Test", "Description"),
                ToDo("Test2", "Description"),
                ToDo("Test3", "Description"),
                ToDo("Test4", "Description"),
                ToDo("Test5", "Description"),
                ToDo("Test6", "Description", true),
                ToDo("Test7", "Description"),
                ToDo("Test8", "Description"),
                ToDo("Test9", "Description")
            )
        )
    }
}