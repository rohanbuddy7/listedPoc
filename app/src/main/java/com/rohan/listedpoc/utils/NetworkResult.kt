package com.rohan.listedpoc.utils

sealed class NetworkResult<T>(var data: T? = null, var message: String? = null){
    class Success<T>(var datax: T?): NetworkResult<T>(datax)
    class Error<T>(var messagex: String?): NetworkResult<T>(null, messagex)
    class Loading<T>(): NetworkResult<T>()
}