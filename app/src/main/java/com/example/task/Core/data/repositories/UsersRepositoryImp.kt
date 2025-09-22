package com.example.task.Core.data.repositories

import android.util.Log
import com.example.task.Core.data.Api.UserApi
import com.example.task.Core.data.UserMain
import com.example.task.Core.data.models.User
import com.example.task.Core.data.models.Users
import com.example.task.Core.data.services.RetrofitInstance

class UsersRepositoryImp(
    private val userApi: UserApi
) : UserRepository {

    override suspend fun geAllUsers(): List<User> {
        val response = userApi.getUsers()
        return if (response.isSuccessful && response.body() != null) {
            response.body()!!
        } else {
            Log.d("665576325723", "geAllUsers: Error -> ${response.errorBody()}")
            emptyList()
        }
    }

    override suspend fun getUserById(id: Int): UserMain? {
        val response = userApi.getUserDetails(id)
        return if (response.isSuccessful && response.body() != null) {
            response.body()!!
        }else{
            Log.d("665576325723", "geAllUsers: Error -> ${response.errorBody()}")
            null
        }
    }
}