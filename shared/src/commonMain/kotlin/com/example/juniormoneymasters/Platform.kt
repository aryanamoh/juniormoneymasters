package com.example.juniormoneymasters

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform