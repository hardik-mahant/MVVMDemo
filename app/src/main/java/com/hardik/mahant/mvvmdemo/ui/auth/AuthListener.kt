package com.hardik.mahant.mvvmdemo.ui.auth

import androidx.lifecycle.LiveData

interface AuthListener {

    fun onStarted()
    fun onSuccess(loginResponse: LiveData<String>)
    fun onFailure(message: String)
    fun onRegisterClicked()

}