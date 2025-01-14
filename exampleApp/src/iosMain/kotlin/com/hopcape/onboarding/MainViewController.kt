package com.hopcape.onboarding

import com.hopcape.mobile.api.kit.OnBoardingKit
import com.hopcape.mobile.api.kit.OnBoardingKitImpl
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController {
    val onBoardingKit: OnBoardingKit = OnBoardingKitImpl()
    return com.hopcape.presentation.composeUIViewController
}