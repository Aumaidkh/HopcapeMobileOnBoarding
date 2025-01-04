package com.hopcape.api

import com.hopcape.api.config.OnBoardingConfig
import com.hopcape.api.config.OnBoardingConfigBuilder

interface OnBoardingKit {

    /**
     * */
    fun configure(configBuilder: OnBoardingConfigBuilder.() -> OnBoardingConfig)

    fun start(
        onComplete: () -> Unit
    )
}