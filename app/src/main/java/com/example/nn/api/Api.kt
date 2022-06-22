package com.example.nn.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class Api {

    private val retrofit: Retrofit

    init {
        val logger =
            HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }

        val client = OkHttpClient.Builder()
            .addInterceptor(logger)
            .addInterceptor(HeaderInterceptor())
            .build()

        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(ResponseCallAdapterFactory())
            .build()
    }

    companion object {
        const val BASE_URL = "http://test1-opapi.nn.com/"
        const val APP_ID = "nnMobileIm_6z0g3ut7"
        const val REQ_CHANNEL = "2"
        const val TEMP_TOKEN = "nnMobileIm_6z0g3ut7c35fc5d7056a44b29d83b09d54351b49"

        private var instance: Api = Api()

        fun getInstance(): ApiService {
            return instance.retrofit.create(ApiService::class.java)
        }

    }

}