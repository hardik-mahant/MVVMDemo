package com.hardik.mahant.mvvmdemo.data.api

import com.hardik.mahant.mvvmdemo.data.api.response.LoginResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface API {

    @FormUrlEncoded
    @POST("login.php")
    suspend fun userLogin(
        @Field("emailID") emailID: String,
        @Field("password") password: String
    ): Response<LoginResponse>

}