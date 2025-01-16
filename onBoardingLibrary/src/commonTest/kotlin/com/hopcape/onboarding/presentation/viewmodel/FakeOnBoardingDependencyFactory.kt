package com.hopcape.onboarding.presentation.viewmodel

import com.hopcape.di.OnBoardingDependencyFactory
import com.hopcape.onboarding.data.local.OnBoardingPreferences
import com.hopcape.onboarding.data.local.OnBoardingStorageGenerator

class FakeOnBoardingDependencyFactory: OnBoardingDependencyFactory {
    /**
     * Creates an instance of [OnBoardingPreferences] to manage onboarding completion preferences.
     *
     * @return An instance of [OnBoardingPreferences].
     */
    override fun createOnBoardingPreferences(): OnBoardingPreferences {
        return FakeOnBoardingPreferences()
    }

    /**
     * Creates an instance of [OnBoardingStorageGenerator] to manage onboarding data storage.
     *
     * @return An instance of [OnBoardingStorageGenerator].
     */
    override fun createOnBoardingDatastoreGenerator(): OnBoardingStorageGenerator {
        return FakeOnBoardingStorageGenerator()
    }
}