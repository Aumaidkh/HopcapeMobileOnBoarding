package com.hopcape.api.theme

import androidx.compose.ui.graphics.Color

data class DefaultLightTheme(
    override val backgroundColor: Color = defaultBackgroundColor,
    override val primaryColor: Color = defaultPrimaryColor,
    override val secondaryColor: Color = defaultSecondaryColor
): OnBoardingTheme
