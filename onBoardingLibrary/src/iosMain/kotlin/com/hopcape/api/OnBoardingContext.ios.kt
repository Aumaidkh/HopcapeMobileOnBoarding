package com.hopcape.api

import com.hopcape.presentation.composeUIViewController
import platform.UIKit.UIWindow

actual typealias OnBoardingContext = UIWindow

/**
 * If it would have returned a view we could have added it to the view controller directly
 * */
actual fun OnBoardingContext.launchOnBoarding() {
    val onboardingHost = composeUIViewController
    this.rootViewController = onboardingHost
}
