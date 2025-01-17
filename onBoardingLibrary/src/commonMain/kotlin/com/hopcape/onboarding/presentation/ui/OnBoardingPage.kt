package com.hopcape.onboarding.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.ImageLoader
import coil3.compose.AsyncImage
import coil3.compose.LocalPlatformContext
import coil3.request.ImageRequest
import coil3.svg.SvgDecoder
import com.hopcape.api.page.OnBoardingPage

/**
 * Displays an individual onboarding page.
 *
 * This composable presents an onboarding page consisting of an illustration, title, and description text.
 * It ensures a visually appealing layout by centering the content and using appropriate spacing.
 *
 * @param modifier Modifier to apply to the onboarding page layout.
 * @param page The onboarding page data containing the title, body, and illustration image.
 */
@Composable
internal fun OnBoardingPage(
    modifier: Modifier = Modifier,
    page: OnBoardingPage
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val context = LocalPlatformContext.current
        val imageLoader = ImageLoader.Builder(context)
            .build()

        AsyncImage(
            modifier = Modifier.size(200.dp),
            model = ImageRequest.Builder(context)
                .data(page.illustrationImage)
                .decoderFactory(SvgDecoder.Factory())
                .build(),
            imageLoader = imageLoader,
            contentDescription = "SVG from Assets"
        )

        Text(
            modifier = Modifier
                .padding(top = 12.dp)
                .fillMaxWidth(0.8f),
            text = page.title,
            style = TextStyle(
                fontWeight = FontWeight.Medium,
                fontSize = 25.sp
            ),
            textAlign = TextAlign.Center
        )

        Text(
            modifier = Modifier.padding(vertical = 8.dp),
            text = page.body,
            style = TextStyle(
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp
            ),
            textAlign = TextAlign.Center,
            color = Color.Gray
        )
    }
}
