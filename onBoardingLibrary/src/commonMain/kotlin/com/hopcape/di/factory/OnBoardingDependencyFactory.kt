package com.hopcape.di.factory

import com.hopcape.onboarding.data.local.OnBoardingPreferences
import com.hopcape.onboarding.data.local.datasource.BooleanKeyValueStorage

/**
 * Factory interface for creating dependencies related to onboarding data storage.
 *
 * This interface defines methods for creating instances of [OnBoardingPreferences] and
 * [OnBoardingStorageGenerator], which handle the storage and retrieval of onboarding-related
 * preferences and data. Implementations of this interface should be responsible for providing
 * the appropriate platform-specific storage mechanisms, such as using [DataStore] or other
 * persistence solutions.
 *
 * The factory provides a clean abstraction over dependency creation, ensuring that the
 * onboarding-related data storage logic can be easily tested and replaced with different
 * implementations if needed.
 *
 * ## Usage
 * Implementations of this interface should return concrete instances of the required
 * dependencies based on the desired storage mechanism. The factory should allow for
 * flexibility in managing the persistence of onboarding-related preferences, such as
 * tracking whether the user has completed the onboarding process.
 *
 * @author Murtaza Khursheed
 */
interface OnBoardingDependencyFactory {

    /**
     * Creates an instance of [OnBoardingPreferences] to manage onboarding completion preferences.
     *
     * This method returns an implementation of [OnBoardingPreferences], which is responsible
     * for managing the completion status of the onboarding process.
     *
     * @return An instance of [OnBoardingPreferences].
     */
    fun createOnBoardingPreferences(): OnBoardingPreferences

    /**
     * Creates an instance of [BooleanKeyValueStorage] for storing boolean preferences related
     * to the onboarding process.
     *
     * This method returns an instance of [BooleanKeyValueStorage], which is used to store and
     * retrieve boolean values, such as whether the onboarding process is completed or not.
     *
     * @return An instance of [BooleanKeyValueStorage].
     */
    fun createOnBoardingKeyValueStorage(): BooleanKeyValueStorage
}
