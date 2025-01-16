package com.hopcape.di

import com.hopcape.onboarding.data.local.OnBoardingPreferences
import com.hopcape.onboarding.data.local.OnBoardingStorageGenerator
import com.hopcape.onboarding.presentation.OnBoardingViewModelFactory
import kotlin.reflect.KClass

/**
 * A singleton object that serves as the dependency container for onboarding-related services.
 *
 * The [OnBoardingModule] object manages the dependency graph and provides instances of dependencies
 * required for the onboarding process. It follows the [OnBoardingDiContainer] interface to retrieve
 * and store dependencies by their class type.
 *
 * Dependencies are registered using the [setDependencyFactory] function and can be retrieved using
 * the [get] function. The module ensures that the correct instances are available for onboarding
 * tasks, such as managing preferences and storage generators.
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
        if (!::dependencyGraph.isInitialized) {
            throw IllegalStateException("Dependency Graph is not initialized")
        }

        return dependencyGraph[clazz] as? T
            ?: throw IllegalStateException("No dependency found for ${clazz.simpleName}")
    }

    /**
     * Sets the dependency factory for the onboarding module and registers dependencies.
     *
     * This function initializes the dependency graph by adding the onboarding-related
     * dependencies such as [OnBoardingPreferences] and [OnBoardingStorageGenerator] to the container.
     *
     * @param onBoardingDependencyFactory The factory used to create onboarding dependencies.
     */
    fun setDependencyFactory(onBoardingDependencyFactory: OnBoardingDependencyFactory) {
        with(onBoardingDependencyFactory) {
            dependencyGraph = mutableMapOf()
            dependencyGraph[OnBoardingPreferences::class] = createOnBoardingPreferences()
            dependencyGraph[OnBoardingStorageGenerator::class] = createOnBoardingDatastoreGenerator()
            dependencyGraph[OnBoardingViewModelFactory::class] = OnBoardingViewModelFactory(createOnBoardingPreferences())
        }
    }
}
