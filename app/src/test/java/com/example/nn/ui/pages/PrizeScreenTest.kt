package com.example.nn.ui.pages

import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.example.nn.view_models.PrizeViewModel
import io.mockk.mockk
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class PrizeScreenTest {

    private val viewModel = mockk<PrizeViewModel>(relaxed = false)

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun defaultPointWithZero() {
        composeTestRule.setContent {
            PrizeScreen(PrizeScreenElementState(viewModel))
        }
        composeTestRule.onNodeWithTag("point").assertExists()
        composeTestRule.onNodeWithTag("point").assertTextEquals("0")
    }
}