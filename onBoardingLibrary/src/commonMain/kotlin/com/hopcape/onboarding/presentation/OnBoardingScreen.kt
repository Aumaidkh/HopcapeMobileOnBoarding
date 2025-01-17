package com.hopcape.onboarding.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.hopcape.api.page.OnBoardingPage
import com.hopcape.onboarding.presentation.ui.OnBoardingBottomBar
import com.hopcape.onboarding.presentation.ui.OnBoardingPage
import com.hopcape.onboarding.presentation.viewmodel.OnBoardingAction

/**
 * Composable function that displays the onboarding screen with a paginated UI.
 *
 * This screen consists of a horizontally scrollable pager displaying onboarding pages and
 * a bottom navigation bar to navigate between them.
 *
 * @param modifier Modifier to apply layout adjustments.
 * @param pages List of [OnBoardingPage] items to be displayed.
 * @param onAction Callback to handle user interactions such as page selection and navigation.
 * @param currentPage Index of the currently selected page.
 */
@Composable
internal fun OnBoardingScreen(
    modifier: Modifier = Modifier,
    pages: List<OnBoardingPage> = emptyList(),
    onAction: (OnBoardingAction) -> Unit,
    currentPage: Int = 0
) {
    val pagerState = rememberPagerState(initialPage = currentPage) { pages.size }

    // Ensure the pager state is updated when the currentPage changes
    LaunchedEffect(currentPage) {
        if (pagerState.currentPage != currentPage) {
            pagerState.animateScrollToPage(currentPage)
        }
    }

    // Notify ViewModel when the page is changed via swipe
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
