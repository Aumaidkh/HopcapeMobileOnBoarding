package com.hopcape.onboarding.presentation.viewmodel

import com.hopcape.onboarding.data.local.OnBoardingPreferences

/**
 * A fake implementation of [OnBoardingPreferences] for testing purposes.
 * This class simulates the onboarding preferences without requiring actual data persistence.
 *
 * @author Murtaza Khursheed
 */
class FakeOnBoardingPreferences : OnBoardingPreferences {

    /** Stores the onboarding completion status in memory. */
    private var result = false

    /**
     * Checks whether the onboarding process has been completed.
     *
     * @return Boolean value indicating the onboarding completion status.
     *         Returns `true` if the onboarding process has been completed, `false` otherwise.
     */
    override fun isOnBoardingCompleted(): Boolean {
        return result
    }

    /**
     * Sets the onboarding completion status.
     *
     * @param completed A Boolean indicating whether the onboarding process is complete.
     * If `true`, it marks the onboarding as completed; if `false`, it marks it as incomplete.
     */
    override suspend fun setOnBoardingCompleted(completed: Boolean) {
        result = completed
    }
}
