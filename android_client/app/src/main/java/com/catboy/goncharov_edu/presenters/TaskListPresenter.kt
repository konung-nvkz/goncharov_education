package com.catboy.goncharov_edu.presenters

import android.content.Context
import com.catboy.goncharov_edu.models.Task
import com.catboy.goncharov_edu.repository.RepositoryList
import com.catboy.goncharov_edu.screens.TaskListAdapter
import com.catboy.goncharov_edu.usecases.EmptyTextVisibility
import com.catboy.goncharov_edu.usecases.RecyclerVisibility
import com.catboy.goncharov_edu.usecases.StartTaskActivity
import java.util.ArrayList


class TaskListPresenter(private val context: Context) {

    private val repository = RepositoryList

    fun getTasks(): ArrayList<Task> {
        return repository.getAll()
    }

    fun recyclerVisibility(adapter: TaskListAdapter): Int {
        return RecyclerVisibility(adapter).execute()
    }

    fun emptyTextVisibility(adapter: TaskListAdapter): Int {
        return EmptyTextVisibility(adapter).execute()
    }

    fun pushAddTaskButton() {
        StartTaskActivity(context).execute()
    }

    fun update(position: Int) {
        StartTaskActivity(context).execute(position)
    }

    fun deleteAll(adapter: TaskListAdapter) {
        repository.deleteAll()
        adapter.deleteAll()
    }

    fun delete(adapter: TaskListAdapter, index: Int) {
        //repository.delete(index)
        adapter.delete(index)
    }

}