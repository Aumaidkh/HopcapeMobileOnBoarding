package com.hopcape.onboarding.data.local

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences

/**
 * Interface responsible for providing a DataStore instance for storing onboarding-related preferences.
 *
 * The [OnBoardingStorageGenerator] interface defines a contract for classes that need access to
 * a DataStore for managing and storing onboarding preferences in a key-value format.
 * The [dataStore] property exposes the DataStore instance that handles the preferences.
 *
 * @author Murtaza Khursheed
 */
interface OnBoardingStorageGenerator {

    /**
     * Provides the [DataStore] instance for storing [Preferences].
     * This property is expected to be initialized by the implementing class.
     */
    val dataStore: DataStore<Preferences>

    companion object {
        /**
         * The name of the preferences file used to store the onboarding completion status.
         */
        const val STORAGE_FILE_NAME = "onboarding_preferences"
    }
}
