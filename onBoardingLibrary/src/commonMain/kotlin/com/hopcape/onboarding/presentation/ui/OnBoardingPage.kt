package com.hopcape.onboarding.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraintsScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hopcape.api.page.OnBoardingPage
import io.kamel.core.Resource
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource

@Composable
fun OnBoardingPage(
    modifier: Modifier = Modifier,
    page: OnBoardingPage
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
//        val context = LocalPlatformContext.current
//        val imageLoader = ImageLoader.Builder(context)
////            .components {
////                add(SvgDecoder.Factory())
////            }
//            .build()
//
//        AsyncImage(
//            model = ImageRequest.Builder(context)
//                .data(page.illustrationUri)
//                .build(),
//            imageLoader = imageLoader,
//            contentDescription = "SVG from Assets"
//        )
        val getPainterResource: @Composable (BoxWithConstraintsScope.() -> Resource<Painter>) = {
            asyncPainterResource(
                page.illustrationUri,
                filterQuality = FilterQuality.High,
            )
        }
        KamelImage(
            modifier = Modifier
                .size(200.dp),
            resource = getPainterResource,
            contentDescription = ""
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
            modifier = Modifier
                .padding(vertical = 8.dp),
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