package com.example.nn.use_cases

import com.example.nn.api.NNRepo
import com.example.nn.api.NResponse
import com.example.nn.bean.UserPoint

class PrizeUseCase(private val repo: NNRepo) {

    suspend fun findUserPoint(userId: Int?): NResponse<UserPoint?> = repo.findUserPoint(userId)

}
