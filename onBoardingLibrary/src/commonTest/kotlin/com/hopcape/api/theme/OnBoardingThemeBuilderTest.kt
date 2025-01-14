package com.hopcape.api.theme

import androidx.compose.ui.graphics.Color
import com.hopcape.mobile.api.theme.OnBoardingThemeBuilder
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals


class OnBoardingThemeBuilderTest {

    private lateinit var themeBuilder: OnBoardingThemeBuilder

    @BeforeTest
    fun setUp() {
        themeBuilder = OnBoardingThemeBuilder()
    }

    @Test
    fun `setBackgroundColor should update backgroundColor`() {
        // Arrange
        val expectedColor = Color(0xFF0000FF) // Blue color

        // Act
        val resultTheme = themeBuilder
            .setBackgroundColor(expectedColor)
            .build()

        // Assert
        assertEquals(expectedColor, resultTheme.backgroundColor)
    }

    @Test
    fun `setPrimaryColor should update primaryColor`() {
        // Arrange
        val expectedColor = Color(0xFFFF0000) // Red color

        // Act
        val resultTheme = themeBuilder
            .setPrimaryColor(expectedColor)
            .build()

        // Assert
        assertEquals(expectedColor, resultTheme.primaryColor)
    }

    @Test
    fun `setPrimaryColorArgb should update primaryColor`() {
        // Arrange
        val expectedColor = Color(0xFF00FF00) // Green color

        // Act
        val resultTheme = themeBuilder
            .setPrimaryColorArgb(0xFF00FF00)
            .build()

        // Assert
        assertEquals(expectedColor, resultTheme.primaryColor)
    }

    @Test
    fun `setSecondaryColor should update secondaryColor`() {
        // Arrange
        val expectedColor = Color(0xFFFFFF00) // Yellow color

        // Act
        val resultTheme = themeBuilder
            .setSecondaryColor(expectedColor)
            .build()

        // Assert
        assertEquals(expectedColor, resultTheme.secondaryColor)
    }

    @Test
    fun `build should return the configured OnBoardingTheme`() {
        // Arrange
        val backgroundColor = Color(0xFFCCCCCC)
        val primaryColor = Color(0xFFFF0000)
        val secondaryColor = Color(0xFF00FF00)

        // Act
        val resultTheme = themeBuilder
            .setBackgroundColor(backgroundColor)
            .setPrimaryColor(primaryColor)
            .setSecondaryColor(secondaryColor)
            .build()

        // Assert
        assertEquals(backgroundColor, resultTheme.backgroundColor)
        assertEquals(primaryColor, resultTheme.primaryColor)
        assertEquals(secondaryColor, resultTheme.secondaryColor)
    }
}
