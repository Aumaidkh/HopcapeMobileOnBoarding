package com.hopcape.onboarding.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.hopcape.onboarding.data.local.OnBoardingPreferences
import com.hopcape.onboarding.presentation.viewmodel.OnBoardingViewModel
import kotlin.reflect.KClass

internal class OnBoardingViewModelFactory(
    private val onBoardingPreferences: OnBoardingPreferences
): ViewModelProvider.Factory {
    /**
     * Creates a new instance of the given `Class`.
     *
     * @param modelClass a [KClass] whose instance is requested
     * @param extras an additional information for this creation request
     * @return a newly created [ViewModel]
     */
    override fun <T : ViewModel> create(modelClass: KClass<T>, extras: CreationExtras): T {
        return OnBoardingViewModel(onBoardingPreferences) as T
    }

}