package com.hardik.mahant.mvvmdemo.data.api.response

import com.hardik.mahant.mvvmdemo.data.db.entities.User

data class LoginResponse(
    val error: Boolean?,
    val message: String?,
    val data: User?
)