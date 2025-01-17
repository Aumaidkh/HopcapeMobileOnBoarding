package com.hopcape.api.config

import com.hopcape.api.launcher.OnBoardingLauncher
import com.hopcape.api.page.OnBoardingPage
import com.hopcape.api.theme.DefaultLightTheme
import com.hopcape.api.theme.OnBoardingTheme
import com.hopcape.api.theme.OnBoardingThemeBuilder
import com.hopcape.onboarding.data.local.datasource.BooleanKeyValueStorage
import dev.mokkery.mock
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class OnBoardingConfigBuilderTest {

    private lateinit var onBoardingConfigBuilder: OnBoardingConfigBuilder


    @BeforeTest
    fun before(){
        onBoardingConfigBuilder = OnBoardingConfigBuilder()
    }


    @Test
    fun `addPages should add an onboarding page to the config`() {
        // Arrange
        val fakePages = fakeOnBoardingPages()

        // Act
        val config = onBoardingConfigBuilder.addPages(fakePages).build()

        // Assert
        assertEquals(fakePages.size, config.onBoardingPages.size)
        repeat(fakePages.size){
            assertEquals(fakePages[it], config.onBoardingPages[it])
        }
    }

    @Test
    fun `addPages should add multiple onboarding pages to the config`() {
        // Arrange
        val fakePages = fakeOnBoardingPages()

        // Act
        val config = onBoardingConfigBuilder
            .addPages(fakePages)
            .build()

        // Assert
        assertEquals(fakePages.size, config.onBoardingPages.size)
        repeat(fakePages.size){
            assertEquals(fakePages[it], config.onBoardingPages[it])

        }
    }

    @Test
    fun `addOnBoardingLauncher should set the launcher in the config`() {
        // Arrange
        val mockLauncher = mock<OnBoardingLauncher>()

        // Act
        val config = onBoardingConfigBuilder
            .addOnBoardingLauncher(mockLauncher)
            .build()

        // Assert
        assertEquals(mockLauncher, config.onBoardingLauncher)
    }

    @Test
    fun `addKeyValueStorage should set the storage mechanism in the config`() {
        // Arrange
        val mockStorage = mock<BooleanKeyValueStorage>()

        // Act
        val config = onBoardingConfigBuilder
            .addKeyValueStorage(mockStorage)
            .build()

        // Assert
        assertEquals(mockStorage, config.keyValueStorage)
    }

    @Test
    fun `addTheme should set a custom theme in the config`() {
        // Arrange
        val mockTheme =  mock<OnBoardingTheme>()
        val themeBuilder: OnBoardingThemeBuilder.() -> OnBoardingTheme = { mockTheme }

        // Act
        val config = onBoardingConfigBuilder.addTheme(themeBuilder).build()

        // Assert
        assertEquals(mockTheme, config.theme)
    }

    @Test
    fun `build should return a valid OnBoardingConfig instance`() {
        // Act
        val config = onBoardingConfigBuilder.build()

        // Assert
        assertEquals(0, config.onBoardingPages.size) // Initially empty
        assertEquals(DefaultLightTheme(), config.theme) // Default theme
    }

    private fun fakeOnBoardingPage() = OnBoardingPage(
        title = "Title ${(0..10).random()}",
        textColor = 100L,
        body = "Body ${(0..10).random()}",
        bodyColor = 100L,
        illustrationImage = "file://assets/image.jpg"
    )

    private fun fakeOnBoardingPages() = listOf(
        fakeOnBoardingPage(),
        fakeOnBoardingPage(),
        fakeOnBoardingPage()
    )

}