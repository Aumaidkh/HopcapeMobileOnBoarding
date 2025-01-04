package com.hopcape.api.config

import com.hopcape.api.OnBoardingPage
import com.hopcape.api.theme.DefaultLightTheme
import com.hopcape.api.theme.OnBoardingTheme
import com.hopcape.api.theme.OnBoardingThemeBuilder

class OnBoardingConfigBuilder {

    private var onBoardingConfig = OnBoardingConfig(emptyList(),DefaultLightTheme())

    fun addPages(vararg pages: OnBoardingPage) =
        apply {
            onBoardingConfig = onBoardingConfig.copy(
                onBoardingPages = onBoardingConfig.onBoardingPages + pages.asList()
            )
        }

    fun addTheme(themeBuilder: OnBoardingThemeBuilder.() -> OnBoardingTheme) =
        apply {
            val onBoardingThemeBuilder = OnBoardingThemeBuilder()
            onBoardingConfig =  onBoardingConfig.copy(
                theme = themeBuilder.invoke(onBoardingThemeBuilder)
            )
        }

    fun build(): OnBoardingConfig {
        return onBoardingConfig
    }
}