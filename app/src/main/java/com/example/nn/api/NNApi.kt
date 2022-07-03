package com.example.nn.api

import com.example.nn.bean.TaskBean
import com.example.nn.bean.UserPoint
import retrofit2.http.POST
import retrofit2.http.Path

interface NNApi {

    @POST("nn-assist/taskPoints/findUserPoint/{userId}")
    suspend fun findUserPoint(@Path("userId") userId: Int?): NResponse<UserPoint?>

    @POST("nn-assist/taskPoints/findAllTask")
    suspend fun findAllTask(): NResponse<List<TaskBean>>
}