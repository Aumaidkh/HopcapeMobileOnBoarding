package com.hopcape.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.ComposeUIViewController
import com.hopcape.onboarding.presentation.OnBoardingApp

val composeUIViewController = ComposeUIViewController(
    configure = {
        enforceStrictPlistSanityCheck = false
    }
) {
    OnBoardingApp(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)

    )
}
