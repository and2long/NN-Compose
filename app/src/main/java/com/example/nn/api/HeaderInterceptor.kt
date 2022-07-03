package com.example.nn.api

import okhttp3.Interceptor
import okhttp3.Response

const val APP_ID = "nnMobileIm_6z0g3ut7"
const val REQ_CHANNEL = "2"
const val TEMP_TOKEN = "nnMobileIm_6z0g3ut75a82e3aa717242b5a1b7a24e87387e31"

class HeaderInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val newBuilder = originalRequest.newBuilder()
        newBuilder.addHeader("appId", APP_ID)
        newBuilder.addHeader("reqChannel", REQ_CHANNEL)
        newBuilder.addHeader("token", TEMP_TOKEN)
        return chain.proceed(newBuilder.build())
    }
}
