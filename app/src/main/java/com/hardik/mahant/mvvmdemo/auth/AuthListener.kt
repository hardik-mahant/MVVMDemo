package com.hardik.mahant.mvvmdemo.auth

interface AuthListener {

    fun onStarted()
    fun onSuccess()
    fun onFailure(message: String)

}