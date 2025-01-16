package com.hopcape.onboarding.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.hopcape.api.config.background
import com.hopcape.api.config.primaryColor
import com.hopcape.api.kit.OnBoardingKit
import onboarding.onboardinglibrary.generated.resources.Res
import onboarding.onboardinglibrary.generated.resources.arrow_left
import onboarding.onboardinglibrary.generated.resources.arrow_right

@Composable
fun OnBoardingBottomBar(
    modifier: Modifier = Modifier,
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit,
    totalPages: Int,
    currentPage: Int
) {
    Row(
        modifier = modifier
            .padding(24.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        CircularButton(
            modifier = Modifier,
            onClick = onPreviousClick,
            icon = Res.drawable.arrow_left,
            borderColor = Color.Gray,
            backgroundColor = OnBoardingKit.configuration.background(),
            iconTint = Color.Gray
        )
        PageIndicator(
            modifier = Modifier,
            totalDots = totalPages,
            current = currentPage
        )
        CircularButton(
            modifier = Modifier,
            onClick = onNextClick,
            icon = Res.drawable.arrow_right,
            borderColor = OnBoardingKit.configuration.primaryColor(),
            backgroundColor = OnBoardingKit.configuration.primaryColor(),
            iconTint = Color.White
        )
    }
}