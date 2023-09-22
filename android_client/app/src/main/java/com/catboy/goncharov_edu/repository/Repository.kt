package com.catboy.goncharov_edu.repository

import com.catboy.goncharov_edu.models.Task

interface Repository {

    fun getAll(): ArrayList<Task>
    fun get(index: Int): Task
    fun save(item: Task)
    fun delete(index: Int)
    fun update(index: Int, task: Task)
    fun deleteAll()
}