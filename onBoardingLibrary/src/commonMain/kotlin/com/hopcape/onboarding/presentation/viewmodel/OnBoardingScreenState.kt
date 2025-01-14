package com.hopcape.onboarding.presentation.viewmodel

import com.hopcape.api.page.OnBoardingPage

data class OnBoardingScreenState(
    val pages: List<OnBoardingPage> = emptyList(),
    val pageNumber: Int = 0,
){
    val totalPages = pages.size
}
