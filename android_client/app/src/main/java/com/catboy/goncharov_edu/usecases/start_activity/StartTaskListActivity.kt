package com.catboy.goncharov_edu.usecases.start_activity

import android.content.Context
import android.content.Intent
import com.catboy.goncharov_edu.screens.TaskListActivity

class StartTaskListActivity(private val context: Context) {

    fun execute() {
        val intent = Intent(context, TaskListActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        context.startActivity(intent)
    }
}
