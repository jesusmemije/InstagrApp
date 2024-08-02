package com.example.instagrapp.login.data.network

import com.example.instagrapp.login.data.network.response.LoginResponse
import retrofit2.Response
import retrofit2.http.GET

interface LoginClient {
    @GET("/v3/420f954f-6197-4dd6-bd0b-2aef2e77614c")
    suspend fun doLogin(): Response<LoginResponse>
}