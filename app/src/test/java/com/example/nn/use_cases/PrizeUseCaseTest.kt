package com.example.nn.use_cases

import com.example.nn.api.NNRepo
import com.example.nn.api.NResponse
import com.example.nn.bean.UserPoint
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.test.assertEquals


class PrizeUseCaseTest {

    private val nnRepo = mockk<NNRepo>(relaxed = true)
    private val useCase = PrizeUseCase(nnRepo)

    @Test
    fun givenSuccessResult_whenLoadUserPoint_thenReturnScreenStateLoaded() = runBlocking {
        coEvery {
            nnRepo.findUserPoint(any())
        } returns NResponse(success = true, retData = UserPoint())

        val response = useCase.findUserPoint(userId = 1)
        assertEquals(true, response.success)
    }
}