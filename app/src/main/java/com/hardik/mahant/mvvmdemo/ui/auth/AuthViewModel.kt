package com.hardik.mahant.mvvmdemo.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.hardik.mahant.mvvmdemo.data.repository.UserRepository

class AuthViewModel : ViewModel() {

    var email: String? = null
    var password: String? = null

    var authListener: AuthListener? = null

    fun onLoginPressed(view: View) {
        authListener?.onStarted()
        if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
            authListener?.onFailure("Invalid EmailID or password")
            return
        }

        val loginResponse = UserRepository()
            .userLogin(email!!, password!!)
        authListener?.onSuccess(loginResponse)
    }

    fun onRegisterPressed(view: View) {
        authListener?.onRegisterClicked()
    }

}