package com.example.appmentoria

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appmentoria.model.*
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainActivity : AppCompatActivity() {

    private val newTaskActivityRequestCode = 1
    private val taskViewModel: TaskViewModel by viewModels {
        TaskViewModelFactory((application as ToDoApplication).repository)
    }

//    private lateinit var viewModelFactory : TaskViewModelFactory
//    private lateinit var taskViewModel : ViewModelProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val taskViewModel =
//            ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(this.application)).get(
//                TaskViewModel::class.java
//            )

        //val taskViewModel = ViewModelProvider(this).get(TaskViewModel::class.java)

        val recyclerView : RecyclerView = findViewById(R.id.tasks_recyclerview)
        val adapter = TaskListAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        //recyclerView.setHasFixedSize(true)

        // Add an observer on the LiveData returned by getAlphabetizedWords.
        // The onChanged() method fires when the observed data changes and the activity is
        // in the foreground.
        taskViewModel.allTasks.observe(this) { tasks ->
            // Update the cached copy of the words in the adapter.
            tasks.let { adapter.submitList(it) }
        }

        val fab : FloatingActionButton = findViewById(R.id.fab_main)
        fab.setOnClickListener {
            val intent = Intent(this@MainActivity, NewTaskActivity::class.java)
            //resultLauncher.launch(intent)
            startActivityForResult(intent, newTaskActivityRequestCode)
        }

        val singleTask : View = findViewById(R.id.longclick_layout)

        //TODO: LongClick (use long click here? use this id? idk exactly)

        singleTask.setOnLongClickListener{

            val alertDialogBuilderLabelDelete: AlertDialog.Builder = AlertDialog.Builder(this)

            alertDialogBuilderLabelDelete.setCancelable(false)
            alertDialogBuilderLabelDelete.setTitle("Delete label")
            alertDialogBuilderLabelDelete.setMessage("Are you sure to delete?")

            Toast.makeText(this, "Long click detected", Toast.LENGTH_SHORT).show()
            return@setOnLongClickListener true
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, intentData: Intent?) {
        super.onActivityResult(requestCode, resultCode, intentData)

        if (requestCode == newTaskActivityRequestCode && resultCode == Activity.RESULT_OK) {
            intentData?.getStringExtra(NewTaskActivity.EXTRA_REPLY)?.let { reply ->
                val name = Task(reply, reply)
                taskViewModel.insert(name)
                val description = Task(reply, reply)
                taskViewModel.insert(description)
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