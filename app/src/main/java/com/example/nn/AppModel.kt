package com.example.nn

import com.example.nn.api.ApiClient
import com.example.nn.api.NNRepo
import com.example.nn.use_cases.PrizeUseCase
import org.koin.dsl.module

val appModule = module {
    single { ApiClient.nnApi }
    single { NNRepo(get()) }
    factory { PrizeUseCase(get()) }
}