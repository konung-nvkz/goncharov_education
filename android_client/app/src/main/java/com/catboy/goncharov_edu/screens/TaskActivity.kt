package com.catboy.goncharov_edu.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.widget.Toolbar
import com.catboy.goncharov_edu.R
import com.catboy.goncharov_edu.models.Task
import com.catboy.goncharov_edu.models.TaskStatus
import com.catboy.goncharov_edu.presenters.TaskPresenter

class TaskActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            title = if (intent.hasExtra("index")) "Изменить задачу" else "Добавить задачу"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        val presenter = TaskPresenter(applicationContext)

        val taskTitle: EditText = findViewById(R.id.task_title)
        val taskText: EditText = findViewById(R.id.task_text)
        val taskStatus: TextView = findViewById(R.id.task_status)

        val saveButton: Button = findViewById(R.id.save_button)

        saveButton.setOnClickListener {

            if (taskTitle.text.isEmpty()) return@setOnClickListener
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
    }

    override fun onResume() {
        super.onResume()
        val status = arrayOf("Задача добавлена", "Задача обновлена",
            "Задача отправлена на проверку", "Задача отправлена на доработку", "Задача выполнена")
        val adapter = ArrayAdapter(this, R.layout.drop_down_item, status)
        val autoCompleteTextView: AutoCompleteTextView = findViewById(R.id.task_status)
        autoCompleteTextView.setAdapter(adapter)
    }
}