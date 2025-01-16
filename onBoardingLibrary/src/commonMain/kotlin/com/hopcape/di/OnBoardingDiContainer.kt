package com.hopcape.di

import kotlin.reflect.KClass

/**
 * A container interface for managing and providing dependency injection (DI) services
 * related to the onboarding process.
 *
 * This interface defines a method to retrieve instances of dependencies by their class type.
 * It acts as a container that allows the retrieval of objects in the onboarding module using
 * the provided class reference.
 *
 * The implementation of this interface is responsible for providing the correct instances
 * of dependencies, which may vary based on platform-specific implementations or configuration.
 *
 * @author Murtaza Khursheed
 */
internal interface OnBoardingDiContainer {

    /**
     * Retrieves an instance of the requested class type from the dependency container.
     *
     * This method allows you to fetch dependencies based on their class type. The [clazz]
     * parameter should be the class reference for which the instance is to be provided.
     *
     * @param clazz The [KClass] reference of the type to be retrieved.
     * @return An instance of the requested type [T], where [T] is the class type passed in [clazz].
     * @throws [NoSuchElementException] If the requested class is not found in the container.
     */
    fun <T> get(clazz: KClass<*>): T
}
