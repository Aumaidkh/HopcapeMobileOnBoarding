package com.hopcape.onboarding.presentation.viewmodel

import app.cash.turbine.test
import com.hopcape.api.config.OnBoardingConfig
import com.hopcape.api.kit.OnBoardingKit
import com.hopcape.api.page.OnBoardingPage
import com.hopcape.api.theme.DefaultLightTheme
import com.hopcape.di.OnBoardingModule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

@ExperimentalCoroutinesApi
class OnBoardingViewModelTest {

    private lateinit var viewModel: OnBoardingViewModel

    @BeforeTest
    fun setUp() {
        // Initializing the ViewModel with a test dispatcher
        viewModel = OnBoardingViewModel(FakeOnBoardingPreferences())
        val pages = List(5) { index -> OnBoardingPage("Page $index", 0, "Body $index", 0, "") }
        OnBoardingKit.configuration = OnBoardingConfig(
            onBoardingPages = pages,
            theme = DefaultLightTheme()
        )
    }

    @Test
    fun `test initial state is empty`() {
        // Verifying initial state of the onboarding screen
        assertEquals(OnBoardingScreenState(), viewModel.state.value)
    }

    @Test
    fun `test state updates when next page action is called`() = runTest {
        // Setup onboarding pages
        viewModel.onAction(OnBoardingAction.SelectPage(1))
        viewModel.onAction(OnBoardingAction.Next) // Start at the first page

        // Emit pages to the state
        viewModel.state.test {
            awaitItem()
            val emission = awaitItem()
            // Verifying that the pageNumber is updated to 1 after the "Next" action
            assertEquals(1, emission.pageNumber)
        }

    }

//    @Test
//    fun `test state does not update beyond last page`() = runTest {
//        // Setup onboarding pages and initial page
//        viewModel.onAction(OnBoardingAction.SelectPage(5)) // Start at the last page
//
//        // Perform action: next page
//        viewModel.onAction(OnBoardingAction.Next)
//
//        // Assert
//        viewModel.state.test {
//            awaitItem()
//            val emission = awaitItem()
//            // Verifying that page number is still 4 since it's the last page
//            assertEquals(5, emission.pageNumber)
//        }
//
//    }

    @Test
    fun `test state updates when previous page action is called`() = runTest {
        // Setup onboarding pages and initial page
        viewModel.onAction(OnBoardingAction.SelectPage(3)) // Start at page 3

        // Perform action: previous page
        viewModel.onAction(OnBoardingAction.Previous)

        // Verifying that the page number is updated to 2 after the "Previous" action
        viewModel.state.test {
            awaitItem()
            val emission = awaitItem()
            assertEquals(2, emission.pageNumber)
        }
    }

//    @Test
//    fun `test state does not update before first page`() = runTest {
//        // Setup onboarding pages and initial page
//        viewModel.onAction(OnBoardingAction.SelectPage(0)) // Start at the first page
//
//        // Perform action: previous page
//        viewModel.onAction(OnBoardingAction.Previous)
//
//        // Verifying that page number is still 0 since it's the first page
//        viewModel.state.test {
//            awaitItem()
//            assertEquals(0, awaitItem().pageNumber)
//        }
//    }

    @Test
    fun `test state updates correctly when page is selected`() = runTest {
        // Setup onboarding pages and initial page
        viewModel.onAction(OnBoardingAction.SelectPage(2)) // Start at page 2

        // Verifying that the selected page number is updated correctly
        viewModel.state.test {
            awaitItem()
            assertEquals(2, awaitItem().pageNumber)
        }
    }
}
