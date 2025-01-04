package com.hopcape.api.config

import com.hopcape.api.OnBoardingPage
import com.hopcape.api.theme.OnBoardingTheme

data class OnBoardingConfig(
    val onBoardingPages: List<OnBoardingPage>,
    val theme: OnBoardingTheme
)


