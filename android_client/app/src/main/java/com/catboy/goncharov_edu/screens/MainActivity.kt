package com.catboy.goncharov_edu.screens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.catboy.goncharov_edu.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val taskButton: Button = findViewById(R.id.task_button)
        val taskListButton: Button = findViewById(R.id.tasklist_button)
        /*
        taskButton.setOnClickListener {
            val intent = Intent(this, TaskActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }

         */

        taskListButton.setOnClickListener {
            val intent = Intent(this, TaskListActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }
    }
}