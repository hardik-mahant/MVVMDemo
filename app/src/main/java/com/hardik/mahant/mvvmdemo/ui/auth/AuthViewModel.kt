package com.hardik.mahant.mvvmdemo.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.hardik.mahant.mvvmdemo.data.repository.UserRepository
import com.hardik.mahant.mvvmdemo.util.Coroutines

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

        Coroutines.main {
            val response = UserRepository().userLogin(email!!, password!!)
            if (response.isSuccessful) {
                authListener?.onSuccess(response.body()?.data!!)
            } else {
                authListener?.onFailure("Error code: ${response.code()}")
            }
        }
    }

    fun onRegisterPressed(view: View) {
        authListener?.onRegisterClicked()
    }

}