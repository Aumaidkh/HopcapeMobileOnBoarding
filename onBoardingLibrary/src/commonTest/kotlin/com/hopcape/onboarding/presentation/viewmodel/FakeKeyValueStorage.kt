package com.hopcape.onboarding.presentation.viewmodel

import com.hopcape.onboarding.data.local.datasource.BooleanKeyValueStorage

/**
 * A fake implementation of [BooleanKeyValueStorage] for testing purposes.
 *
 * This class provides an in-memory key-value storage that simulates the behavior of a persistent storage
 * system for boolean values. It does not use any actual [DataStore] or file storage. Instead, it relies
 * on a mutable map to store key-value pairs during the lifetime of the object, making it suitable for unit
 * testing scenarios where a real persistent storage mechanism is not needed.
 *
 * The stored data will persist only for the lifetime of the `FakeKeyValueStorage` instance, and is cleared
 * when the instance is destroyed. This class is intended for testing and mock purposes, simulating the
 * behavior of a key-value store without requiring actual disk I/O.
 *
 * @author Murtaza Khursheed
 */
class FakeKeyValueStorage : BooleanKeyValueStorage {

    // A mutable map to simulate in-memory storage of key-value pairs.
    private val mutableMap = mutableMapOf<String, Boolean>()

    /**
     * Retrieves a stored value associated with the given [key].
     *
     * This method checks the in-memory map for the specified key and returns the associated boolean value.
     * If the key does not exist, it returns `false` by default.
     *
     * @param key The key associated with the value to retrieve.
     * @return The stored boolean value or `false` if the key is not found.
     */
    override fun get(key: String): Boolean {
        return mutableMap[key] ?: false
    }

    /**
     * Stores a boolean value associated with the given [key].
     *
     * This method stores the boolean value in the in-memory map under the specified key.
     * The value will persist in memory until explicitly changed or deleted.
     *
     * @param key The key to associate with the value to store.
     * @param value The boolean value to store.
     */
    override fun set(key: String, value: Boolean) {
        mutableMap[key] = value
    }
}
