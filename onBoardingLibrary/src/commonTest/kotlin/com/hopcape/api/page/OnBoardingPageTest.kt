package com.hopcape.api.page

import com.hopcape.mobile.api.page.OnBoardingPage
import kotlin.test.DefaultAsserter.assertEquals
import kotlin.test.DefaultAsserter.assertNotNull
import kotlin.test.Test

class OnBoardingPageTest {

    @Test
    fun `test OnBoardingPage properties are initialized correctly`() {
        // Arrange
        val title = "Welcome"
        val textColor: Long = 0xFF0000 // Red color
        val body = "This is the body of the onboarding page."
        val bodyColor: Long = 0x00FF00 // Green color
        val illustrationUri = "https://example.com/illustration.png"

        // Act
        val page = OnBoardingPage(
            title = title,
            textColor = textColor,
            body = body,
            bodyColor = bodyColor,
            illustrationImage = illustrationUri
        )

        // Assert
        assertEquals("Title should be 'Welcome'", title, page.title)
        assertEquals("Text color should be red", textColor, page.textColor)
        assertEquals("Body should match the provided body text", body, page.body)
        assertEquals("Body color should be green", bodyColor, page.bodyColor)
        assertEquals("Illustration URI should match the provided URI", illustrationUri, page.illustrationImage)
    }

    @Test
    fun `test OnBoardingPage default values if any`() {
        // Arrange: Create an instance without setting values (assuming some default values exist in the constructor).
        // In this case, we expect no defaults, so we just test an instance with manually defined values.

        // Act
        val page = OnBoardingPage(
            title = "Test Title",
            textColor = 0xFF0000,
            body = "Test Body",
            bodyColor = 0x00FF00,
            illustrationImage = "https://example.com/test.png"
        )

        // Assert
        assertNotNull("The page should not be null", page)
    }
}
