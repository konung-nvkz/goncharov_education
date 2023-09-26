package com.catboy.goncharov_edu.usecases

import android.content.Context
import android.content.Intent
import com.catboy.goncharov_edu.screens.TaskActivity
import com.catboy.goncharov_edu.screens.TaskListAdapter

class StartTaskActivity(private val context: Context) {

    fun execute() {
        val intent = Intent(context, TaskActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        context.startActivity(intent)
    }

    fun execute(index: Int, holder: TaskListAdapter.ViewHolder) {
        val intent = Intent(context, TaskActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        intent.putExtra("index", index)
        intent.putExtra("title", holder.title.text.toString())
        intent.putExtra("text", holder.text.text.toString())
        intent.putExtra("status", holder.status.text.toString())
        context.startActivity(intent)
    }
}
