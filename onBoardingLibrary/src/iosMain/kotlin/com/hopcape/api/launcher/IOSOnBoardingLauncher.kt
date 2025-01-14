package com.hopcape.api.launcher

import com.hopcape.mobile.api.launcher.OnBoardingLauncher
import com.hopcape.presentation.composeUIViewController
import platform.UIKit.UIWindow

/**
 * iOS implementation of the [OnBoardingLauncher] interface for launching the onboarding flow.
 *
 * This class is responsible for initiating the onboarding experience by setting the root view controller
 * of the provided [UIWindow] to the onboarding UI. The [composeUIViewController] is used to present
 * the onboarding flow on iOS devices.
 *
 * @param window The [UIWindow] used to display the onboarding UI.
 *
 * @see OnBoardingLauncher
 * @see composeUIViewController
 *
 * @author Murtaza Khursheed
 */
class IOSOnBoardingLauncher(
    private val window: UIWindow
): OnBoardingLauncher {

    /**
     * Launches the onboarding flow by setting the root view controller of the window.
     *
     * This function updates the [rootViewController] of the [UIWindow] to present the onboarding flow
     * by using the `composeUIViewController`. This enables the display of the onboarding UI on iOS.
     */
    override fun launchOnBoarding() {
        with(window) {
            val onboardingHost = composeUIViewController
            this.rootViewController = onboardingHost
        }
    }
}
