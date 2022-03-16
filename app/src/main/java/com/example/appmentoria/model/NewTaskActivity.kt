package com.example.appmentoria.model

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import com.example.appmentoria.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class NewTaskActivity : AppCompatActivity() {

    private lateinit var editTaskView: EditText
    private lateinit var editDescription: EditText

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_task)
        editTaskView = findViewById(R.id.edit_text)
        editDescription = findViewById(R.id.edit_description)

        val button : FloatingActionButton = findViewById(R.id.save_button)
        button.setOnClickListener {
            val replyIntent = Intent()
            if (TextUtils.isEmpty(editTaskView.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val word = editTaskView.text.toString()
                val desc = editDescription.text.toString()
                replyIntent.putExtra(EXTRA_REPLY, desc)
                replyIntent.putExtra(EXTRA_REPLY, word)
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }
    }

    companion object {
        const val EXTRA_REPLY = "com.example.android.wordlistsql.REPLY"
    }

}