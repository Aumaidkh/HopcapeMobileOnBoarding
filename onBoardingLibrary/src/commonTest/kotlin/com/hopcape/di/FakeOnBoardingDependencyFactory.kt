package com.hopcape.di

import com.hopcape.di.factory.OnBoardingDependencyFactory
import com.hopcape.onboarding.data.local.OnBoardingPreferences
import com.hopcape.onboarding.data.local.datasource.BooleanKeyValueStorage
import com.hopcape.onboarding.presentation.viewmodel.FakeKeyValueStorage
import com.hopcape.onboarding.presentation.viewmodel.FakeOnBoardingPreferences

internal class FakeOnBoardingDependencyFactory: OnBoardingDependencyFactory {
    /**
     * Creates an instance of [OnBoardingPreferences] to manage onboarding completion preferences.
     *
     * @return An instance of [OnBoardingPreferences].
     */
    override fun createOnBoardingPreferences(): OnBoardingPreferences {
        return FakeOnBoardingPreferences()
    }

    /**
     * Creates an instance of [BooleanKeyValueStorage] for storing boolean preferences related
     * to the onboarding process.
     *
     * This method returns an instance of [BooleanKeyValueStorage], which is used to store and
     * retrieve boolean values, such as whether the onboarding process is completed or not.
     *
     * @return An instance of [BooleanKeyValueStorage].
     */
    override fun createOnBoardingKeyValueStorage(): BooleanKeyValueStorage {
        return FakeKeyValueStorage()
    }
}