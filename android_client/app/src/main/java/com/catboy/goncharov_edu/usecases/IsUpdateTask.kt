package com.catboy.goncharov_edu.usecases

import android.content.Intent

class IsUpdateTask(private val intent: Intent) {
    fun execute() = intent.hasExtra("index")
}