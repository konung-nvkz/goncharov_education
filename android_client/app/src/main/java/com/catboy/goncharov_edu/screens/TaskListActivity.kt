package com.catboy.goncharov_edu.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import com.catboy.goncharov_edu.R
import com.catboy.goncharov_edu.models.Task
import com.catboy.goncharov_edu.presenters.TaskListPresenter

class TaskListActivity : AppCompatActivity() {

    private var adapter: TaskListAdapter? = null
    private var recyclerView: RecyclerView? = null
    private var recyclerEmptyText: TextView? = null
    private var presenter: TaskListPresenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_list)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        title = "Список задач"

        presenter = TaskListPresenter(applicationContext)

        initRecyclerView(presenter!!)

        val addTaskButton: Button = findViewById(R.id.create_task_button)
        addTaskButton.setOnClickListener { presenter!!.pushAddTaskButton() }
    }

    override fun onResume() {
        super.onResume()
        adapter?.notifyDataSetChanged()
        recyclerView?.visibility = presenter!!.recyclerVisibility(adapter!!)
        recyclerEmptyText?.visibility = presenter!!.emptyTextVisibility(adapter!!)
    }

    private fun initRecyclerView(presenter: TaskListPresenter) {
        val tasks: ArrayList<Task> = presenter.getTasks()
        recyclerView = findViewById(R.id.recyclerView)
        adapter = TaskListAdapter(this, tasks)
        recyclerView!!.adapter = adapter
        recyclerEmptyText = findViewById(R.id.recycler_empty_text)
    }
}