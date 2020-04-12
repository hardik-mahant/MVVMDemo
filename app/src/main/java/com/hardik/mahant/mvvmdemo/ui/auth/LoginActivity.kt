package com.hardik.mahant.mvvmdemo.ui.auth

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.hardik.mahant.mvvmdemo.R
import com.hardik.mahant.mvvmdemo.databinding.ActivityLoginBinding
import com.hardik.mahant.mvvmdemo.util.hide
import com.hardik.mahant.mvvmdemo.util.show
import com.hardik.mahant.mvvmdemo.util.showToast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(),
    AuthListener {

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
        progressBar.show()
    }

    override fun onSuccess(loginResponse: LiveData<String>) {
        loginResponse.observe(this, Observer {
            showToast(it)
            progressBar.hide()
        })
    }

    override fun onFailure(message: String) {
        progressBar.hide()
        showToast("Auth Failure:$message")
    }

    override fun onRegisterClicked() {
        startActivity(Intent(this@LoginActivity, SignupActivity::class.java))
    }
}
