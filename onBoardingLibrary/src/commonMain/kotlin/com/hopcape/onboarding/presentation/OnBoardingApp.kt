package com.hopcape.onboarding.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.hopcape.di.container.OnBoardingModule
import com.hopcape.onboarding.presentation.viewmodel.OnBoardingViewModel

/**
 * Composable function that initializes and displays the onboarding flow.
 *
 * This function retrieves the [OnBoardingViewModel] from the dependency injection module,
 * observes its state, and renders the [OnBoardingScreen] with the retrieved data.
 *
 * @param modifier Modifier to apply layout adjustments to the onboarding flow.
 */
@Composable
internal fun OnBoardingApp(modifier: Modifier = Modifier) {
    val onBoardingViewModelFactory = OnBoardingModule.get<OnBoardingViewModelFactory>(OnBoardingViewModelFactory::class)
    val onBoardingViewModel: OnBoardingViewModel = viewModel(factory = onBoardingViewModelFactory)
    val state = onBoardingViewModel.state.collectAsStateWithLifecycle()

    MaterialTheme {
        OnBoardingScreen(
            modifier = modifier
                .fillMaxSize()
                .padding(vertical = 32.dp, horizontal = 24.dp),
            pages = state.value.pages,
            onAction = onBoardingViewModel::onAction,
            currentPage = state.value.pageNumber
        )
    }
}
