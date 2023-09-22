package com.catboy.goncharov_edu.usecases

import android.view.View
import com.catboy.goncharov_edu.screens.TaskListAdapter

class EmptyTextVisibility(private val adapter: TaskListAdapter) {

    fun execute(): Int {
        return if(adapter.itemCount == 0) View.VISIBLE else View.GONE
    }
}
