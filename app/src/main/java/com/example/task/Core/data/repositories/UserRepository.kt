package com.example.task.Core.data.repositories

import com.example.task.Core.data.UserMain
import com.example.task.Core.data.models.User
import com.example.task.Core.data.models.Users

interface UserRepository {
    suspend fun geAllUsers(): List<User>
    suspend fun getUserById(id: Int): UserMain?
}