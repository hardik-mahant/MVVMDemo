package com.hardik.mahant.mvvmdemo.api

import com.google.gson.GsonBuilder
import com.hardik.mahant.mvvmdemo.util.BASE_URL
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitFactory {
    fun makeRetrofitService(baseURL: String = BASE_URL, useGSON: Boolean = false): API {
        val gson = GsonBuilder()
            .setLenient()
            .create()

        val client = OkHttpClient().newBuilder().build()

        return if (useGSON) {
            Retrofit.Builder()
                .baseUrl(baseURL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build().create(API::class.java)
        } else {
            Retrofit.Builder()
                .baseUrl(baseURL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build().create(API::class.java)
        }
    }
}