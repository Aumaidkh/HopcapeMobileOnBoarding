package com.hopcape.onboarding.data.local.datasource

/**
 * Interface for managing key-value storage for onboarding-related preferences.
 *
 * The [KeyValueStorage] interface defines a contract for storing and retrieving key-value pairs
 * in a persistent storage mechanism, such as DataStore. This interface supports generic operations
 * for handling various data types, ensuring data persistence across app sessions.
 *
 * ## Usage
 * Implementations of this interface are expected to store and retrieve data in a thread-safe,
 * efficient, and persistent manner. Depending on the storage backend used (e.g., DataStore),
 * the storage should handle storage file names, extensions, and other configuration details
 * as required by the backend.
 *
 * This interface allows for flexible usage with different data types, represented by the generic
 * type [T]. Implementations should ensure compatibility with these types and provide proper
 * handling of data consistency.
 *
 * ### Example:
 * ```kotlin
 * val keyValueStorage: KeyValueStorage<String> = DataStoreKeyValueStorage(context)
 * keyValueStorage.set("username", "user123")
 * val username = keyValueStorage.get("username")
 * ```
 *
 * @author Murtaza Khursheed
 */
interface KeyValueStorage<T> {

    /**
     * Retrieves a stored value associated with the given [key].
     *
     * This method returns a nullable value of type [T]. If the value does not exist or if there is a
     * type mismatch, it will return `null`.
     *
     * @param key The key associated with the value to retrieve.
     * @return The stored value of type [T]
     */
    fun get(key: String): T

    /**
     * Stores a value associated with the given [key].
     *
     * This method stores the value of type [T] under the specified key. The value will persist in storage
     * until it is explicitly changed or deleted.
     *
     * @param key The key to associate with the value to store.
     * @param value The value to store.
     */
    fun set(key: String, value: T)

    companion object {
        /**
         * The filename used for storing onboarding-related preferences.
         *
         * Implementations should ensure that the file extension used matches the requirements
         * of the underlying storage system. For example, DataStore requires a `.preferences_pb`
         * extension when using `PreferencesDataStore`. Ensure that the filename matches the
         * storage system's format.
         */
        const val STORAGE_FILE_NAME = "onboarding_preferences"
    }
}
