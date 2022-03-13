package com.pelp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.pelp.R
import com.pelp.ui.theme.lightBlue


@Composable
fun LoginScreen(
    navController: NavController
) {

    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(5.dp)) {

        Surface(
            modifier = Modifier.size(60.dp),
            shape = CircleShape
        ) {

            Image(
                painter = painterResource(id = R.drawable.sea),
                contentDescription = "Sea World",
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
            )


        }
        Spacer(modifier = Modifier.padding(10.dp))
        Text(text="Important disclaimers and privacy policy. There are words below. There are some words above too",
            fontSize = 11.sp,
            modifier = Modifier
                .height(50.dp)
                .width(300.dp),
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Light
            )
        val textState = remember {mutableStateOf(TextFieldValue())}
        val textState1 = remember {mutableStateOf(TextFieldValue())}
        Surface(
            shape = RoundedCornerShape(3.dp)
        ) {
            OutlinedTextField(
                value = textState.value,
                onValueChange = { textState.value = it },
                shape = RoundedCornerShape(3.dp),
                label = { Text(text = "Email Address") },
                modifier = Modifier.width(350.dp)

                )
        }
        Surface(
            shape = RoundedCornerShape(3.dp)
        ) {
            OutlinedTextField(
                value = textState1.value,
                onValueChange = { textState1.value = it },
                shape = RoundedCornerShape(3.dp),
                label = { Text(text = "Password") },
                modifier = Modifier.width(350.dp)
                )
        }
        Surface(
            shape = RoundedCornerShape(3.dp), modifier = Modifier.padding(10.dp)

        ) {
            Button(onClick = { navController.navigate(route=Screen.Main.route)
            {
                popUpTo(Screen.Main.route){
                    inclusive=true

                }
            }
                             }, modifier = Modifier
                .width(350.dp)
                .height(50.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = lightBlue)

            ){
                Text(text = "Log in with Email", modifier = Modifier.padding(2.dp),color=Color.White)
            }


        }

       Spacer(modifier = Modifier.padding(100.dp))
        Row() {
            Text(
                text = "Already have a Pelp Account?",
                fontSize = 15.sp,
                modifier = Modifier
                    .height(50.dp)
                    .width(220.dp),
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Normal
            )
            Button(onClick = { /*TODO*/ }, modifier = Modifier
                .height(40.dp)
                .width(100.dp)
                ,

                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red)

            ){
                Text(text = "Sign Up", modifier = Modifier.padding(2.dp),color=Color.White)
            }

        }
    }
}