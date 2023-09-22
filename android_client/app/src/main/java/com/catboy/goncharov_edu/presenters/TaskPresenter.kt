package com.catboy.goncharov_edu.presenters

import android.content.Context
import com.catboy.goncharov_edu.models.Task
import com.catboy.goncharov_edu.repository.RepositoryList
import com.catboy.goncharov_edu.usecases.StartTaskListActivity

class TaskPresenter(private val context: Context) {

    private val repository = RepositoryList

    fun clickSaveButton(task: Task) {
        repository.save(task)
        StartTaskListActivity(context).execute()
    }

    fun clickSaveButton(task: Task, index: Int) {
        repository.update(index, task)
        StartTaskListActivity(context).execute()
    }

    fun clickBackButton() {
        StartTaskListActivity(context).execute()
    }

    fun clickDeleteButton(index: Int) {
        repository.delete(index)
        StartTaskListActivity(context).execute()
    }

}