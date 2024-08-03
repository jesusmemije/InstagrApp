package com.example.instagrapp.login.data.network

import com.example.instagrapp.login.data.network.response.LoginResponse
import retrofit2.Response
import retrofit2.http.GET

interface LoginClient {
    @GET("/v3/24374999-749a-4861-8053-1bf42dc8c180")
    suspend fun doLogin(): Response<LoginResponse>
}