package com.catboy.goncharov_edu.usecases.data_from_intent

import android.content.Intent

class GetTaskTitle(private val intent: Intent) {

    fun execute(): String = intent.getStringExtra("title") ?: ""

}
