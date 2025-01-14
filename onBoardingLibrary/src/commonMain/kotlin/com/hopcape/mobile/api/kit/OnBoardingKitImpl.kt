package com.hopcape.mobile.api.kit

import com.hopcape.mobile.api.config.OnBoardingConfig
import com.hopcape.mobile.api.config.OnBoardingConfigBuilder
import com.hopcape.mobile.api.launcher.OnBoardingLauncher

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
class OnBoardingKitImpl: OnBoardingKit {

    // The launcher used to start the onboarding flow
    private lateinit var onBoardingLauncher: OnBoardingLauncher

    /**
     * Configures the onboarding flow.
     *
     * This function allows configuring the onboarding process by providing the necessary launcher and
     * configuration details. The [OnBoardingConfigBuilder] is used to build the configuration, which can
     * be customized using the provided DSL.
     *
     * The resulting configuration is stored in the [OnBoardingKit.configuration] property.
     *
     * @param onBoardingLauncher The launcher used to start the onboarding flow.
     * @param configBuilder A lambda function that builds the [OnBoardingConfig] using the [OnBoardingConfigBuilder].
     */
    override fun configure(
        onBoardingLauncher: OnBoardingLauncher,
        configBuilder: OnBoardingConfigBuilder.() -> OnBoardingConfig
    ) {
        val onBoardingConfigBuilder = OnBoardingConfigBuilder()
        OnBoardingKit.configuration = onBoardingConfigBuilder.configBuilder()
        this.onBoardingLauncher = onBoardingLauncher
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
        if (!::onBoardingLauncher.isInitialized){
            throw IllegalStateException("No OnBoarding launcher passed while configuration")
        }
        if (isUserAlreadyOnBoarded()){
            onComplete()
            return
        }
        onBoardingLauncher.launchOnBoarding()
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
        return false
    }
}
