package com.hardik.mahant.mvvmdemo.util

import android.content.Context
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast

const val BASE_URL = "http://192.168.43.144/todoApp/"

fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun ProgressBar.show() {
    visibility = View.VISIBLE
}

fun ProgressBar.hide() {
    visibility = View.GONE
}