package com.hopcape.api.config

import androidx.compose.ui.graphics.Color
import com.hopcape.api.OnBoardingPage
import com.hopcape.api.theme.OnBoardingTheme

/**
 * Represents the configuration for the onboarding flow.
 *
 * @property onBoardingPages A list of pages to display in the onboarding flow.
 * @property theme The visual theme to be applied to the onboarding screens.
 */
data class OnBoardingConfig(
    val onBoardingPages: List<OnBoardingPage>,
    val theme: OnBoardingTheme
)

/**
 * Retrieves the primary color defined in the onboarding configuration theme.
 *
 * @receiver The optional onboarding configuration.
 * @return The primary color if available; otherwise, a default color (Green).
 */
fun OnBoardingConfig?.primaryColor(): Color {
    return this?.theme?.primaryColor ?: Color.Green
}

/**
 * Retrieves the secondary color defined in the onboarding configuration theme.
 *
 * @receiver The optional onboarding configuration.
 * @return The secondary color if available; otherwise, a default color (Green).
 */
fun OnBoardingConfig?.secondaryColor(): Color {
    return this?.theme?.secondaryColor ?: Color.Green
}

/**
 * Retrieves the background color defined in the onboarding configuration theme.
 *
 * @receiver The optional onboarding configuration.
 * @return The background color if available; otherwise, a default color (Green).
 */
fun OnBoardingConfig?.background(): Color {
    return this?.theme?.backgroundColor ?: Color.Green
}
