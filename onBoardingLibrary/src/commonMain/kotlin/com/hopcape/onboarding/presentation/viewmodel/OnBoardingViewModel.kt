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
 * StateHolder for the OnBoardingApp
 * @property state Sate of the app it can be in
 * */
class OnBoardingViewModel: ViewModel() {

    /**
     * Mutable version of the [state] that the [OnBoardingViewModel] will be
     * updating
     * */
    private val _state = MutableStateFlow(OnBoardingScreenState())

    /**
     * Immutable version of the [_state] the viewModel host will be
     * observing to
     * */
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
     * Send [OnBoardingAction] to the [OnBoardingViewModel]
     * @param action Action to be sent
     * */
    fun onAction(action: OnBoardingAction){
        when(action){
            OnBoardingAction.Next -> showNextPage()
            OnBoardingAction.Previous -> showPreviousPage()
            is OnBoardingAction.SelectPage -> makePageAsCurrentPage(action.page)
        }
    }

    private fun makePageAsCurrentPage(pageNumber: Int) {
        updatePageNumber(
            pageNumber = pageNumber
        )
    }

    private fun showPreviousPage() {
        if (isFirstPage()){
            return
        }
        updatePageNumber(
            pageNumber = _state.value.pageNumber - 1
        )
    }

    private fun showNextPage() {
        if (isLastPage()){
            return
        }
        updatePageNumber(
            pageNumber = _state.value.pageNumber + 1
        )
    }

    private fun isLastPage() =
        _state.value.pageNumber == _state.value.pages.size-1

    private fun isFirstPage() =
        _state.value.pageNumber == 0


    private fun updatePageNumber(pageNumber: Int){
        _state.update { it.copy(pageNumber = pageNumber) }
    }

}