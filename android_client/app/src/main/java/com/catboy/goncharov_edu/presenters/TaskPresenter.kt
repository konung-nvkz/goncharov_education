package com.catboy.goncharov_edu.presenters

import android.content.Intent
import com.catboy.goncharov_edu.models.Task
import com.catboy.goncharov_edu.screens.ITaskActivity
import com.catboy.goncharov_edu.usecases.*
import com.catboy.goncharov_edu.usecases.data_from_intent.GetTaskStatus
import com.catboy.goncharov_edu.usecases.data_from_intent.GetTaskText
import com.catboy.goncharov_edu.usecases.data_from_intent.GetTaskTitle
import com.catboy.goncharov_edu.usecases.data_from_intent.GetToolbarTitle
import com.catboy.goncharov_edu.usecases.repository.RepositorySave
import com.catboy.goncharov_edu.usecases.repository.RepositoryUpdate
import com.catboy.goncharov_edu.usecases.start_activity.StartTaskListActivity

class TaskPresenter(private val activity: ITaskActivity) {

    fun clickSaveButton(task: Task, intent: Intent) {

        if (!IsTaskTitleEmpty(task, activity).execute()) {
            if (IsUpdateTask(intent).execute()) {
                RepositoryUpdate(task, intent).execute()
            }else RepositorySave(task).execute()

            StartTaskListActivity(activity.getApplicationContext()).execute()
        }
    }

    fun setTitle(intent: Intent): String = GetToolbarTitle(intent).execute()
    fun setTaskTitle(intent: Intent): String = GetTaskTitle(intent).execute()
    fun setTaskText(intent: Intent) = GetTaskText(intent).execute()
    fun setTaskStatus(intent: Intent) = GetTaskStatus(intent).execute()

}