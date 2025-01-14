package com.hopcape.mobile.api.theme

import androidx.compose.ui.graphics.Color

/**
 * Builder class for creating and customizing an instance of [OnBoardingTheme].
 * This class provides methods to set various theme attributes like background color,
 * primary color, and secondary color, allowing customization of the onboarding theme.
 *
 * @author Murtaza Khursheed
 */
class OnBoardingThemeBuilder {

    private var onBoardingTheme = DefaultLightTheme()

    /**
     * Sets the background color of the onboarding theme.
     *
     * @param color The [Color] to set as the background color.
     * @return The current instance of [OnBoardingThemeBuilder] for chaining calls.
     */
    fun setBackgroundColor(color: Color) =
        apply {
            onBoardingTheme = onBoardingTheme.copy(
                backgroundColor = color
            )
        }

    /**
     * Sets the primary color of the onboarding theme.
     *
     * @param color The [Color] to set as the primary color.
     * @return The current instance of [OnBoardingThemeBuilder] for chaining calls.
     */
    fun setPrimaryColor(color: Color) =
        apply {
            onBoardingTheme = onBoardingTheme.copy(
                primaryColor = color
            )
        }

    /**
     * Sets the primary color of the onboarding theme using an ARGB long value.
     *
     * @param color The ARGB long value representing the primary color.
     * @return The current instance of [OnBoardingThemeBuilder] for chaining calls.
     */
    fun setPrimaryColorArgb(color: Long) =
        apply {
            onBoardingTheme = onBoardingTheme.copy(
                primaryColor = Color(color)
            )
        }

    /**
     * Sets the secondary color of the onboarding theme.
     *
     * @param color The [Color] to set as the secondary color.
     * @return The current instance of [OnBoardingThemeBuilder] for chaining calls.
     */
    fun setSecondaryColor(color: Color) =
        apply {
            onBoardingTheme = onBoardingTheme.copy(
                secondaryColor = color
            )
        }

    /**
     * Builds and returns the configured [OnBoardingTheme].
     *
     * @return The [OnBoardingTheme] instance with the applied customizations.
     */
    fun build(): OnBoardingTheme {
        return onBoardingTheme
    }
}
