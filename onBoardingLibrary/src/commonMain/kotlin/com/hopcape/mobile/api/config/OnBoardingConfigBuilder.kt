package com.hopcape.mobile.api.config

import com.hopcape.mobile.api.page.OnBoardingPage
import com.hopcape.mobile.api.theme.DefaultLightTheme
import com.hopcape.mobile.api.theme.OnBoardingTheme
import com.hopcape.mobile.api.theme.OnBoardingThemeBuilder

class OnBoardingConfigBuilder {

    private var onBoardingConfig = OnBoardingConfig(emptyList(), DefaultLightTheme())

    fun addPages(pages: OnBoardingPage) =
        apply {
            onBoardingConfig = onBoardingConfig.copy(
                onBoardingPages = onBoardingConfig.onBoardingPages + pages//.asList()
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