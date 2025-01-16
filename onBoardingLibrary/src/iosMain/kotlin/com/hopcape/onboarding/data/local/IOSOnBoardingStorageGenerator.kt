package com.hopcape.onboarding.data.local

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import kotlinx.cinterop.ExperimentalForeignApi
import okio.Path.Companion.toPath
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSURL
import platform.Foundation.NSUserDomainMask

/**
 * iOS implementation of [OnBoardingStorageGenerator] for managing the onboarding storage.
 *
 * This class is responsible for providing a [DataStore] instance for onboarding-related
 * preferences on iOS. It uses the iOS file system to determine a suitable location to store
 * the preferences data.
 *
 * @author Murtaza Khursheed
 */
internal class IOSDatastoreGenerator : OnBoardingStorageGenerator {

    /**
     * Creates the file path for storing onboarding preferences on iOS.
     *
     * This function accesses the iOS file system to determine the appropriate directory for
     * storing preferences data. It combines the document directory path with the name of the
     * storage file (from [OnBoardingStorageGenerator.STORAGE_FILE_NAME]) to produce the final path.
     *
     * @return The full path where the onboarding preferences will be stored.
     */
    @OptIn(ExperimentalForeignApi::class)
    private fun createProducePath(): String {
        // Retrieve the document directory for the iOS app
        val documentDirectory: NSURL? = NSFileManager.defaultManager.URLForDirectory(
            directory = NSDocumentDirectory,
            inDomain = NSUserDomainMask,
            appropriateForURL = null,
            create = false,
            error = null
        )

        // Generate and return the file path for the storage file
        val producePath = requireNotNull(documentDirectory).path + "/${OnBoardingStorageGenerator.STORAGE_FILE_NAME}"
        return producePath
    }

    /**
     * Provides the [DataStore] instance for storing onboarding-related preferences on iOS.
     *
     * This property initializes a [DataStore] instance using the generated file path
     * for iOS-specific preferences storage.
     *
     * @return A [DataStore] instance for managing the onboarding preferences.
     */
    override val dataStore: DataStore<Preferences>
        get() = object : OnBoardingStorageGenerator {
            override val dataStore: DataStore<Preferences>
                get() = PreferenceDataStoreFactory.createWithPath(
                    produceFile = { createProducePath().toPath() }
                )
        }.dataStore
}
