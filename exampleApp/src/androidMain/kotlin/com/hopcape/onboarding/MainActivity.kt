package com.hopcape.onboarding

import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.hopcape.api.kit.OnBoardingKit
import com.hopcape.api.launcher.AndroidOnBoardingLauncher
import com.hopcape.api.page.OnBoardingPage

private const val TAG = "MainActivity"
class MainActivity : ComponentActivity() {

    private val onBoardingKit = OnBoardingKit.create()
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
            onBoardingKit.configure{
                val onBoardingPages = listOf(
                    OnBoardingPage(
                        title = "Find and Book Doctors with Ease",
                        body = "Search for specialists near you, view their profiles, and book appointments in just a few taps. No waiting, no hassle.",
                        illustrationImage = R.drawable.undraw_love,
                        textColor = 0L,
                        bodyColor = 0L
                    ),
                    OnBoardingPage(
                        title = "Order Medicines, Anytime",
                        body = "Shop for prescriptions and over-the-counter medicines from trusted pharmacies, and get them delivered to your doorstep.",
                        illustrationImage = R.drawable.undraw_love,
                        textColor = 0L,
                        bodyColor = 0L
                    ),
                    OnBoardingPage(
                        title = "We're Here for You",
                        body = "Need help? Our support team is available around the clock to assist you with your healthcare needs.",
                        illustrationImage = R.drawable.undraw_love,
                        textColor = 0L,
                        bodyColor = 0L
                    )
                )
                addPages(onBoardingPages)
                addOnBoardingLauncher(AndroidOnBoardingLauncher(this@MainActivity))
                addTheme {
                    setPrimaryColor(Color(0XFF2893e1))
                    setSecondaryColor(Color(0XFFBEE2fD))
                    build()
                }
                build()
            }
            onBoardingKit.start(
                onComplete = {

                }
            )
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}