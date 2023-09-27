package com.catboy.goncharov_edu.screens

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.catboy.goncharov_edu.R
import com.catboy.goncharov_edu.usecases.start_activity.StartTaskListActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val taskListButton: Button = findViewById(R.id.tasklist_button)

        taskListButton.setOnClickListener {
            StartTaskListActivity(applicationContext).execute()
        }
    }
}