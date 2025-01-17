package com.hopcape.api.kit

import com.hopcape.api.config.OnBoardingConfig
import com.hopcape.api.config.OnBoardingConfigBuilder
import com.hopcape.api.launcher.OnBoardingLauncher
import com.hopcape.di.factory.OnBoardingDependencyFactory

/**
 * Implementation of the [OnBoardingKit] interface that manages the onboarding flow.
 *
 * The [OnBoardingKitImpl] class is responsible for configuring and starting the onboarding flow in the application.
 * It provides the actual implementation for the methods defined in the [OnBoardingKit] interface, including configuration
 * setup and initiation of the onboarding process.
 *
 * The class utilizes an [OnBoardingLauncher] to trigger the onboarding flow and allows the configuration to be built
 * using the [OnBoardingConfigBuilder].
 *
 * @author Murtaza Khursheed
 */
internal class OnBoardingKitImpl(
    private val factory: OnBoardingDependencyFactory
): OnBoardingKit {

    // The launcher used to start the onboarding flow
    private lateinit var onBoardingLauncher: OnBoardingLauncher

    private val onBoardingPreferences by lazy { factory.createOnBoardingPreferences() }

    /**
     * Configures the onboarding flow with customizable settings.
     *
     * This method initializes the onboarding configuration using the [OnBoardingConfigBuilder] DSL.
     * It allows developers to define the onboarding experience by specifying pages, themes, storage,
     * and other settings before the onboarding process starts.
     *
     * ## Usage Example:
     * ```
     * onBoardingManager.configure {
     *     addOnBoardingLauncher(myLauncher)
     *     addPages(listOf(page1, page2))
     *     addTheme { myCustomTheme }
     * }
     * ```
     *
     * @param configBuilder A lambda function that configures the [OnBoardingConfig] using the [OnBoardingConfigBuilder] DSL.
     *                      This function allows defining various aspects of the onboarding experience, such as pages, themes,
     *                      and storage mechanisms.
     */
    override fun configure(configBuilder: OnBoardingConfigBuilder.() -> OnBoardingConfig) {
        val onBoardingConfigBuilder = OnBoardingConfigBuilder()
        OnBoardingKit.configuration = onBoardingConfigBuilder.configBuilder()
    }

    /**
     * Starts the onboarding flow.
     *
     * This function triggers the onboarding process and executes the provided [onComplete] callback when
     * the onboarding flow is finished. If the user is already onboarded, the callback is executed immediately.
     *
     * Throws [IllegalStateException] if the configuration or launcher has not been set before calling this method.
     *
     * @param onComplete A callback function to be executed upon completion of the onboarding process.
     * @throws IllegalStateException If the configuration or launcher has not been initialized.
     */
    override fun start(onComplete: () -> Unit) {
        if (OnBoardingKit.configuration == null){
            throw IllegalStateException("No Onboarding config found, did you forget to call configure")
        }
        if (isUserAlreadyOnBoarded()){
            onComplete()
            return
        }
        OnBoardingKit.configuration?.onBoardingLauncher?.launchOnBoarding()
    }

    /**
     * Determines whether the user has already completed the onboarding flow.
     *
     * This is a stub implementation that always returns `false`. The logic can be customized
     * to check for a persistent state indicating whether the user has completed onboarding.
     *
     * @return `true` if the user has already completed onboarding, otherwise `false`.
     */
    private fun isUserAlreadyOnBoarded(): Boolean {
        return onBoardingPreferences.isOnBoardingCompleted()
    }
}
