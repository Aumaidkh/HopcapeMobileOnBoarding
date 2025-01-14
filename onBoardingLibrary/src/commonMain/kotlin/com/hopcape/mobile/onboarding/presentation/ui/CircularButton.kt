package com.hopcape.mobile.onboarding.presentation.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun CircularButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    enabled: Boolean = true,
    borderColor: Color = MaterialTheme.colors.onSurface,
    backgroundColor: Color = MaterialTheme.colors.onSurface,
    iconTint: Color = MaterialTheme.colors.onSurface,
    icon: DrawableResource,
) {
    Surface(
        modifier = modifier,
        shape = CircleShape,
        color = backgroundColor,
        border = BorderStroke(
            width = 1.dp,
            color = borderColor
        )
    ){
        IconButton(
            modifier = Modifier,
            onClick = onClick,
            enabled = enabled
        ){
            Icon(
                painter = painterResource(icon)  ,
                contentDescription = "",
                tint = iconTint
            )
        }
    }
}

