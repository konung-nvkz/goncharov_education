package com.catboy.goncharov_edu.presenters

import android.content.Context
import com.catboy.goncharov_edu.models.Task
import com.catboy.goncharov_edu.screens.TaskListAdapter
import com.catboy.goncharov_edu.usecases.*
import com.catboy.goncharov_edu.usecases.repository.RepositoryDelete
import com.catboy.goncharov_edu.usecases.repository.RepositoryGetAll
import com.catboy.goncharov_edu.usecases.start_activity.StartTaskActivity


class TaskListPresenter(private val context: Context) {

    fun getTasks(): ArrayList<Task> = RepositoryGetAll().execute()

    fun recyclerVisibility(adapter: TaskListAdapter): Int {
        return RecyclerVisibility(adapter).execute()
    }

    fun emptyTextVisibility(adapter: TaskListAdapter): Int {
        return EmptyTextVisibility(adapter).execute()
    }

    fun pushAddTaskButton() {
        StartTaskActivity(context).execute()
    }

    fun update(position: Int, holder: TaskListAdapter.ViewHolder) {
        StartTaskActivity(context).execute(position, holder)
    }

    fun delete(adapter: TaskListAdapter, index: Int) = RepositoryDelete(adapter).execute(index)

}