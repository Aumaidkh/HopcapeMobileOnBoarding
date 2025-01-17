package com.hopcape.api.launcher

/**
 * Interface for launching the onboarding flow.
 *
 * This interface is designed to be implemented by components that are responsible for initiating
 * the onboarding flow in the application. It contains a single function `launchOnBoarding()`, which
 * should be invoked to start the onboarding process.
 *
 * @see launchOnBoarding
 *
 * Example usage:
 * ```
 * class OnBoardingActivity : AppCompatActivity(), OnBoardingLauncher {
 *     override fun launchOnBoarding() {
 *         // Code to launch the onboarding flow
 *     }
 * }
 * ```
 *
 * @author Murtaza Khursheed
 */
internal fun interface OnBoardingLauncher {
    /**
     * Launches the onboarding flow.
     *
     * This function should contain the logic to initiate the onboarding experience for the user.
     * The implementation can vary based on the app's structure and requirements.
     */
    fun launchOnBoarding()
}
