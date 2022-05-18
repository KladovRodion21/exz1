package com.example.exp1.db

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MyRetrofit {
    fun getRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("http://food.madskill.ru")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

}