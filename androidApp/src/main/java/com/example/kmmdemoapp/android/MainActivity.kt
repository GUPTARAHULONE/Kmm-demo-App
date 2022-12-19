package com.example.kmmdemoapp.android

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kmmdemoapp.Greeting

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    GreetingView()
                }
            }
        }
    }
}

@Composable
fun GreetingView() {
    var input1 by remember { mutableStateOf("") }
    var input2 by remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(60.dp)
    ) {

        OutlinedTextField(
            value = input1,
            onValueChange = { value ->
                input1 = value
            },
            label = { Text("Enter First Value") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
        )


        Spacer(modifier = Modifier.padding(top = 20.dp))

        OutlinedTextField(
            value = input2,
            onValueChange = { value ->
                input2 = value
            },
            label = { Text("Enter Second Value") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
        )
        Spacer(modifier = Modifier.padding(top = 50.dp))



        Text(
            text = "Answer= " + Greeting().add(input1, input2),
            modifier = Modifier.padding(20.dp))
    }

}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        //  GreetingView("Hello, Android!")
    }
}
