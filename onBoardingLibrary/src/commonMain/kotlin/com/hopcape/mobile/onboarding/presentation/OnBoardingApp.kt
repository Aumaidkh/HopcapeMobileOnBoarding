package com.hopcape.mobile.onboarding.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.hopcape.mobile.onboarding.presentation.viewmodel.OnBoardingViewModel

@Composable
fun OnBoardingApp( modifier: Modifier = Modifier ) {
    val onBoardingViewModel = viewModel { OnBoardingViewModel() }
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