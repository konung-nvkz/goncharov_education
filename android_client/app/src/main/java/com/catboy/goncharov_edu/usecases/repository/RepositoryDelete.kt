package com.catboy.goncharov_edu.usecases.repository

import com.catboy.goncharov_edu.screens.TaskListAdapter

class RepositoryDelete(private val adapter: TaskListAdapter) {

    fun execute(index: Int): Any = adapter.delete(index)


}
