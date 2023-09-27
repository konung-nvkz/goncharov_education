package com.catboy.goncharov_edu.screens

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.catboy.goncharov_edu.R
import com.catboy.goncharov_edu.models.Task
import com.catboy.goncharov_edu.models.TaskStatus
import com.catboy.goncharov_edu.presenters.TaskPresenter

class TaskActivity : AppCompatActivity(), ITaskActivity {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task)

        val presenter = TaskPresenter(this)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            title = presenter.setTitle(intent)
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        val taskTitle: EditText = findViewById(R.id.task_title)
        val taskText: EditText = findViewById(R.id.task_text)
        val taskStatus: TextView = findViewById(R.id.task_status)

        val saveButton: Button = findViewById(R.id.save_button)

        taskTitle.setText(presenter.setTaskTitle(intent))
        taskText.setText(presenter.setTaskText(intent))
        taskStatus.text = presenter.setTaskStatus(intent)

        saveButton.setOnClickListener {
            presenter.clickSaveButton ( Task(
                taskTitle.text.toString(),
                taskText.text.toString(),
                TaskStatus.get(taskStatus.text.toString())
            ), intent)

        }
    }

    override fun onResume() {
        super.onResume()
        val statusArray = TaskStatus.getArray()
        val adapter = ArrayAdapter(this, R.layout.drop_down_item, statusArray)
        val autoCompleteTextView: AutoCompleteTextView = findViewById(R.id.task_status)
        autoCompleteTextView.setAdapter(adapter)
    }

    override fun taskTitleError() {
        val taskTitle: EditText = findViewById(R.id.task_title)
        taskTitle.error = "Введите название задачи"
    }
}