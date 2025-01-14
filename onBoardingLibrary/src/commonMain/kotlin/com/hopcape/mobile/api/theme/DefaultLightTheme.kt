package com.hopcape.mobile.api.theme

import androidx.compose.ui.graphics.Color

/**
 * Represents the default light theme for the onboarding flow.
 *
 * This theme provides default colors for the background, primary elements, and secondary elements,
 * adhering to a light theme design.
 *
 * @property backgroundColor The default background color of the theme. Defaults to [defaultBackgroundColor].
 * @property primaryColor The default primary color of the theme, typically used for key elements. Defaults to [defaultPrimaryColor].
 * @property secondaryColor The default secondary color of the theme, often used for supporting elements. Defaults to [defaultSecondaryColor].
 *
 * @author Murtaza Khursheed
 */
data class DefaultLightTheme(
    override val backgroundColor: Color = defaultBackgroundColor,
    override val primaryColor: Color = defaultPrimaryColor,
    override val secondaryColor: Color = defaultSecondaryColor
) : OnBoardingTheme
