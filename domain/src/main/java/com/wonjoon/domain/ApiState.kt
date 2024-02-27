package com.wonjoon.domain

sealed class ApiState<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T) : ApiState<T>(data)
    class Error400<T>(message: String, data: T? = null) : ApiState<T>(data, message)
    class Error401<T>(message: String, data: T? = null) : ApiState<T>(data, message)
    class Error403<T>(message: String, data: T? = null) : ApiState<T>(data, message)
    class Error404<T>(message: String, data: T? = null) : ApiState<T>(data, message)
    class Error406<T>(message: String, data: T? = null) : ApiState<T>(data, message)
    class Error<T>(message: String, data: T? = null) : ApiState<T>(data, message)
    class Loading<T> : ApiState<T>()
}