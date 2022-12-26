package com.example.kmmdemoapp.android

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kmmdemoapp.Calculate

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TwoTextView()
                }
            }
        }
    }
}

@Composable
fun TwoTextView() {
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
        Spacer(modifier = Modifier.padding(top = 30.dp))

         DropDownOption(input1, input2)

    }

}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DropDownOption(input1: String, input2: String) {

    var answer by remember {
        mutableStateOf("")
    }
    val contextForToast = LocalContext.current.applicationContext

    val listItems = arrayOf("Add", "Subtract", "Multiply", "Divide")

    var selectedItem by remember {
        mutableStateOf(listItems[0])
    }

    var expanded by remember {
        mutableStateOf(false)
    }

    // the box
    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = {
            expanded = !expanded
        }
    ) {

        // text field
        TextField(
            value = selectedItem,
            onValueChange = {},
            readOnly = true,
            label = { Text(text = "Select Option") },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(
                    expanded = expanded
                )
            },
            colors = ExposedDropdownMenuDefaults.textFieldColors()
        )

        // menu
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            listItems.forEach { selectedOption ->
                // menu item
                DropdownMenuItem(onClick = {
                    selectedItem = selectedOption
                    answer = Calculate().selectedOption(selectedItem, input1, input2)
                    Toast.makeText(
                        contextForToast,
                        "$selectedOption is selected",
                        Toast.LENGTH_SHORT
                    ).show()
                    expanded = false
                }) {
                    Text(text = selectedOption)
                }
            }
        }
    }

    Text(
        text = "Answer= $answer",
        modifier = Modifier.padding(top = 220.dp, start = 75.dp)
    )
}


@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        //  GreetingView("Hello, Android!")
    }
}
