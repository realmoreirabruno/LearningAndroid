package com.example.appmentoria

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appmentoria.model.*
//import com.example.appmentoria.data.TodoDatasource
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private val newTaskActivityRequestCode = 1
    private var taskViewModel: TaskViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        taskViewModel = ViewModelProvider(this).get(TaskViewModel::class.java)
        val recyclerView = findViewById<RecyclerView>(R.id.tasks_recyclerview)
        val adapter = TaskListAdapter()

        recyclerView.adapter = adapter
        // ele é responsavel por posicionar e mensurar os items da recyclerview da maneira a qual
        // lhe foi determinada, e tambem saber quando recyclar items que ja nao estao mais visiveis.
        //TODO: Verificar pra que é usado o layoutManager. Extra: mudar de VERTICAL para HORIZONTAL essa orientação e exibir corretamente os itens
        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.setHasFixedSize(true)

        // Add an observer on the LiveData returned by getAlphabetizedWords.
        // The onChanged() method fires when the observed data changes and the activity is
        // in the foreground.
        taskViewModel?.allTasks?.observe(this) { words ->
            // Update the cached copy of the words in the adapter.
            words.let { adapter.submitList(it) }
        }

        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            val intent = Intent(this@MainActivity, NewTaskActivity::class.java)
            startActivityForResult(intent, newTaskActivityRequestCode)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, intentData: Intent?) {
        super.onActivityResult(requestCode, resultCode, intentData)

        if (requestCode == newTaskActivityRequestCode && resultCode == Activity.RESULT_OK) {
            intentData?.getStringExtra(NewTaskActivity.EXTRA_REPLY)?.let { reply ->
                val name = Task(reply)
                taskViewModel?.insert(name)
            }
        } else {
            Toast.makeText(
                applicationContext,
                R.string.empty_not_saved,
                Toast.LENGTH_LONG
            ).show()
        }
    }



}