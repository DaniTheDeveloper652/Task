package com.example.task.Core.data.Api

import com.example.task.Core.data.UserMain
import com.example.task.Core.data.models.User
import com.example.task.Core.data.models.Users
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface UserApi{
    @GET("users")
    suspend fun getUsers(): Response<Users>

    @GET("users/{id}")
    suspend fun  getUserDetails(
        @Path("id") id: Int
    ): Response<UserMain>


}