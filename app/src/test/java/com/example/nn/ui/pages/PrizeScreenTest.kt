package com.example.nn.ui.pages

import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class PrizeScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun defaultPointWithZero() {
        composeTestRule.setContent {
            PrizeScreen()
        }
        composeTestRule.onNodeWithTag("point").assertExists()
        composeTestRule.onNodeWithTag("point").assertTextEquals("0")
    }
}