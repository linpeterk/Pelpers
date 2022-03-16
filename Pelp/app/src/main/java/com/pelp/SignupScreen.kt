package com.pelp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun SignupScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(8.dp)
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Fields()
        }
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(onClick = { /*TODO*/ }) {
                Text("Sign Up")
            }
        }
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "Pelp, Yelp for Poop")
        }
        Spacer(modifier = Modifier
            .weight(1f)
        )
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.Center
        ){
            Button(onClick = {
                navController.navigate(Screen.Login.route)
            }) {
                Text("Login with Email")
            }
        }
    }
}

@Composable
fun Fields() {
    Column(Modifier.padding(16.dp)) {
        Row {
            val firstName = remember { mutableStateOf(TextFieldValue())}
            TextField(
                value = firstName.value,
                onValueChange = {firstName.value = it},
                placeholder = { Text(text = "First Name")}
            )
        }
        Row {
            val lastName = remember { mutableStateOf(TextFieldValue())}
            TextField (
                value = lastName.value,
                onValueChange = {lastName.value = it},
                placeholder = {Text(text = "Last Name")}
            )
        }
        Row {
            val email = remember { mutableStateOf(TextFieldValue())}
            TextField(
                value = email.value,
                onValueChange = {email.value = it},
                placeholder = { Text(text = "Email Address")}
            )
        }
        Row {
            val password = remember { mutableStateOf(TextFieldValue())}
            TextField(
                value = password.value,
                onValueChange = {password.value = it},
                placeholder = { Text(text = "password")}
            )
        }

        Row {
            val zip = remember { mutableStateOf(TextFieldValue()) }
            TextField(
                value = zip.value,
                onValueChange = { zip.value = it },
                placeholder = { Text(text = "zip code") }
            )
        }


    }
}