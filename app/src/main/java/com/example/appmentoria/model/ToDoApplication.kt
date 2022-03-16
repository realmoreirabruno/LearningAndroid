package com.example.appmentoria.model

import android.app.Application
import android.content.Intent
import com.example.appmentoria.MainActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class ToDoApplication : Application() {

//    override fun onCreate() {
//        super.onCreate()
//            val mainActivity = Intent(this, MainActivity::class.java)
//        mainActivity.apply {
//            setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//        }
//        startActivity(mainActivity)
//    }

    //TODO: rever sobre onCreate na ToDoApplication

    val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy { TaskRoomDatabase.getDatabase(this, applicationScope) }
    val repository by lazy { TaskRepository(database.taskDao()) }

}