package com.example.nn.api

import retrofit2.Call
import retrofit2.CallAdapter
import java.lang.reflect.Type

class ResponseCallAdapter<R>(private val responseType: Type) : CallAdapter<R, NResponse<R>> {

    override fun responseType() = responseType

    override fun adapt(call: Call<R>): NResponse<R> {
        return try {
            val response = call.execute()
            if (response.isSuccessful) {
                @Suppress("UNCHECKED_CAST") val result = response.body() as NResponse<R>
                result
            } else {
                NResponse()
            }
        } catch (e: Throwable) {
            NResponse(retMsg = e.localizedMessage)
        }
    }
}
