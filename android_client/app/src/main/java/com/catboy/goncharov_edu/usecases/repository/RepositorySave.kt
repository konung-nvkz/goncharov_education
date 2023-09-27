package com.catboy.goncharov_edu.usecases.repository

import com.catboy.goncharov_edu.models.Task
import com.catboy.goncharov_edu.repository.RepositoryList

class RepositorySave(private val task: Task) {
    private val repository = RepositoryList

    fun execute() {
        repository.save(task)
    }
}
