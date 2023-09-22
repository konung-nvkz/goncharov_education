package com.catboy.goncharov_edu.repository

import com.catboy.goncharov_edu.models.Task

object RepositoryList : Repository {

    private val list: ArrayList<Task> = ArrayList()

    override fun getAll(): ArrayList<Task> {
        return list
    }

    override fun get(index: Int): Task {
        return list[index]
    }

    override fun save(item: Task) {
        list.add(item)
    }

    override fun delete(index: Int) {
        list.removeAt(index)
    }

    override fun update(index: Int, task: Task) {
        list[index] = task
    }

    override fun deleteAll() {
        list.clear()
    }
}