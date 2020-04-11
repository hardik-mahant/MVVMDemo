package com.hardik.mahant.mvvmdemo.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.hardik.mahant.mvvmdemo.R
import com.hardik.mahant.mvvmdemo.databinding.ActivityLoginBinding
import com.hardik.mahant.mvvmdemo.util.showToast

class LoginActivity : AppCompatActivity(), AuthListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityLoginBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_login)
        val vm = ViewModelProvider(this).get(AuthViewModel::class.java)
        binding.loginViewModel = vm
        vm.authListener = this
    }

    override fun onStarted() {
        showToast("Auth Started")
    }

    override fun onSuccess() {
        showToast("Auth Success")
    }

    override fun onFailure(message: String) {
        showToast("Auth Failure:$message")
    }
}
