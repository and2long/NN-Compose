package com.example.nn.api

import com.example.nn.bean.UserPoint

class NNRepo(private val api: NNApi) {

    suspend fun findUserPoint(userId: Int?): NResponse<UserPoint?> = api.findUserPoint(userId)

}