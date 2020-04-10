package com.hardik.mahant.mvvmdemo.auth

import android.view.View
import androidx.lifecycle.ViewModel

class AuthViewModel: ViewModel() {

    var email: String? = null
    var password: String? = null

    private val authListener: AuthListener? = null

    fun onLoginPressed(view:View){
        authListener?.onStarted()
        if(email.isNullOrEmpty() || password.isNullOrEmpty()){
            authListener?.onFailure("Invalid EmailID or password")
            return
        }

        //authenticate now!
        authListener?.onFailure("Login success!")
    }

}