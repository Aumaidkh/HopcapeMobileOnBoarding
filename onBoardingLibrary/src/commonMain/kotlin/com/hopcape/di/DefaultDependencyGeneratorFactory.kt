package com.hopcape.di

import com.hopcape.onboarding.data.local.OnBoardingPreferences
import com.hopcape.onboarding.data.local.OnBoardingPreferencesImpl
import com.hopcape.onboarding.data.local.datasource.BooleanKeyValueStorage
import com.hopcape.onboarding.data.local.datasource.SettingsKeyValueStorage
import com.russhwolf.settings.Settings

/**
 * Default implementation of [OnBoardingDependencyFactory] that generates dependencies
 * for onboarding-related storage and preferences.
 *
 * This class provides concrete implementations of the [OnBoardingPreferences] and
 * [BooleanKeyValueStorage] interfaces, which are responsible for storing and retrieving
 * the completion status of the onboarding process.
 *
 * It uses [Settings] from the `russhwolf/settings` library for the underlying storage
 * mechanism and provides an implementation of [BooleanKeyValueStorage] via
 * [SettingsKeyValueStorage].
 *
 * ## Responsibilities:
 * - Creating an instance of [OnBoardingPreferences] that manages the onboarding
 *   completion status.
 * - Providing an instance of [BooleanKeyValueStorage] to store boolean values,
 *   such as whether the onboarding process is completed or not.
 *
 * This class serves as the default provider of dependencies for onboarding-related
 * preferences, and can be replaced with platform-specific or mock implementations if needed.
 *
 * @see OnBoardingDependencyFactory
 * @see OnBoardingPreferencesImpl
 * @see SettingsKeyValueStorage
 * @see BooleanKeyValueStorage
 */
internal class DefaultDependencyGeneratorFactory: OnBoardingDependencyFactory {

    /**
     * Creates an instance of [OnBoardingPreferences] to manage onboarding completion preferences.
     *
     * This method returns an implementation of [OnBoardingPreferences], which is responsible
     * for managing the completion status of the onboarding process.
     *
     * It uses the [SettingsKeyValueStorage] as the underlying storage for boolean values.
     *
     * @return An instance of [OnBoardingPreferences] that handles the onboarding completion status.
     */
    override fun createOnBoardingPreferences(): OnBoardingPreferences {
        return OnBoardingPreferencesImpl(createOnBoardingKeyValueStorage())
    }

    /**
     * Creates an instance of [BooleanKeyValueStorage] for storing boolean preferences related
     * to the onboarding process.
     *
     * This method returns an instance of [SettingsKeyValueStorage], which utilizes the
     * [Settings] library for storing and retrieving boolean values such as whether the
     * onboarding process is completed or not.
     *
     * @return An instance of [BooleanKeyValueStorage] backed by [Settings].
     */
    override fun createOnBoardingKeyValueStorage(): BooleanKeyValueStorage {
        return SettingsKeyValueStorage(Settings())
    }
}
