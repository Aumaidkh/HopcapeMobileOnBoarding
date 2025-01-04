package com.hopcape.api

import com.hopcape.api.config.OnBoardingConfig
import com.hopcape.api.config.OnBoardingConfigBuilder

class OnBoardingKitImpl: OnBoardingKit {

    private lateinit var config: OnBoardingConfig
    /**
     * */
    override fun configure(configBuilder: OnBoardingConfigBuilder.() -> OnBoardingConfig) {
        val onBoardingConfigBuilder = OnBoardingConfigBuilder()
        config = onBoardingConfigBuilder.configBuilder()
    }

    override fun start(onComplete: () -> Unit) {
        if (!::config.isInitialized){
            throw IllegalStateException("No Onboarding config found, did you forget to call configure")
        }
    }
}