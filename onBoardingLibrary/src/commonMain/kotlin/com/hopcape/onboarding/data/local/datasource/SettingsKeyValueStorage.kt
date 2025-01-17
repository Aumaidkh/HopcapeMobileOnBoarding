package com.hopcape.onboarding.data.local.datasource

import com.russhwolf.settings.Settings

/**
 * Implementation of [BooleanKeyValueStorage] that uses [Settings] for storing and retrieving Boolean values.
 *
 * This class provides the functionality to store and retrieve [Boolean] values associated with a given key
 * using the [Settings] API, which is a lightweight, thread-safe key-value storage library.
 * It allows simple persistence of Boolean preferences, such as flags or binary states, that can be
 * used in the onboarding flow or other parts of the app.
 *
 * The storage will persist the value across app sessions until explicitly changed or deleted.
 *
 * ## Usage
 * This class should be used for situations where you need to store a Boolean flag or simple Boolean value
 * persistently. It supports basic get and set operations, ensuring the value is stored in the [Settings] storage.
 *
 * ### Example:
 * ```kotlin
 * val booleanStorage: BooleanKeyValueStorage = SettingsKeyValueStorage(settings)
 * booleanStorage.set("hasCompletedOnboarding", true)
 * val hasCompleted = booleanStorage.get("hasCompletedOnboarding")
 * ```
 *
 * @param settings The [Settings] instance used for storing and retrieving the Boolean values.
 *
 * @see BooleanKeyValueStorage
 * @author Murtaza Khursheed
 */
internal class SettingsKeyValueStorage(
    private val settings: Settings
) : BooleanKeyValueStorage {

    /**
     * Retrieves a stored Boolean value associated with the given [key].
     *
     * This method returns the stored Boolean value. If the value does not exist, it will return `false` by default.
     *
     * @param key The key associated with the value to retrieve.
     * @return The stored Boolean value, or `false` if the key does not exist.
     */
    override fun get(key: String): Boolean {
        return settings.getBoolean(key, false)
    }

    /**
     * Stores a Boolean value associated with the given [key].
     *
     * This method stores the provided Boolean value under the specified key. The value will persist
     * in the [Settings] storage until explicitly changed or deleted.
     *
     * @param key The key to associate with the value to store.
     * @param value The Boolean value to store.
     */
    override fun set(key: String, value: Boolean) {
        settings.putBoolean(key, value)
    }
}
