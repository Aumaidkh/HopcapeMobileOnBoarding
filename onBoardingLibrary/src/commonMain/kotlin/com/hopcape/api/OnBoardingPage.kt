package com.hopcape.api

import androidx.compose.ui.graphics.Color
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource

abstract class OnBoardingPage(
    val title: StringResource,
    val textColor: Color,
    val body: StringResource,
    val bodyColor: Color,
    val illustration: DrawableResource
)