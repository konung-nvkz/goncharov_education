package com.catboy.goncharov_edu.usecases.repository

import android.content.Intent
import com.catboy.goncharov_edu.models.Task
import com.catboy.goncharov_edu.repository.RepositoryList

class RepositoryUpdate(private val task: Task, private val intent: Intent) {

    private val repository = RepositoryList

    fun execute() {
        val index = intent.getIntExtra("index", 0)
        repository.update(index, task)
    }
}
