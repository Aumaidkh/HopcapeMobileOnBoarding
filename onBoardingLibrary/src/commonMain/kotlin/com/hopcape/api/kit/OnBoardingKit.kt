package com.hopcape.api.kit

import com.hopcape.api.config.OnBoardingConfig
import com.hopcape.api.config.OnBoardingConfigBuilder
import com.hopcape.api.kit.OnBoardingKit.Companion.configuration
import com.hopcape.api.launcher.OnBoardingLauncher
import com.hopcape.di.DefaultDependencyGeneratorFactory
import com.hopcape.di.OnBoardingDependencyFactory
import com.hopcape.di.OnBoardingModule
import kotlin.experimental.ExperimentalObjCName
import kotlin.jvm.JvmStatic
import kotlin.native.ObjCName

/**
 * Interface for managing the onboarding process in the application.
 *
 * The [OnBoardingKit] interface provides methods to configure, initiate, and customize the onboarding flow
 * in the application. It allows setting up the onboarding configuration and specifying how the onboarding
 * process should be started and completed. The flow can be managed using the provided configuration and launcher.
 *
 * The onboarding configuration can be customized using the [OnBoardingConfigBuilder], which allows setting
 * specific preferences for the onboarding experience. Once configured, the onboarding flow can be started using
 * the [start] method, and a callback will be triggered once the onboarding is completed.
 *
 * @property configuration An optional global [OnBoardingConfig] that can be used to customize the onboarding
 * flow for all instances of the onboarding kit.
 *
 * @author Murtaza Khursheed
 */
interface OnBoardingKit {

    companion object {
        /**
         * The global configuration for the onboarding flow.
         * This configuration can be customized and accessed across different instances of the onboarding kit.
         *
         * If not provided, the default configuration will be used for the onboarding process.
         */
        var configuration: OnBoardingConfig? = null

        /**
         * Creates an instance of [OnBoardingKit] with a specified dependency factory.
         *
         * This method sets up the required dependencies using the [OnBoardingModule] and provides an instance
         * of [OnBoardingKitImpl]. It uses the provided [OnBoardingDependencyFactory] to set up the onboarding
         * dependency graph.
         *
         * By default, the [DefaultDependencyGeneratorFactory] is used if no factory is specified.
         *
         * @param factory The [OnBoardingDependencyFactory] used to initialize the dependency graph.
         * @return An instance of [OnBoardingKit], fully configured with the necessary dependencies.
         */
        fun create(factory: OnBoardingDependencyFactory): OnBoardingKit {
            OnBoardingModule.setDependencyFactory(factory)
            return OnBoardingKitImpl(factory)
        }

        @OptIn(ExperimentalObjCName::class)
        @JvmStatic
        @ObjCName("create")
        fun create(): OnBoardingKit {
            return create(
                factory = DefaultDependencyGeneratorFactory()
            )
        }
    }

    /**
     * Configures the onboarding flow.
     *
     * This method sets up the configuration and launcher for the onboarding process. It allows customization
     * of the onboarding experience by using the [OnBoardingConfigBuilder] DSL. This method ensures that the
     * onboarding process is set up with the necessary configurations before it is started.
     *
     * @param onBoardingLauncher The [OnBoardingLauncher] responsible for triggering the onboarding flow.
     * @param configBuilder A lambda function that builds the [OnBoardingConfig] using the [OnBoardingConfigBuilder] DSL.
     *                      The configuration defines the settings for the onboarding experience.
     */
    fun configure(
        onBoardingLauncher: OnBoardingLauncher,
        configBuilder: OnBoardingConfigBuilder.() -> OnBoardingConfig
    )

    /**
     * Starts the onboarding flow.
     *
     * This method initiates the onboarding process. Upon completion of the onboarding, the [onComplete] callback
     * function will be executed. This provides a way to perform additional actions after the onboarding process
     * has finished, such as navigating to the main part of the app.
     *
     * @param onComplete A callback function to be executed once the onboarding process is completed.
     */
    fun start(
        onComplete: () -> Unit
    )
}
