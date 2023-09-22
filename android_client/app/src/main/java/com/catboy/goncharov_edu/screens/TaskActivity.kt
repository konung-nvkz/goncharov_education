package com.catboy.goncharov_edu.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.catboy.goncharov_edu.R
import com.catboy.goncharov_edu.models.Task
import com.catboy.goncharov_edu.models.TaskStatus
import com.catboy.goncharov_edu.presenters.TaskPresenter

class TaskActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task)

        val presenter = TaskPresenter(applicationContext)

        val taskTitle: EditText = findViewById(R.id.task_title)
        val taskText: EditText = findViewById(R.id.task_text)
        val taskStatus: TextView = findViewById(R.id.task_status)

        val saveButton: Button = findViewById(R.id.save_button)
        val backButton: Button = findViewById(R.id.back_button)
        val deleteButton: Button = findViewById(R.id.delete_button)

        saveButton.setOnClickListener {

            val task = Task(
                taskTitle.text.toString(),
                taskText.text.toString(),
                TaskStatus.get(taskStatus.text.toString())
            )
            if (intent.hasExtra("index")) {
                val index = intent.getIntExtra("index", 0)
                presenter.clickSaveButton(task, index)
            }else {
                presenter.clickSaveButton(task)
            }
        }

        backButton.setOnClickListener { presenter.clickBackButton() }

        deleteButton.setOnClickListener {
            if (intent.hasExtra("index")) {
                val index = intent.getIntExtra("index", 0)
                presenter.clickDeleteButton(index)
            }else {
                presenter.clickBackButton()
            }
        }
    }
}