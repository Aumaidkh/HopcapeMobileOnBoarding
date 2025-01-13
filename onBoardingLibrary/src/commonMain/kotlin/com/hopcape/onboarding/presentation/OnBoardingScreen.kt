package com.hopcape.onboarding.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.hopcape.api.OnBoardingPage
import com.hopcape.onboarding.presentation.ui.OnBoardingBottomBar
import com.hopcape.onboarding.presentation.ui.OnBoardingPage
import com.hopcape.onboarding.presentation.viewmodel.OnBoardingAction

@Composable
fun OnBoardingScreen(
    modifier: Modifier = Modifier,
    pages: List<OnBoardingPage> = emptyList(),
    onAction: (OnBoardingAction) -> Unit,
    currentPage: Int = 0
) {
    val pagerState = rememberPagerState(initialPage = currentPage) { pages.size }
    LaunchedEffect(currentPage) {
        if (pagerState.currentPage != currentPage) {
            pagerState.animateScrollToPage(currentPage)
        }
    }

    LaunchedEffect(pagerState.currentPage) {
        if (pagerState.currentPage != currentPage) {
            onAction(OnBoardingAction.SelectPage(pagerState.currentPage))
        }
    }

    Column(
        modifier = modifier,
    ) {
        HorizontalPager(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            state = pagerState
        ) { page ->
            OnBoardingPage(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                page = pages[currentPage]
            )
        }
        OnBoardingBottomBar(
            modifier = Modifier
                .fillMaxWidth(),
            totalPages = pages.size,
            currentPage = currentPage,
            onNextClick = {
                onAction(OnBoardingAction.Next)
            },
            onPreviousClick = {
                onAction(OnBoardingAction.Previous)
            }
        )
    }
}