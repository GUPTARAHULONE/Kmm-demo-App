package com.example.kmmdemoapp

class Calculate {
    private val platform: Platform = getPlatform()

    private fun add(firstNumber: String, secondNumber: String): String {
        return if (firstNumber.isEmpty() && secondNumber.isEmpty())
            "0.0"
        else if (firstNumber.isEmpty())
            secondNumber
        else if (secondNumber.isEmpty())
            firstNumber
        else
            (firstNumber.toDouble() + secondNumber.toDouble()).toString()
    }

    private fun subtract(firstNumber: String, secondNumber: String): String {
        return if (firstNumber.isEmpty() && secondNumber.isEmpty())
            "0.0"
        else if (firstNumber.isEmpty())
            secondNumber
        else if (secondNumber.isEmpty())
            firstNumber
        else
            (firstNumber.toDouble() - secondNumber.toDouble()).toString()
    }

    private fun multiply(firstNumber: String, secondNumber: String): String {
        return if (firstNumber.isEmpty() && secondNumber.isEmpty())
            "0.0"
        else if (firstNumber.isEmpty())
            secondNumber
        else if (secondNumber.isEmpty())
            firstNumber
        else
            (firstNumber.toDouble() * secondNumber.toDouble()).toString()
    }

    private fun divide(firstNumber: String, secondNumber: String): String {
        return if (firstNumber.isEmpty() && secondNumber.isEmpty())
            "0.0"
        else if (firstNumber.isEmpty())
            secondNumber
        else if (secondNumber.isEmpty())
            firstNumber
        else
            (firstNumber.toDouble() / secondNumber.toDouble()).toString()
    }

    fun selectedOption(chosenOption: String, input1: String, input2: String): String {
        return when (chosenOption) {
            "Add" -> add(input1, input2)
            "Subtract" -> subtract(input1, input2)
            "Multiply" -> multiply(input1, input2)
            "Divide" -> divide(input1, input2)
            else -> ""
        }
    }
}