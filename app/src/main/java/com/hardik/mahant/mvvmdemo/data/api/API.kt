package com.hardik.mahant.mvvmdemo.data.api

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface API {

    @FormUrlEncoded
    @POST("login.php")
    fun userLogin(
        @Field("emailID") emailID: String,
        @Field("password") password: String
    ): Call<ResponseBody>

}