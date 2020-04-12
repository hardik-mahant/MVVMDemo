package com.hardik.mahant.mvvmdemo.ui.auth

import com.hardik.mahant.mvvmdemo.data.db.entities.User

interface AuthListener {

    fun onStarted()
    fun onSuccess(loginResponse: User)
    fun onFailure(message: String)
    fun onRegisterClicked()

}