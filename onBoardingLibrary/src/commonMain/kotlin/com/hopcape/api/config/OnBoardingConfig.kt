package com.hopcape.api.config

import androidx.compose.ui.graphics.Color
import com.hopcape.api.launcher.OnBoardingLauncher
import com.hopcape.api.page.OnBoardingPage
import com.hopcape.api.theme.OnBoardingTheme
import com.hopcape.di.container.OnBoardingModule
import com.hopcape.onboarding.data.local.datasource.BooleanKeyValueStorage

/**
 * Configuration class for the onboarding flow.
 *
 * [OnBoardingConfig] defines the structure and customization options for the onboarding experience.
 * It allows specifying the onboarding pages, theme, storage mechanism, and launcher.
 *
 * @property onBoardingPages A list of [OnBoardingPage] instances representing the onboarding screens.
 * @property theme The [OnBoardingTheme] that defines the visual styling of the onboarding flow.
 * @property keyValueStorage The storage mechanism ([BooleanKeyValueStorage]) for persisting onboarding-related data.
 *                           It is retrieved via [OnBoardingModule].
 * @property onBoardingLauncher An optional [OnBoardingLauncher] responsible for launching the onboarding flow.
 */
data class OnBoardingConfig(
    val onBoardingPages: List<OnBoardingPage>,
    val theme: OnBoardingTheme,
    val keyValueStorage: BooleanKeyValueStorage = OnBoardingModule.get(BooleanKeyValueStorage::class),
    val onBoardingLauncher: OnBoardingLauncher? = null
)

/**
 * Retrieves the primary color defined in the onboarding configuration theme.
 *
 * If the configuration is `null`, a default primary color (Green) is returned.
 *
 * @receiver The optional [OnBoardingConfig] instance.
 * @return The primary color from the theme, or Green if unavailable.
 */
fun OnBoardingConfig?.primaryColor(): Color {
    return this?.theme?.primaryColor ?: Color.Green
}

/**
 * Retrieves the secondary color defined in the onboarding configuration theme.
 *
 * If the configuration is `null`, a default secondary color (Green) is returned.
 *
 * @receiver The optional [OnBoardingConfig] instance.
 * @return The secondary color from the theme, or Green if unavailable.
 */
fun OnBoardingConfig?.secondaryColor(): Color {
    return this?.theme?.secondaryColor ?: Color.Green
}

/**
 * Retrieves the background color defined in the onboarding configuration theme.
 *
 * If the configuration is `null`, a default background color (Green) is returned.
 *
 * @receiver The optional [OnBoardingConfig] instance.
 * @return The background color from the theme, or Green if unavailable.
 */
fun OnBoardingConfig?.background(): Color {
    return this?.theme?.backgroundColor ?: Color.Green
}
