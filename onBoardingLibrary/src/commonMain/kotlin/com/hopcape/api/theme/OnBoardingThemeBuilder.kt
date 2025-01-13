package com.hopcape.api.theme

import androidx.compose.ui.graphics.Color

class OnBoardingThemeBuilder {

    private var onBoardingTheme = DefaultLightTheme()

    fun setBackgroundColor(color: Color) =
        apply {
            onBoardingTheme = onBoardingTheme.copy(
                backgroundColor = color
            )
        }

    fun setPrimaryColor(color: Color) =
        apply {
            onBoardingTheme = onBoardingTheme.copy(
                primaryColor = color
            )
        }

    fun setPrimaryColorArgb(color: Long) =
        apply {
            onBoardingTheme = onBoardingTheme.copy(
                primaryColor = Color(color)
            )
        }

    fun setSecondaryColor( color: Color ) =
        apply {
            onBoardingTheme = onBoardingTheme.copy(
                secondaryColor = color
            )
        }

    fun build(): OnBoardingTheme {
        return onBoardingTheme
    }
}