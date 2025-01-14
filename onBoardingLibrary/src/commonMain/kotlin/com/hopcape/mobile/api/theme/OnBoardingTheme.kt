package com.hopcape.mobile.api.theme

import androidx.compose.ui.graphics.Color

/**
 * Defines the theme for the onboarding screens.
 *
 * Implement this interface to provide the visual styles used in the onboarding flow,
 * including the primary color, secondary color, and background color.
 *
 * @author Murtaza Khursheed
 */
interface OnBoardingTheme {

    /**
     * The primary color used in the onboarding theme.
     * This color typically represents key elements or highlights in the UI.
     */
    val primaryColor: Color

    /**
     * The secondary color used in the onboarding theme.
     * This color is usually used for supporting elements or accents in the UI.
     */
    val secondaryColor: Color

    /**
     * The background color used in the onboarding theme.
     * This color is applied as the base background for onboarding screens.
     */
    val backgroundColor: Color
}
