package com.hopcape.onboarding.data.local.datasource

/**
 * Interface for managing key-value storage specifically for [Boolean] values in onboarding-related preferences.
 *
 * This interface extends [KeyValueStorage] with a specialization for storing and retrieving [Boolean]
 * values. It provides the same functionality as [KeyValueStorage], but restricts the data type to [Boolean],
 * ensuring type safety when working with Boolean-based preferences.
 *
 * ## Usage
 * Implementations of this interface should provide a mechanism to store and retrieve [Boolean]
 * values persistently, such as using DataStore or SharedPreferences. The stored Boolean values
 * could represent simple flags, user preferences, or other binary data related to the onboarding flow.
 *
 * ### Example:
 * ```kotlin
 * val booleanStorage: BooleanKeyValueStorage = DataStoreBooleanKeyValueStorage(context)
 * booleanStorage.set("hasCompletedOnboarding", true)
 * val hasCompleted = booleanStorage.get("hasCompletedOnboarding")
 * ```
 *
 * @see KeyValueStorage
 * @author Murtaza Khursheed
 */
interface BooleanKeyValueStorage : KeyValueStorage<Boolean>
