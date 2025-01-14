package com.hopcape.onboarding.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hopcape.api.kit.OnBoardingKit
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

/**
 * ViewModel responsible for managing the state of the onboarding flow in the app.
 *
 * The [OnBoardingViewModel] is responsible for managing and updating the state of the onboarding process. It provides
 * actions for navigating between pages of the onboarding flow, such as moving to the next or previous page, or directly
 * selecting a page. The viewModel observes changes in the onboarding configuration and updates the UI state accordingly.
 *
 * @property state The current state of the onboarding flow, including the list of pages and the current page number.
 */
class OnBoardingViewModel: ViewModel() {

    /**
     * Mutable state flow holding the current state of the onboarding screen.
     * This property is updated by the ViewModel based on user actions and the onboarding configuration.
     */
    private val _state = MutableStateFlow(OnBoardingScreenState())

    /**
     * Immutable state flow exposed to the UI for observing the onboarding screen state.
     * The state is updated whenever there is a change in the onboarding configuration or page number.
     */
    val state get() = _state.onStart {
        OnBoardingKit.configuration?.let { config ->
            _state.update {
                it.copy(
                    pages = config.onBoardingPages.toList()
                )
            }
        }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(4000), OnBoardingScreenState())

    /**
     * Handles actions related to the onboarding flow, such as moving to the next or previous page,
     * or selecting a specific page.
     *
     * @param action The action to be performed in the onboarding flow.
     */
    fun onAction(action: OnBoardingAction){
        when(action){
            OnBoardingAction.Next -> showNextPage()
            OnBoardingAction.Previous -> showPreviousPage()
            is OnBoardingAction.SelectPage -> makePageAsCurrentPage(action.page)
        }
    }

    /**
     * Updates the current page to the selected page number.
     *
     * @param pageNumber The page number to be set as the current page.
     */
    private fun makePageAsCurrentPage(pageNumber: Int) {
        updatePageNumber(
            pageNumber = pageNumber
        )
    }

    /**
     * Navigates to the previous page in the onboarding flow if it's not the first page.
     */
    private fun showPreviousPage() {
        if (isFirstPage()){
            return
        }
        updatePageNumber(
            pageNumber = _state.value.pageNumber - 1
        )
    }

    /**
     * Navigates to the next page in the onboarding flow if it's not the last page.
     */
    private fun showNextPage() {
        if (isLastPage()){
            return
        }
        updatePageNumber(
            pageNumber = _state.value.pageNumber + 1
        )
    }

    /**
     * Checks if the current page is the last page in the onboarding flow.
     *
     * @return `true` if the current page is the last page; otherwise, `false`.
     */
    private fun isLastPage() =
        _state.value.pageNumber == _state.value.pages.size-1

    /**
     * Checks if the current page is the first page in the onboarding flow.
     *
     * @return `true` if the current page is the first page; otherwise, `false`.
     */
    private fun isFirstPage() =
        _state.value.pageNumber == 0

    /**
     * Updates the current page number in the onboarding flow state.
     *
     * @param pageNumber The page number to be set as the current page.
     */
    private fun updatePageNumber(pageNumber: Int){
        _state.update { it.copy(pageNumber = pageNumber) }
    }

}
