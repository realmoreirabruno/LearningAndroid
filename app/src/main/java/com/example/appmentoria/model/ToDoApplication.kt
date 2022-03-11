package com.example.appmentoria.model

import android.app.Application
import android.content.Intent
import com.example.appmentoria.MainActivity

class ToDoApplication : Application() {

    override fun onCreate() {
        super.onCreate()
            val mainActivity = Intent(this, MainActivity::class.java)
        mainActivity.apply {
            setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        startActivity(mainActivity)
    }

}