package com.hopcape.api

import com.hopcape.api.config.OnBoardingConfig
import com.hopcape.api.config.OnBoardingConfigBuilder

interface OnBoardingKit {

    companion object {
        var configuration: OnBoardingConfig? = null
    }
    /**
     * */
    fun configure(
        context: OnBoardingContext,
        configBuilder: OnBoardingConfigBuilder.() -> OnBoardingConfig
    )

    fun start(
        onComplete: () -> Unit
    )
}