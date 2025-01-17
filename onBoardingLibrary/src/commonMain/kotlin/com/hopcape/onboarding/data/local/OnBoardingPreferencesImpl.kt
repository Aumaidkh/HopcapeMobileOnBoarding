package com.hopcape.onboarding.data.local

import androidx.datastore.core.DataStore
import com.hopcape.onboarding.data.local.datasource.BooleanKeyValueStorage

/**
 * Implementation of [OnBoardingPreferences] that interacts with [DataStore] to
 * store and retrieve the onboarding completion status.
 *
 * This class provides functionality to check if the onboarding process has been completed and to
 * update the completion status. It uses [DataStore] for persistent storage of the onboarding completion state.
 *
 * The completion status is stored under a specific key, and methods are provided to read and write this value.
 *
 * ## Usage
 * This class should be used to track the completion status of the onboarding process in the application.
 * It provides methods to check if the onboarding has been completed and to set the completion status.
 *
 * ### Example:
 * ```kotlin
 * val onBoardingPreferences: OnBoardingPreferences = OnBoardingPreferencesImpl(storage)
 * val isCompleted = onBoardingPreferences.isOnBoardingCompleted()
 * onBoardingPreferences.setOnBoardingCompleted(true)
 * ```
 *
 * @property storage The [BooleanKeyValueStorage] used for storing and retrieving the onboarding completion status.
 *
 * @see OnBoardingPreferences
 * @see BooleanKeyValueStorage
 * @author Murtaza Khursheed
 */
internal class OnBoardingPreferencesImpl(
    private val storage: BooleanKeyValueStorage
) : OnBoardingPreferences {

    /**
     * Checks whether the onboarding process has been completed.
     *
     * This method checks the stored value for the onboarding completion status
     * and returns a boolean indicating whether the onboarding process is marked as completed.
     *
     * @return A boolean indicating the onboarding completion status.
     *         Returns `true` if the onboarding process has been completed, `false` otherwise.
     */
    override fun isOnBoardingCompleted(): Boolean {
        return storage.get(ONBOARDING_COMPLETED_KEY)
    }

    /**
     * Sets the onboarding completion status.
     *
     * This method updates the onboarding completion status to the specified value.
     * If `true`, the onboarding is marked as completed; if `false`, it is marked as incomplete.
     *
     * @param completed A boolean indicating whether the onboarding process is complete.
     *                  `true` marks the onboarding as completed, `false` marks it as incomplete.
     */
    override suspend fun setOnBoardingCompleted(completed: Boolean) {
        storage.set(ONBOARDING_COMPLETED_KEY, completed)
    }

    companion object {
        // The key used to store the onboarding completion status in the [DataStore].
        private const val ONBOARDING_COMPLETED_KEY = "onboardingCompleted"
    }
}
