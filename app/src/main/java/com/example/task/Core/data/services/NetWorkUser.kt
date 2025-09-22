package com.example.task.Core.data.services

sealed class  NetworkUsers<out T> {


    data class Success<out T>(val data: T): NetworkUsers<T>()

    data class Error(val message: String): NetworkUsers<Nothing>()

    object Loading: NetworkUsers<Nothing>()


}