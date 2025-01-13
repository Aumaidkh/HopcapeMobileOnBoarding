package com.hopcape.onboarding

import com.hopcape.api.OnBoardingKit
import com.hopcape.api.OnBoardingKitImpl
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController {
    val onBoardingKit: OnBoardingKit = OnBoardingKitImpl()
    return com.hopcape.presentation.composeUIViewController
}