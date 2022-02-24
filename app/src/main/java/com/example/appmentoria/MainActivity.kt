package com.example.appmentoria

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appmentoria.adapter.ItemAdapter
import com.example.appmentoria.data.TodoDatasource
import com.example.appmentoria.model.ToDo

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myDataset = TodoDatasource().loadTodos()

        val recyclerView = findViewById<RecyclerView>(R.id.tasks_recyclerview)

        recyclerView.adapter = ItemAdapter(this, myDataset)
        //TODO: Verificar pra que é usado o layoutManager. Extra: mudar de VERTICAL para HORIZONTAL essa orientação e exibir corretamente os itens
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        recyclerView.setHasFixedSize(true)
    }
}