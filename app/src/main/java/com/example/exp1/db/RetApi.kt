package com.example.exp1.db

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST


interface RetApi {
    @POST("user/login")
    fun login(@Body hashMap: HashMap<String, String>): Call<Login>

    @POST("auth/register")
    fun registration(@Body hashMap: HashMap<String, String>): Call<Void>
}