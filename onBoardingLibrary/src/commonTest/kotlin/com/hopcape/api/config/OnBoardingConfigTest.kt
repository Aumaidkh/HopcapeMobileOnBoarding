package com.hopcape.api.config

import kotlin.test.Test


import androidx.compose.ui.graphics.Color
import com.hopcape.api.theme.DefaultLightTheme
import com.hopcape.api.theme.OnBoardingTheme
import kotlin.test.assertEquals

/**
 * Unit tests for the [OnBoardingConfig] class and its extension functions.
 */
class OnBoardingConfigTest {

    /**
     * Test to verify that [OnBoardingConfig.primaryColor()] returns the correct primary color.
     */
    @Test
    fun `test primary color from config`() {
        // Arrange
        val theme: OnBoardingTheme = DefaultLightTheme()
        val config = OnBoardingConfig(onBoardingPages = emptyList(), theme = theme)

        // Act
        val result = config.primaryColor()

        // Assert
        assertEquals(theme.primaryColor, result, "Primary color should be correctly retrieved from the config.")
    }

    /**
     * Test to verify that [OnBoardingConfig.primaryColor()] returns default color (Green) if the config is null.
     */
    @Test
    fun `test primary color default when config is null`() {
        // Arrange
        val config: OnBoardingConfig? = null

        // Act
        val result = config.primaryColor()

        // Assert
        assertEquals(Color.Green, result, "Primary color should default to green when config is null.")
    }

    /**
     * Test to verify that [OnBoardingConfig.secondaryColor()] returns the correct secondary color.
     */
    @Test
    fun `test secondary color from config`() {
        // Arrange
        val theme: OnBoardingTheme = DefaultLightTheme()
        val config = OnBoardingConfig(onBoardingPages = emptyList(), theme = theme)

        // Act
        val result = config.secondaryColor()

        // Assert
        assertEquals(theme.secondaryColor, result, "Secondary color should be correctly retrieved from the config.")
    }

    /**
     * Test to verify that [OnBoardingConfig.secondaryColor()] returns default color (Green) if the config is null.
     */
    @Test
    fun `test secondary color default when config is null`() {
        // Arrange
        val config: OnBoardingConfig? = null

        // Act
        val result = config.secondaryColor()

        // Assert
        assertEquals(Color.Green, result, "Secondary color should default to green when config is null.")
    }

    /**
     * Test to verify that [OnBoardingConfig.background()] returns the correct background color.
     */
    @Test
    fun `test background color from config`() {
        // Arrange
        val theme: OnBoardingTheme = DefaultLightTheme()
        val config = OnBoardingConfig(onBoardingPages = emptyList(), theme = theme)

        // Act
        val result = config.background()

        // Assert
        assertEquals(theme.backgroundColor, result, "Background color should be correctly retrieved from the config.")
    }

    /**
     * Test to verify that [OnBoardingConfig.background()] returns default color (Green) if the config is null.
     */
    @Test
    fun `test background color default when config is null`() {
        // Arrange
        val config: OnBoardingConfig? = null

        // Act
        val result = config.background()

        // Assert
        assertEquals(Color.Green, result, "Background color should default to green when config is null.")
    }

    /**
     * Test to verify that [OnBoardingConfig] handles custom theme correctly.
     */
    @Test
    fun `test custom theme override`() {
        // Arrange
        val customTheme = DefaultLightTheme(
            backgroundColor = Color.Black,
            primaryColor = Color.Red,
            secondaryColor = Color.Yellow
        )
        val config = OnBoardingConfig(onBoardingPages = emptyList(), theme = customTheme)

        // Act & Assert
        assertEquals(Color.Black, config.background(), "Background color should be overridden to black.")
        assertEquals(Color.Red, config.primaryColor(), "Primary color should be overridden to red.")
        assertEquals(Color.Yellow, config.secondaryColor(), "Secondary color should be overridden to yellow.")
    }
}
