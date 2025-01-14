package com.hopcape.api.theme

import kotlin.test.Test

import androidx.compose.ui.graphics.Color
import kotlin.test.assertEquals

/**
 * Unit tests for the [DefaultLightTheme] class to ensure that the default colors are correctly applied.
 */
class DefaultLightThemeTest {

    /**
     * Test to verify that the default primary color is correctly set to [defaultPrimaryColor].
     */
    @Test
    fun `test default primary color`() {
        // Arrange
        val theme = DefaultLightTheme()

        // Act & Assert
        assertEquals(defaultPrimaryColor, theme.primaryColor, "Primary color should be the default green color.")
    }

    /**
     * Test to verify that the default secondary color is correctly set to [defaultSecondaryColor].
     */
    @Test
    fun `test default secondary color`() {
        // Arrange
        val theme = DefaultLightTheme()

        // Act & Assert
        assertEquals(defaultSecondaryColor, theme.secondaryColor, "Secondary color should be the default light gray color.")
    }

    /**
     * Test to verify that the default background color is correctly set to [defaultBackgroundColor].
     */
    @Test
    fun `test default background color`() {
        // Arrange
        val theme = DefaultLightTheme()

        // Act & Assert
        assertEquals(defaultBackgroundColor, theme.backgroundColor, "Background color should be the default white color.")
    }

    /**
     * Test to verify that [DefaultLightTheme] correctly overrides the default background color.
     */
    @Test
    fun `test override background color`() {
        // Arrange
        val customBackgroundColor = Color.Red
        val theme = DefaultLightTheme(backgroundColor = customBackgroundColor)

        // Act & Assert
        assertEquals(customBackgroundColor, theme.backgroundColor, "Background color should be the overridden red color.")
    }

    /**
     * Test to verify that [DefaultLightTheme] correctly overrides the default primary color.
     */
    @Test
    fun `test override primary color`() {
        // Arrange
        val customPrimaryColor = Color.Blue
        val theme = DefaultLightTheme(primaryColor = customPrimaryColor)

        // Act & Assert
        assertEquals(customPrimaryColor, theme.primaryColor, "Primary color should be the overridden blue color.")
    }

    /**
     * Test to verify that [DefaultLightTheme] correctly overrides the default secondary color.
     */
    @Test
    fun `test override secondary color`() {
        // Arrange
        val customSecondaryColor = Color.Yellow
        val theme = DefaultLightTheme(secondaryColor = customSecondaryColor)

        // Act & Assert
        assertEquals(customSecondaryColor, theme.secondaryColor, "Secondary color should be the overridden yellow color.")
    }
}
