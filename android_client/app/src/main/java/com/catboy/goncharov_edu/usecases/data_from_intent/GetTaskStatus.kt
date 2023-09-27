package com.catboy.goncharov_edu.usecases.data_from_intent

import android.content.Intent

class GetTaskStatus(private val intent: Intent) {

    fun execute() = intent.getStringExtra("status") ?: "Задача добавлена"

}
