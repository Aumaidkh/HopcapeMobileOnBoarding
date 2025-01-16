package com.hopcape.data.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.hopcape.onboarding.data.local.OnBoardingStorageGenerator

/**
 * Extension property that provides access to the [DataStore] instance for [Preferences]
 * associated with the onboarding storage file.
 *
 * This property uses the [preferencesDataStore] delegate to create a DataStore instance
 * that can be used to store onboarding-related preferences.
 *
 * @author Murtaza Khursheed
 */
private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = OnBoardingStorageGenerator.STORAGE_FILE_NAME)

/**
 * A concrete implementation of [OnBoardingStorageGenerator] for Android.
 *
 * This class is responsible for providing a [DataStore] instance that is backed by the Android
 * [Context] for storing and retrieving the onboarding preferences.
 *
 * @param context The [Context] used to access the DataStore instance.
 *
 * @author Murtaza Khursheed
 */
internal class AndroidOnBoardingStorageGenerator(
    private val context: Context
) : OnBoardingStorageGenerator {

    /**
     * Provides the [DataStore] instance for storing [Preferences] related to onboarding.
     *
     * This property is expected to be used to persist onboarding-related data and retrieve it
     * when needed. It utilizes the `context.dataStore` extension to access the appropriate
     * [DataStore] instance for preferences storage.
     */
    override val dataStore: DataStore<Preferences>
        get() = object : OnBoardingStorageGenerator {
            override val dataStore: DataStore<Preferences>
                get() = context.dataStore
        }.dataStore
}
