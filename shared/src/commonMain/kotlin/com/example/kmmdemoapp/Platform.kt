package com.example.kmmdemoapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform