package com.hopcape.onboarding

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform