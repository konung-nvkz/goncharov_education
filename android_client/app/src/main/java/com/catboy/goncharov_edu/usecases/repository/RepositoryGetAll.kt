package com.catboy.goncharov_edu.usecases.repository

import com.catboy.goncharov_edu.models.Task
import com.catboy.goncharov_edu.repository.RepositoryList

class RepositoryGetAll {

    private val repository = RepositoryList

    fun execute(): ArrayList<Task> = repository.getAll()

}
