package com.hopcape.onboarding

import com.hopcape.api.kit.OnBoardingKit
import com.hopcape.api.kit.OnBoardingKitImpl
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController {
    val onBoardingKit: OnBoardingKit = OnBoardingKitImpl()
    return com.hopcape.presentation.composeUIViewController
}