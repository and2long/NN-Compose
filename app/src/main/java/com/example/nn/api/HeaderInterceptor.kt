package com.example.nn.api

import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val newBuilder = originalRequest.newBuilder()
        newBuilder.addHeader("appId", Api.APP_ID)
        newBuilder.addHeader("reqChannel", Api.REQ_CHANNEL)
        newBuilder.addHeader("token", Api.TEMP_TOKEN)

        return chain.proceed(newBuilder.build())
    }
}
