package com.catboy.goncharov_edu.usecases

import android.view.View
import com.catboy.goncharov_edu.screens.TaskListAdapter

class RecyclerVisibility(private val adapter: TaskListAdapter) {

    fun execute(): Int {
        return if(adapter.itemCount == 0) View.GONE else View.VISIBLE
    }

}
