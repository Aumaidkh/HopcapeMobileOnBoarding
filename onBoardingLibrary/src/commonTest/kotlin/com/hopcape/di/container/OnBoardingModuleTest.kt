package com.hopcape.di.container

import androidx.lifecycle.ViewModelProvider
import com.hopcape.di.factory.OnBoardingDependencyFactory
import com.hopcape.onboarding.data.local.OnBoardingPreferences
import com.hopcape.onboarding.data.local.datasource.BooleanKeyValueStorage
import com.hopcape.onboarding.presentation.OnBoardingViewModelFactory
import dev.mokkery.answering.returns
import dev.mokkery.every
import dev.mokkery.mock
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class OnBoardingModuleTest {

    private lateinit var onBoardingDependencyFactory: OnBoardingDependencyFactory
    private lateinit var mockOnBoardingPreferences: OnBoardingPreferences
    private lateinit var mockBooleanKeyValueStorage: BooleanKeyValueStorage
    private lateinit var mockOnBoardingViewModelFactory: ViewModelProvider.Factory

    @BeforeTest
    fun setUp() {
        // Mock dependencies
        mockOnBoardingPreferences = mock()
        mockBooleanKeyValueStorage = mock()
        mockOnBoardingViewModelFactory = mock()

        // Mock the dependency factory
        onBoardingDependencyFactory = mock()

        // Mock the factory's methods
        every {
            onBoardingDependencyFactory.createOnBoardingPreferences()
        } returns mockOnBoardingPreferences

        every {
            onBoardingDependencyFactory.createOnBoardingKeyValueStorage()
        } returns mockBooleanKeyValueStorage
    }

    @Test
    fun `test setDependencyFactory initializes dependency graph`() {
        // Initialize OnBoardingModule
        OnBoardingModule.setDependencyFactory(onBoardingDependencyFactory)

        // Verify that the dependency graph is properly initialized with correct dependencies
        assertNotNull(OnBoardingModule.get(OnBoardingPreferences::class))
        assertNotNull(OnBoardingModule.get(BooleanKeyValueStorage::class))
        assertNotNull(OnBoardingModule.get(OnBoardingViewModelFactory::class))
    }

    @Test
    fun `test get retrieves correct dependency`() {
        // Initialize with a factory
        OnBoardingModule.setDependencyFactory(onBoardingDependencyFactory)

        // Test retrieving OnBoardingPreferences
        val preferences = OnBoardingModule.get<OnBoardingPreferences>(OnBoardingPreferences::class)
        assertTrue(preferences is OnBoardingPreferences)
        // Test retrieving BooleanKeyValueStorage
        val storage = OnBoardingModule.get<BooleanKeyValueStorage>(BooleanKeyValueStorage::class)
        assertTrue(storage is BooleanKeyValueStorage)

        // Test retrieving OnBoardingViewModelFactory
        val viewModelFactory = OnBoardingModule.get<OnBoardingViewModelFactory>(OnBoardingViewModelFactory::class)
        assertTrue(viewModelFactory is OnBoardingViewModelFactory)
    }
}
