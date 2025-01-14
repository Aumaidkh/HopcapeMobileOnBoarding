package com.hopcape.api.launcher

import android.app.Activity
import android.content.Intent
import com.hopcape.mobile.api.launcher.OnBoardingLauncher
import com.hopcape.presentation.OnBoardingHostActivity

/**
 * Android implementation of the [OnBoardingLauncher] interface for launching the onboarding flow.
 *
 * This class is responsible for initiating the onboarding experience by launching the
 * [OnBoardingHostActivity] in an Android application. The activity passed during initialization
 * is used to start the onboarding flow.
 *
 * @param activity The [Activity] used to launch the onboarding flow.
 *
 * @see OnBoardingLauncher
 * @see OnBoardingHostActivity
 *
 * @author Murtaza Khursheed
 */
class AndroidOnBoardingLauncher(
    private val activity: Activity
): OnBoardingLauncher {

    /**
     * Launches the onboarding flow by starting the [OnBoardingHostActivity].
     *
     * This function creates an [Intent] to launch the [OnBoardingHostActivity], starts the activity,
     * and finishes the current activity to ensure the onboarding process is displayed immediately.
     */
    override fun launchOnBoarding() {
        with(activity) {
            Intent(this, OnBoardingHostActivity::class.java).also {
                startActivity(it)
                finish()
            }
        }
    }
}
