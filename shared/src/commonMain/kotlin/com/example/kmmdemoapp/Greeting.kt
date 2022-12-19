package com.example.kmmdemoapp

class Greeting {
    private val platform: Platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }
    fun add(firstNumber:String,secondNumber:String):String{
        return (firstNumber.toDouble()+secondNumber.toDouble()).toString()
    }
}