package com.hopcape.api

import com.hopcape.api.config.OnBoardingConfig
import com.hopcape.api.config.OnBoardingConfigBuilder

class OnBoardingKitImpl: OnBoardingKit {
    /**
     * */
    override fun configure(
        context: OnBoardingContext,
        configBuilder: OnBoardingConfigBuilder.() -> OnBoardingConfig
    ) {
        val onBoardingConfigBuilder = OnBoardingConfigBuilder()
        OnBoardingKit.configuration = onBoardingConfigBuilder.configBuilder()
    }

    override fun start(onComplete: () -> Unit) {
        if (OnBoardingKit.configuration == null){
            throw IllegalStateException("No Onboarding config found, did you forget to call configure")
        }
        if (isUserAlreadyOnBoarded()){
            onComplete()
            return
        }

        //OnBoardingKit.configuration?.context?.launchOnBoarding()
    }

    private fun isUserAlreadyOnBoarded(): Boolean {
        return false
    }
}