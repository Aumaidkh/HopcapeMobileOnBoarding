package com.hopcape.onboarding.data.local

/**
 * Interface that defines the contract for managing the onboarding completion state.
 *
 * This interface provides methods to check whether the onboarding process has been completed
 * and to update its completion status. It abstracts the underlying platform-specific
 * implementation for saving and retrieving the onboarding completion state.
 *
 * Implementations of this interface will handle the storage mechanism, such as [SharedPreferences]
 * on Android or [UserDefaults] on iOS, to persist the state of the onboarding flow.
 *
 * @property isOnBoardingCompleted A Boolean indicating whether the onboarding process has been completed.
 * @property setOnBoardingCompleted A method that sets the onboarding completion status to the specified [completed] value.
 */
interface OnBoardingPreferences {

    /**
     * Checks whether the onboarding process has been completed.
     *
     * @return Boolean value indicating the onboarding completion status.
     *         Returns `true` if the onboarding process has been completed, `false` otherwise.
     */
    fun isOnBoardingCompleted(): Boolean

    /**
     * Sets the onboarding completion status.
     *
     * @param completed A Boolean indicating whether the onboarding process is complete.
     *                 If `true`, it marks the onboarding as completed; if `false`, it marks it as incomplete.
     */
    suspend fun setOnBoardingCompleted(completed: Boolean)

}
