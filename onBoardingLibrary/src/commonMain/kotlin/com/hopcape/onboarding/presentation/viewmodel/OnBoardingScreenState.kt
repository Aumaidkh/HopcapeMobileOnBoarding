package com.hopcape.onboarding.presentation.viewmodel

import com.hopcape.api.page.OnBoardingPage

/**
 * Represents the state of the onboarding screen.
 *
 * This class holds the current state of the onboarding process, including the list of onboarding pages
 * and the current page number. It is used to manage and display the onboarding flow.
 *
 * @property pages A list of [OnBoardingPage] objects representing the pages to be displayed in the onboarding process.
 * @property pageNumber The index of the current page being viewed in the onboarding flow.
 *
 * @author Murtaza Khursheed
 */
data class OnBoardingScreenState(
    val pages: List<OnBoardingPage> = emptyList(),
    val pageNumber: Int = 0,
)
