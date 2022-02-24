package com.example.appmentoria.data

import com.example.appmentoria.R
import com.example.appmentoria.model.ToDo

class TodoDatasource {
    fun loadTodos(): List<ToDo>{
        //TODO: Retirar stringResourceId e substituir no name;
        return listOf(
            ToDo(R.string.todo1, "A","B", true),
            ToDo(R.string.todo2, "A","B", true),
            ToDo(R.string.todo3, "A","B", true),
            ToDo(R.string.todo4, "A","B", false),
            ToDo(R.string.todo5, "A","B", false),
            ToDo(R.string.todo6, "A","B", true),
            ToDo(R.string.todo7, "A","B", true),
            ToDo(R.string.todo8, "A","B", true),
            ToDo(R.string.todo9, "A","B", true),
            ToDo(R.string.todo10, "A","B", true),
            ToDo(R.string.todo11, "A","B", true)
        )
    }
}