package com.hopcape.di

import com.hopcape.onboarding.data.local.OnBoardingPreferences
import com.hopcape.onboarding.data.local.OnBoardingStorageGenerator
import com.hopcape.onboarding.presentation.viewmodel.FakeOnBoardingPreferences
import com.hopcape.onboarding.presentation.viewmodel.FakeOnBoardingStorageGenerator

/**
 * A fake implementation of [OnBoardingDependencyFactory] for testing purposes.
 * This class provides mock implementations of onboarding-related dependencies.
 *
 * @author Murtaza Khursheed
 */
internal class FakeOnBoardingDependencyFactory : OnBoardingDependencyFactory {

    /**
     * Creates a fake instance of [OnBoardingPreferences] to manage onboarding completion preferences.
     * This is used for testing purposes to avoid dependencies on real storage mechanisms.
     *
     * @return A fake implementation of [OnBoardingPreferences].
     */
    override fun createOnBoardingPreferences(): OnBoardingPreferences {
        return FakeOnBoardingPreferences()
    }

    /**
     * Creates a fake instance of [OnBoardingStorageGenerator] to manage onboarding data storage.
     * This is used for testing scenarios where real data persistence is not required.
     *
     * @return A fake implementation of [OnBoardingStorageGenerator].
     */
    override fun createOnBoardingDatastoreGenerator(): OnBoardingStorageGenerator {
        return FakeOnBoardingStorageGenerator()
    }
}
