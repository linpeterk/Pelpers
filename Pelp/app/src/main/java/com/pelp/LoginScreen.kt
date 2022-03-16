package com.pelp

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
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
    navController: NavController ,
) {
    Log.d(Examples.TAG,"Hello from Login")
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
        Text(text="Disclaimers and privacy policy. There are words below, and here are some more words. There are words above too",
            fontSize = 11.sp,
            modifier = Modifier
                .height(50.dp)
                .width(300.dp),
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Light
            )
        var userName by rememberSaveable { mutableStateOf("")}
        var result by rememberSaveable {mutableStateOf("admin/admin")}

        var password by rememberSaveable {mutableStateOf("")}
        Surface(
            shape = RoundedCornerShape(3.dp)
        ) {
            OutlinedTextField(
                value = userName,
                onValueChange = { userName = it },
                shape = RoundedCornerShape(3.dp),
                label = { Text(text = "User Name") },
                modifier = Modifier.width(350.dp)

                )
        }
        Surface(
            shape = RoundedCornerShape(3.dp)
        ) {
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                shape = RoundedCornerShape(3.dp),
                label = { Text(text = "Password") },
                modifier = Modifier.width(350.dp)
                )
        }
        Surface(
            shape = RoundedCornerShape(3.dp), modifier = Modifier.padding(10.dp)

        ) {
            Button(onClick = { //userName
                if(Database.data.loginVerify(userName, password)){
                navController.navigate(route=Screen.Main.route)}
              else{
                    result= "These credential does not match our record"
                }
            {
            //    popUpTo(Screen.Main.route){
            //        inclusive=true

         //       }
            }
                             }, modifier = Modifier
                .width(350.dp)
                .height(50.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = lightBlue)

            ){
                Text(text = "Log in with Email", modifier = Modifier.padding(2.dp),color=Color.White)
            }


        }
        Text(text=result)
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
            Button(onClick = {
                             navController.navigate(Screen.Signup.route)
            }, modifier = Modifier
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