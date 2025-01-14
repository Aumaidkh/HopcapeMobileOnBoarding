package com.hopcape.mobile.api.page

/**
 * Represents a single page in the onboarding flow.
 *
 * An [OnBoardingPage] defines the content displayed to the user during an onboarding session.
 * It includes details such as the page title, text and body content, colors for the text and body,
 * and an illustration associated with the page.
 *
 * This class is used to structure the information for each page in the onboarding process,
 * allowing customization of visual elements such as color and illustration.
 *
 * @property title The title displayed at the top of the page.
 * @property textColor The color of the text on the page, represented as a `Long` value (usually ARGB format).
 * @property body The body text displayed in the main section of the page.
 * @property bodyColor The color of the body text, represented as a `Long` value (usually ARGB format).
 * @property illustrationImage The URI (Uniform Resource Identifier) of the illustration associated with the page.
 *
 * @author Murtaza Khursheed
 */
data class OnBoardingPage(
    val title: String,
    val textColor: Long,
    val body: String,
    val bodyColor: Long,
    val illustrationImage: Any,
)
