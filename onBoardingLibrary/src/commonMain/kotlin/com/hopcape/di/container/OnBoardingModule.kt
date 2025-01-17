package com.hopcape.di.container

import com.hopcape.di.factory.OnBoardingDependencyFactory
import com.hopcape.onboarding.data.local.OnBoardingPreferences
import com.hopcape.onboarding.data.local.datasource.BooleanKeyValueStorage
import com.hopcape.onboarding.presentation.OnBoardingViewModelFactory
import kotlin.reflect.KClass

/**
 * A singleton object that serves as the dependency container for onboarding-related services.
 *
 * The [OnBoardingModule] object manages the dependency graph and provides instances of dependencies
 * required for the onboarding process. It implements the [OnBoardingDiContainer] interface to allow
 * dependencies to be retrieved by their class type, enabling easy access to required services
 * throughout the onboarding process.
 *
 * Dependencies are registered using the [setDependencyFactory] function, which initializes the
 * dependency graph with the required services. Once initialized, the dependencies can be retrieved
 * using the [get] function. This ensures that all necessary components, such as preferences and
 * storage generators, are available when needed.
 *
 * This module is a key part of the onboarding system and facilitates the separation of concerns
 * by centralizing the management and provision of dependencies.
 *
 * @author Murtaza Khursheed
 *
 * @see OnBoardingDiContainer for more details on how dependencies are retrieved.
 */
internal object OnBoardingModule : OnBoardingDiContainer {

    private lateinit var dependencyGraph: MutableMap<KClass<*>, Any>

    /**
     * Retrieves an instance of the requested class type from the dependency container.
     *
     * This method allows you to fetch dependencies based on their class type. The [clazz] parameter
     * should be the class reference for which the instance is to be provided. If the dependency
     * is not found or the dependency graph is not initialized, an exception will be thrown.
     *
     * @param clazz The [KClass] reference of the type to be retrieved.
     * @return An instance of the requested type [T], where [T] is the class type passed in [clazz].
     * @throws IllegalStateException If the dependency graph is not initialized or if no dependency
     *         is found for the provided class.
     */
    override fun <T> get(clazz: KClass<*>): T {
        if (!OnBoardingModule::dependencyGraph.isInitialized) {
            throw IllegalStateException("Dependency Graph is not initialized")
        }

        return dependencyGraph[clazz] as? T
            ?: throw IllegalStateException("No dependency found for ${clazz.simpleName}")
    }

    /**
     * Sets the dependency factory for the onboarding module and registers dependencies.
     *
     * This function initializes the dependency graph by adding the onboarding-related
     * dependencies such as [OnBoardingPreferences], [BooleanKeyValueStorage], and [OnBoardingViewModelFactory]
     * to the container. It ensures that these dependencies are available for use when requested.
     *
     * @param onBoardingDependencyFactory The factory used to create onboarding dependencies.
     *        This factory provides the actual implementations of the dependencies needed for
     *        onboarding, such as storage preferences and view models.
     */
    fun setDependencyFactory(onBoardingDependencyFactory: OnBoardingDependencyFactory) {
        with(onBoardingDependencyFactory) {
            dependencyGraph = mutableMapOf()
            dependencyGraph[OnBoardingPreferences::class] = createOnBoardingPreferences()
            dependencyGraph[BooleanKeyValueStorage::class] = createOnBoardingKeyValueStorage()
            dependencyGraph[OnBoardingViewModelFactory::class] = OnBoardingViewModelFactory(createOnBoardingPreferences())
        }
    }
}
