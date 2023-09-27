package com.catboy.goncharov_edu.usecases

import com.catboy.goncharov_edu.models.Task
import com.catboy.goncharov_edu.screens.ITaskActivity

class IsTaskTitleEmpty(private val task: Task, private val activity: ITaskActivity) {
    fun execute(): Boolean {
        return if (task.title.isEmpty()) {
            activity.taskTitleError()
            true
        }else false
    }
}