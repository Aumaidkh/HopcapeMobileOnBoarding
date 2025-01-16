package com.hopcape.onboarding.presentation.viewmodel

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import com.hopcape.onboarding.data.local.OnBoardingStorageGenerator
import okio.Path.Companion.toPath

/**
 * A fake implementation of [OnBoardingStorageGenerator] for testing purposes.
 * This class provides a temporary in-memory [DataStore] instance for storing preferences
 * without requiring actual file storage.
 *
 * @author Murtaza Khursheed
 */
class FakeOnBoardingStorageGenerator : OnBoardingStorageGenerator {

    /**
     * Provides a fake [DataStore] instance for storing [Preferences].
     * This is used in test environments to simulate persistent storage without affecting real data.
     */
    override val dataStore: DataStore<Preferences>
        get() = object : OnBoardingStorageGenerator {
            override val dataStore: DataStore<Preferences>
                get() = PreferenceDataStoreFactory.createWithPath(
                    produceFile = { "".toPath() } // Creates a temporary datastore path
                )
        }.dataStore
}
