package com.hopcape.mobile.api.kit

import com.hopcape.mobile.api.config.OnBoardingConfig
import com.hopcape.mobile.api.config.OnBoardingConfigBuilder
import com.hopcape.mobile.api.launcher.OnBoardingLauncher

/**
 * Interface for managing the onboarding process in the application.
 *
 * The [OnBoardingKit] interface provides functionality for configuring and starting the onboarding
 * flow. It allows setting up the onboarding launcher and building the onboarding configuration.
 *
 * The onboarding configuration can be customized using the [OnBoardingConfigBuilder] and then passed
 * to the [OnBoardingKit.configure] method. The flow is initiated with the [OnBoardingKit.start] method,
 * which takes a callback function [onComplete] that will be executed upon completion of the onboarding.
 *
 * @property configuration An optional [OnBoardingConfig] used to customize the onboarding flow.
 *
 * @author Murtaza Khursheed
 */
interface OnBoardingKit {

    companion object {
        /**
         * The global configuration for the onboarding flow.
         * It can be customized and accessed across different instances of the onboarding kit.
         */
        var configuration: OnBoardingConfig? = null
    }

    /**
     * Configures the onboarding flow.
     *
     * This function allows configuring the onboarding process by providing the necessary launcher and
     * configuration details. The [OnBoardingConfigBuilder] is used to build the configuration, which can
     * be customized using the provided DSL.
     *
     * @param onBoardingLauncher The launcher used to start the onboarding flow.
     * @param configBuilder A lambda function that builds the [OnBoardingConfig] using the [OnBoardingConfigBuilder].
     */
    fun configure(
        onBoardingLauncher: OnBoardingLauncher,
        configBuilder: OnBoardingConfigBuilder.() -> OnBoardingConfig
    )

    /**
     * Starts the onboarding flow.
     *
     * This function triggers the onboarding process and executes the provided [onComplete] callback when
     * the onboarding flow is finished.
     *
     * @param onComplete A callback function to be executed upon completion of the onboarding process.
     */
    fun start(
        onComplete: () -> Unit
    )
}
