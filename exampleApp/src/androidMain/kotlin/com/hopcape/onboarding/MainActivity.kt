package com.hopcape.onboarding

import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.hopcape.api.OnBoardingKit
import com.hopcape.api.OnBoardingKitImpl
import com.hopcape.api.OnBoardingPage

private const val TAG = "MainActivity"
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        val onBoardingKit: OnBoardingKit = OnBoardingKitImpl()
        val context = this

    //    val uri = "android.resource://${context.packageName}/raw/undraw_love.svg"
        val uri = Uri.parse("android.resource://${context.packageName}/drawable/test_image.jpg")

        setContent {
            onBoardingKit.configure(this@MainActivity) {
                addPages(
                    OnBoardingPage(
                        title = "Find and Book Doctors with Ease",
                        body = "Search for specialists near you, view their profiles, and book appointments in just a few taps. No waiting, no hassle.",
                        illustrationUri = uri.toString(),
                        textColor = 0L,
                        bodyColor = 0L
                    )
                )
                addPages(
                    OnBoardingPage(
                        title = "Order Medicines, Anytime",
                        body = "Shop for prescriptions and over-the-counter medicines from trusted pharmacies, and get them delivered to your doorstep.",
                        illustrationUri = uri.toString(),
                        textColor = 0L,
                        bodyColor = 0L
                    )
                )
                addPages(
                    OnBoardingPage(
                        title = "We're Here for You",
                        body = "Need help? Our support team is available around the clock to assist you with your healthcare needs.",
                        illustrationUri = uri.toString(),
                        textColor = 0L,
                        bodyColor = 0L
                    )
                )

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