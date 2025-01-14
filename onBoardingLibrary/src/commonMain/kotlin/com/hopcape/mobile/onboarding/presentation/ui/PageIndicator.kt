package com.hopcape.mobile.onboarding.presentation.ui

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hopcape.mobile.api.kit.OnBoardingKit
import com.hopcape.mobile.api.config.primaryColor
import com.hopcape.mobile.api.config.secondaryColor

/**
 * Page Indicator showing multiple dots
 * @param totalDots Total dots to be shown
 * @param current Current dot which is active
 * */
@Composable
fun PageIndicator(
    modifier: Modifier = Modifier,
    totalDots: Int = 0,
    current: Int = 0
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        repeat(totalDots) {
            val size by animateDpAsState(
                targetValue = if (totalDots == current) 15.dp else 12.dp,
                animationSpec = tween(durationMillis = 300) // Customize duration and easing if needed
            )
            Surface(
                modifier = Modifier
                    .size(size),
                shape = CircleShape,
                color = if (it == current) OnBoardingKit.configuration.primaryColor() else OnBoardingKit.configuration.secondaryColor(),
            ) {

            }
        }
    }
}