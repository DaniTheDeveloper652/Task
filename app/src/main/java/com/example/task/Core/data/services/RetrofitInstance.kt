package com.example.task.Core.data.services

import com.example.task.Core.data.Api.UserApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val baseUrl = "https://jsonplaceholder.typicode.com/"

    private fun getInstance(): Retrofit {

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val api: UserApi = getInstance().create(UserApi::class.java)

}