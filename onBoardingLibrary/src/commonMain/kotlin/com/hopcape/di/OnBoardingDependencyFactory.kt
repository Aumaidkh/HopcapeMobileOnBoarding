package com.hopcape.di

import com.hopcape.onboarding.data.local.OnBoardingPreferences
import com.hopcape.onboarding.data.local.OnBoardingStorageGenerator

/**
 * Factory interface for creating dependencies related to onboarding data storage.
 *
 * This interface defines methods for creating instances of [OnBoardingPreferences] and
 * [OnBoardingStorageGenerator], which handle the storage and retrieval of onboarding-related
 * preferences and data.
 *
 * Implementations of this interface should provide concrete instances of these dependencies
 * based on the platform-specific storage mechanisms.
 *
 * @author Murtaza Khursheed
 */
interface OnBoardingDependencyFactory {

    /**
     * Creates an instance of [OnBoardingPreferences] to manage onboarding completion preferences.
     *
     * @return An instance of [OnBoardingPreferences].
     */
    fun createOnBoardingPreferences(): OnBoardingPreferences

    /**
     * Creates an instance of [OnBoardingStorageGenerator] to manage onboarding data storage.
     *
     * @return An instance of [OnBoardingStorageGenerator].
     */
    fun createOnBoardingDatastoreGenerator(): OnBoardingStorageGenerator

}
