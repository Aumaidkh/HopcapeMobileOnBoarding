package com.hopcape.api.config

import androidx.compose.ui.graphics.Color
import com.hopcape.api.OnBoardingContext
import com.hopcape.api.OnBoardingPage
import com.hopcape.api.theme.OnBoardingTheme

data class OnBoardingConfig(
    val onBoardingPages: List<OnBoardingPage>,
    val theme: OnBoardingTheme,
    val context: OnBoardingContext
)

fun OnBoardingConfig?.primaryColor(): Color {
    return this?.theme?.primaryColor ?: Color.Green
}

fun OnBoardingConfig?.secondaryColor(): Color {
    return this?.theme?.secondaryColor ?: Color.Green
}

fun OnBoardingConfig?.background(): Color {
    return this?.theme?.backgroundColor ?: Color.Green
}


