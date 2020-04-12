package com.hardik.mahant.mvvmdemo.data.repository

import com.hardik.mahant.mvvmdemo.data.api.RetrofitFactory
import com.hardik.mahant.mvvmdemo.data.api.response.LoginResponse
import retrofit2.Response

class UserRepository {

    suspend fun userLogin(email: String, password: String): Response<LoginResponse> {
        return RetrofitFactory.makeRetrofitService().userLogin(email, password)
    }
}