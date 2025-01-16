package com.hopcape.di

import com.hopcape.onboarding.data.local.IOSDatastoreGenerator
import com.hopcape.onboarding.data.local.OnBoardingPreferences
import com.hopcape.onboarding.data.local.OnBoardingPreferencesImpl
import com.hopcape.onboarding.data.local.OnBoardingStorageGenerator

/**
 * iOS-specific implementation of [OnBoardingDependencyFactory] for providing
 * onboarding-related storage dependencies.
 *
 * This factory class is responsible for creating instances of [OnBoardingPreferences]
 * and [OnBoardingStorageGenerator] using platform-specific storage mechanisms available
 * on iOS.
 *
 * @author Murtaza Khursheed
 */
class IOSOnBoardingDependencyFactory : OnBoardingDependencyFactory {

    /**
     * Creates an instance of [OnBoardingPreferences] to manage onboarding completion preferences.
     *
     * This implementation uses [OnBoardingPreferencesImpl] backed by DataStore for persistence.
     *
     * @return An instance of [OnBoardingPreferences] for managing onboarding preferences.
     */
    override fun createOnBoardingPreferences(): OnBoardingPreferences {
        return OnBoardingPreferencesImpl(createOnBoardingDatastoreGenerator())
    }

    /**
     * Creates an instance of [OnBoardingStorageGenerator] to manage onboarding data storage.
     *
     * This implementation returns an [IOSDatastoreGenerator] that provides access
     * to the DataStore for storing onboarding-related preferences.
     *
     * @return An instance of [OnBoardingStorageGenerator] for handling data storage.
     */
    override fun createOnBoardingDatastoreGenerator(): OnBoardingStorageGenerator {
        return IOSDatastoreGenerator()
    }
}
