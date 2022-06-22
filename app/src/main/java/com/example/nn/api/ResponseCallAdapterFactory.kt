package com.example.nn.api

import retrofit2.CallAdapter
import retrofit2.CallAdapter.Factory
import retrofit2.Retrofit
import java.lang.reflect.Type

class ResponseCallAdapterFactory : Factory() {

    override fun get(returnType: Type, annotations: Array<Annotation>, retrofit: Retrofit): CallAdapter<*, *>? {
        if (getRawType(returnType) != NResponse::class.java) {
            return null
        }
        return ResponseCallAdapter<Any>(returnType)
    }
}
