package com.example.nn.api

data class NResponse<out T>(
    var retMsg: String? = null,
    var retCode: String? = null,
    val retData: T? = null,
    var retTime: String? = null,
    var success: Boolean = false,
)