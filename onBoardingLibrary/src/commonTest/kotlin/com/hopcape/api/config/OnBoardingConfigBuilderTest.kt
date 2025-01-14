package com.hopcape.api.config

import com.hopcape.api.page.OnBoardingPage
import com.hopcape.api.theme.DefaultLightTheme
import com.hopcape.api.theme.OnBoardingTheme
import com.hopcape.api.theme.OnBoardingThemeBuilder
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
        val mockPage = fakeOnBoardingPage()

        // Act
        val config = onBoardingConfigBuilder.addPages(mockPage).build()

        // Assert
        assertEquals(1, config.onBoardingPages.size)
        assertEquals(mockPage, config.onBoardingPages[0])
    }

    @Test
    fun `addPages should add multiple onboarding pages to the config`() {
        // Arrange
        val mockPage1 = fakeOnBoardingPage()
        val mockPage2 =  fakeOnBoardingPage()

        // Act
        val config = onBoardingConfigBuilder
            .addPages(mockPage1)
            .addPages(mockPage2)
            .build()

        // Assert
        assertEquals(2, config.onBoardingPages.size)
        assertEquals(mockPage1, config.onBoardingPages[0])
        assertEquals(mockPage2, config.onBoardingPages[1])
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

}