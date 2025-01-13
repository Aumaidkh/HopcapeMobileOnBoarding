package com.hopcape.api

import android.app.Activity
import android.content.Intent
import com.hopcape.presentation.OnBoardingHostActivity

actual typealias OnBoardingContext = Activity

actual fun OnBoardingContext.launchOnBoarding() {
    Intent(this, OnBoardingHostActivity::class.java).also {
        startActivity(it)
        finish()
    }
}