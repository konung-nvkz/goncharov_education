package com.catboy.goncharov_edu.usecases.data_from_intent

import android.content.Intent
import com.catboy.goncharov_edu.usecases.IsUpdateTask

class GetToolbarTitle(private val intent: Intent) {
    fun execute(): String = if (IsUpdateTask(intent).execute()) "Изменить задачу"
            else "Добавить задачу"

}
