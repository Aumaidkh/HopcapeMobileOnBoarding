package com.hopcape.api.kit

import com.hopcape.api.config.OnBoardingConfig
import com.hopcape.api.config.OnBoardingConfigBuilder
import com.hopcape.api.launcher.OnBoardingLauncher
import com.hopcape.di.FakeOnBoardingDependencyFactory
import dev.mokkery.answering.returns
import dev.mokkery.answering.throws
import dev.mokkery.every
import dev.mokkery.mock
import dev.mokkery.verify
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertFailsWith
import kotlin.test.assertNotNull

class OnBoardingKitImplTest {

    private lateinit var onBoardingKit: OnBoardingKitImpl
    private lateinit var mockLauncher: OnBoardingLauncher

    @BeforeTest
    fun setUp() {
        mockLauncher = mock<OnBoardingLauncher>()
        onBoardingKit = OnBoardingKitImpl(FakeOnBoardingDependencyFactory())
    }

    @Test
    fun `test configure sets the configuration correctly`() {
        // Arrange
        val configBuilder: OnBoardingConfigBuilder.() -> OnBoardingConfig = {
            OnBoardingConfig(onBoardingPages = emptyList(), theme = mock())
        }

        // Act
        onBoardingKit.configure(mockLauncher, configBuilder)

        // Assert
        assertNotNull(OnBoardingKit.configuration)
    }

    @Test
    fun `test start triggers onboarding if not onboarded`() {
        // Arrange
        val onComplete: () -> Unit = mock()
        val configBuilder: OnBoardingConfigBuilder.() -> OnBoardingConfig = {
            OnBoardingConfig(onBoardingPages = emptyList(), theme = mock())
        }
        onBoardingKit.configure(mockLauncher, configBuilder)
        every { mockLauncher.launchOnBoarding() } returns Unit

        // Act
        onBoardingKit.start(onComplete)

        // Assert
        verify { mockLauncher.launchOnBoarding() }
    }

    @Test
    fun `test start invokes onComplete if user is already onboarded`() {
        // Arrange
        val onComplete: () -> Unit = mock()
        val configBuilder: OnBoardingConfigBuilder.() -> OnBoardingConfig = {
            OnBoardingConfig(onBoardingPages = emptyList(), theme = mock())
        }
        // Simulate the user already being onboarded
        every { mockLauncher.launchOnBoarding() } returns Unit
        onBoardingKit.configure(mockLauncher, configBuilder)

        // Act
        onBoardingKit.start(onComplete)

        // Assert
        verify { mockLauncher.launchOnBoarding() }
    }

    @Test
    fun `test start throws exception if config is not set`() {
        // Arrange
        val onComplete: () -> Unit = mock()

        // Act & Assert
        assertFailsWith<IllegalStateException> {
            onBoardingKit.start(onComplete)
        }
    }

    @Test
    fun `test start throws exception if launcher is not set`() {
        // Arrange
        val onComplete: () -> Unit = mock()
        val configBuilder: OnBoardingConfigBuilder.() -> OnBoardingConfig = {
            OnBoardingConfig(onBoardingPages = emptyList(), theme = mock())
        }
        onBoardingKit.configure(mockLauncher, configBuilder)

        // Simulate the launcher being null or uninitialized
        every { mockLauncher.launchOnBoarding() } throws IllegalStateException()

        // Act & Assert
        assertFailsWith<IllegalStateException> {
            onBoardingKit.start(onComplete)
        }
    }
}
