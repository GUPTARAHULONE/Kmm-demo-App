package com.example.kmmdemoapp

class Greeting {
    private val platform: Platform = getPlatform()

    fun add(firstNumber: String, secondNumber: String): String {
        return if (firstNumber.isEmpty() && secondNumber.isEmpty())
            "0.0"
        else if (firstNumber.isEmpty())
            secondNumber
        else if (secondNumber.isEmpty())
            firstNumber
        else
            (firstNumber.toDouble() + secondNumber.toDouble()).toString()
    }

    fun subtract(firstNumber: String, secondNumber: String): String {
        return if (firstNumber.isEmpty() && secondNumber.isEmpty())
            "0.0"
        else if (firstNumber.isEmpty())
            secondNumber
        else if (secondNumber.isEmpty())
            firstNumber
        else
            (firstNumber.toDouble() - secondNumber.toDouble()).toString()
    }

    fun multiply(firstNumber: String, secondNumber: String): String {
        return if (firstNumber.isEmpty() && secondNumber.isEmpty())
            "0.0"
        else if (firstNumber.isEmpty())
            secondNumber
        else if (secondNumber.isEmpty())
            firstNumber
        else
            (firstNumber.toDouble()*secondNumber.toDouble()).toString()
    }

    fun divide(firstNumber: String, secondNumber: String): String {
        return if (firstNumber.isEmpty() && secondNumber.isEmpty())
            "0.0"
        else if (firstNumber.isEmpty())
            secondNumber
        else if (secondNumber.isEmpty())
            firstNumber
        else
            (firstNumber.toDouble()/secondNumber.toDouble()).toString()
    }
}