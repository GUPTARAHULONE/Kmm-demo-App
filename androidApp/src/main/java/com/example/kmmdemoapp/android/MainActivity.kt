package com.example.kmmdemoapp.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
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
    var input1 by rememberSaveable { mutableStateOf("0") }
    var input2 by rememberSaveable { mutableStateOf("0") }


    Column (modifier = Modifier
        .fillMaxWidth()
        .padding(60.dp)){

        OutlinedTextField(value = input1,
            onValueChange = { value ->
                input1 = value
            },
        )


        Spacer(modifier = Modifier.padding(top = 20.dp))

        OutlinedTextField(value = input2,
            onValueChange = { value ->
                input2 = value
            })
        Spacer(modifier = Modifier.padding(top = 40.dp))

        Text(text = Greeting().add(input1, input2))
    }

}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
      //  GreetingView("Hello, Android!")
    }
}
