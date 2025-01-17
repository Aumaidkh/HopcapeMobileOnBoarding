package com.hopcape.api.config

import com.hopcape.api.launcher.OnBoardingLauncher
import com.hopcape.api.page.OnBoardingPage
import com.hopcape.api.theme.DefaultLightTheme
import com.hopcape.api.theme.OnBoardingTheme
import com.hopcape.api.theme.OnBoardingThemeBuilder
import com.hopcape.onboarding.data.local.datasource.BooleanKeyValueStorage

/**
 * Builder class for configuring and creating an instance of [OnBoardingConfig].
 *
 * The [OnBoardingConfigBuilder] provides a fluent API for setting up various onboarding-related
 * configurations, including the launcher, pages, storage mechanism, and theme.
 *
 * This class ensures that onboarding components can be configured dynamically before being built
 * into an immutable [OnBoardingConfig] instance.
 *
 * ## Usage:
 * ```
 * val config = OnBoardingConfigBuilder()
 *     .addOnBoardingLauncher(myLauncher)
 *     .addKeyValueStorage(myKeyValueStorage)
 *     .addPages(listOf(page1, page2))
 *     .addTheme { myTheme }
 *     .build()
 * ```
 *
 * @author Murtaza Khursheed
 */
class OnBoardingConfigBuilder {

    /** The configuration object being constructed. Defaults to an empty list of pages and a default theme. */
    private var onBoardingConfig = OnBoardingConfig(emptyList(), DefaultLightTheme())

    /**
     * Sets the onboarding launcher responsible for handling onboarding flow initiation.
     *
     * @param launcher The [OnBoardingLauncher] instance to be used.
     * @return The current instance of [OnBoardingConfigBuilder] for method chaining.
     */
    fun addOnBoardingLauncher(launcher: OnBoardingLauncher) =
        apply {
            onBoardingConfig = onBoardingConfig.copy(
                onBoardingLauncher = launcher
            )
        }

    /**
     * Sets the key-value storage mechanism for persisting onboarding preferences.
     *
     * @param keyValueStorage The [BooleanKeyValueStorage] implementation used for storing onboarding-related data.
     * @return The current instance of [OnBoardingConfigBuilder] for method chaining.
     */
    fun addKeyValueStorage(keyValueStorage: BooleanKeyValueStorage) =
        apply {
            onBoardingConfig = onBoardingConfig.copy(
                keyValueStorage = keyValueStorage
            )
        }

    /**
     * Adds one or more onboarding pages to the configuration.
     *
     * @param pages A list of [OnBoardingPage] instances representing onboarding screens.
     * @return The current instance of [OnBoardingConfigBuilder] for method chaining.
     */
    fun addPages(pages: List<OnBoardingPage>) =
        apply {
            onBoardingConfig = onBoardingConfig.copy(
                onBoardingPages = onBoardingConfig.onBoardingPages + pages
            )
        }

    /**
     * Sets a custom theme for the onboarding UI using a builder function.
     *
     * @param themeBuilder A lambda function that builds an instance of [OnBoardingTheme].
     * @return The current instance of [OnBoardingConfigBuilder] for method chaining.
     */
    fun addTheme(themeBuilder: OnBoardingThemeBuilder.() -> OnBoardingTheme) =
        apply {
            val onBoardingThemeBuilder = OnBoardingThemeBuilder()
            onBoardingConfig = onBoardingConfig.copy(
                theme = themeBuilder.invoke(onBoardingThemeBuilder)
            )
        }

    /**
     * Builds and returns the configured [OnBoardingConfig] instance.
     *
     * @return A fully configured [OnBoardingConfig] object.
     */
    fun build(): OnBoardingConfig {
        return onBoardingConfig
    }
}
