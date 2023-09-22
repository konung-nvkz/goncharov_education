package com.catboy.goncharov_edu.usecases

import android.content.Context
import android.content.Intent
import com.catboy.goncharov_edu.screens.TaskActivity

class StartTaskActivity(private val context: Context) {

    fun execute() {
        val intent = Intent(context, TaskActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        context.startActivity(intent)
    }

    fun execute(index: Int) {
        val intent = Intent(context, TaskActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        intent.putExtra("index", index)
        context.startActivity(intent)
    }
}
