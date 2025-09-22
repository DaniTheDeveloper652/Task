package com.example.task.Core.data.Viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.task.Core.data.Api.UserApi
import com.example.task.Core.data.UserMain
import com.example.task.Core.data.models.User
import com.example.task.Core.data.models.Users
import com.example.task.Core.data.repositories.UsersRepositoryImp
import com.example.task.Core.data.services.NetworkUsers
import com.example.task.Core.data.services.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UserViewModel: ViewModel() {

    private val userApi: UserApi = RetrofitInstance.api
    private val repo = UsersRepositoryImp(userApi)

    private val _users = MutableStateFlow<List<User>>(emptyList())
    val users: StateFlow<List<User>> = _users

    private val _userById = MutableStateFlow<UserMain?>(null)
    val user: StateFlow<UserMain?> = _userById

    fun getAllUsers(){
        viewModelScope.launch {
            val users = repo.geAllUsers()
            _users.value = users
        }
    }

    fun getUserById(id: Int){
        viewModelScope.launch {
            val user = repo.getUserById(id)
            _userById.value = user
        }
    }
}
