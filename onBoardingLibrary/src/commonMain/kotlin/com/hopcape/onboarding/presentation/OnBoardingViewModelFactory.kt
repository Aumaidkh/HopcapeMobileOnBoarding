package com.hopcape.onboarding.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.hopcape.onboarding.data.local.OnBoardingPreferences
import com.hopcape.onboarding.presentation.viewmodel.OnBoardingViewModel
import kotlin.reflect.KClass

/**
 * Factory class for creating instances of [OnBoardingViewModel].
 *
 * This factory is responsible for providing dependencies required by the ViewModel,
 * such as [OnBoardingPreferences].
 *
 * @property onBoardingPreferences Preferences storage for onboarding-related data.
 */
internal class OnBoardingViewModelFactory(
    private val onBoardingPreferences: OnBoardingPreferences
) : ViewModelProvider.Factory {

    /**
     * Creates a new instance of the specified [ViewModel] class.
     *
     * @param modelClass The class of the ViewModel to be created.
     * @param extras Additional information for the creation request.
     * @return A newly created instance of [OnBoardingViewModel].
     * @throws IllegalArgumentException if the requested ViewModel class is not supported.
     */
    override fun <T : ViewModel> create(modelClass: KClass<T>, extras: CreationExtras): T {
        return OnBoardingViewModel(onBoardingPreferences) as? T
            ?: throw IllegalArgumentException("ViewModel can't be created")
    }
}
