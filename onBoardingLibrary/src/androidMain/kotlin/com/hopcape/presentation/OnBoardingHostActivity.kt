package com.hopcape.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.Modifier
import com.hopcape.onboarding.presentation.OnBoardingApp

/**
 * Activity that serves as the host for the onboarding flow.
 *
 * [OnBoardingHostActivity] is responsible for displaying the onboarding UI using Jetpack Compose.
 * It sets up the Material theme and initializes the [OnBoardingApp] within the activity.
 *
 * ## Key Features:
 * - Uses Jetpack Compose to render the onboarding UI.
 * - Applies a Material Design theme.
 * - Ensures the UI fills the available screen space with the appropriate background.
 *
 * This activity is typically launched when onboarding is required for the user.
 *
 * @author Murtaza Khursheed
 */
class OnBoardingHostActivity : ComponentActivity() {

    /**
     * Called when the activity is first created.
     *
     * This method sets up the onboarding UI using Jetpack Compose. It initializes [OnBoardingApp]
     * with a Material theme and ensures it occupies the full screen.
     *
     * @param savedInstanceState The saved instance state bundle, used to restore the activity state if needed.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                OnBoardingApp(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colors.background)
                )
            }
        }
    }
}
