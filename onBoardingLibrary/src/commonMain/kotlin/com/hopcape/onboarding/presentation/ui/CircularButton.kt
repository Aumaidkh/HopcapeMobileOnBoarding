package com.hopcape.onboarding.presentation.ui

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

/**
 * A customizable circular button with an icon.
 *
 * This composable creates a circular button with a border, background color, and an icon.
 * It supports customization for click actions, colors, and enable/disable states.
 *
 * @param modifier Modifier to apply to the button.
 * @param onClick Callback triggered when the button is clicked.
 * @param enabled Determines whether the button is enabled or disabled.
 * @param borderColor The color of the button's border.
 * @param backgroundColor The color of the button's background.
 * @param iconTint The color used to tint the icon.
 * @param icon The drawable resource representing the icon inside the button.
 */
@Composable
internal fun CircularButton(
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
    ) {
        IconButton(
            modifier = Modifier,
            onClick = onClick,
            enabled = enabled
        ) {
            Icon(
                painter = painterResource(icon),
                contentDescription = null,
                tint = iconTint
            )
        }
    }
}
