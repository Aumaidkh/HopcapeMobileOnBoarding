package com.hopcape.onboarding.data.local

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map

/**
 * Implementation of [OnBoardingPreferences] that interacts with [DataStore] to
 * store and retrieve the onboarding completion status.
 *
 * This class uses [DataStore] to persist the onboarding completion status, allowing
 * retrieval of whether the onboarding process has been completed or not.
 *
 * @property onBoardingStorageGenerator A generator that provides the [DataStore] instance.
 *
 * @author Murtaza Khursheed
 */
internal class OnBoardingPreferencesImpl(
    private val onBoardingStorageGenerator: OnBoardingStorageGenerator
): OnBoardingPreferences {

    private val storage by lazy {
        onBoardingStorageGenerator.dataStore
    }

    /**
     * Checks whether the onboarding process has been completed.
     *
     * This method checks the stored value for the onboarding completion status
     * and returns a boolean indicating whether the onboarding process is marked as completed.
     *
     * @return A boolean indicating the onboarding completion status.
     *         Returns `true` if the onboarding process has been completed, `false` otherwise.
     */
    override suspend fun isOnBoardingCompleted(): Boolean {
        return storage.getBooleanAsFlow(isOnBoardingCompleted).firstOrNull() ?: false
    }

    /**
     * Sets the onboarding completion status.
     *
     * This method updates the onboarding completion status to the specified value.
     * If `true`, the onboarding is marked as completed; if `false`, it is marked as incomplete.
     *
     * @param completed A boolean indicating whether the onboarding process is complete.
     *                  `true` marks the onboarding as completed, `false` marks it as incomplete.
     */
    override suspend fun setOnBoardingCompleted(completed: Boolean) {
        storage.saveBoolean(isOnBoardingCompleted, completed)
    }

    /**
     * Retrieves the value of a boolean preference as a flow.
     *
     * This is a helper method that returns a [Flow] containing the boolean value
     * stored under the given key. If no value is found, it will return `null`.
     *
     * @param key The [Preferences.Key] used to retrieve the stored value.
     * @return A flow that emits the boolean value stored in [DataStore] for the given key.
     */
    private fun DataStore<Preferences>.getBooleanAsFlow(key: Preferences.Key<Boolean>): Flow<Boolean?> {
        return this.data.map { preferences -> preferences[key] }
    }

    /**
     * Saves a boolean value in the [DataStore].
     *
     * This is a helper method that saves the given boolean value under the specified key.
     *
     * @param key The [Preferences.Key] under which the value will be stored.
     * @param value The boolean value to be stored.
     */
    private suspend fun DataStore<Preferences>.saveBoolean(key: Preferences.Key<Boolean>, value: Boolean) {
        this.edit { preferences ->
            preferences[key] = value
        }
    }

    companion object {
        // The key used to store the onboarding completion status in the DataStore.
        private val isOnBoardingCompleted = booleanPreferencesKey("isOnBoardingCompleted")
    }
}
