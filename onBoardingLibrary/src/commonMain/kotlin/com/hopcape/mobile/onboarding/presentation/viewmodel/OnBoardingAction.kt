package com.hopcape.mobile.onboarding.presentation.viewmodel

/**
 * A wrapper around all the actions user can be able to perform with the
 * [OnBoardingViewModel]
 * */
sealed interface OnBoardingAction {

    /**
     * Caller wants to go to the next page in the
     * Onboarding pages
     * */
    data object Next: OnBoardingAction

    /**
     * Caller wants to go to the previous page in the
     * Onboarding pages
     * */
    data object Previous: OnBoardingAction

    /**
     * Caller wants to select some specific page from the
     * Onboarding pages.
     * @property page Index of the page user wants to go to
     * */
    data class SelectPage(val page: Int): OnBoardingAction
}